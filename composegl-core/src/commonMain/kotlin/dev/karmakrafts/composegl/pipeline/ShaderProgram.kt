/*
 * Copyright 2025 (C) Karma Krafts & associates
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.karmakrafts.composegl.pipeline

import dev.karmakrafts.composegl.GLRenderScope
import dev.karmakrafts.composegl.GLRenderScopeDsl
import dev.karmakrafts.composegl.gles.GLES20
import dev.karmakrafts.composegl.gles.GLESShaderProgram
import dev.karmakrafts.composegl.gles.GLESUniformLocation
import dev.karmakrafts.composegl.gles.glesNoShaderProgram
import dev.karmakrafts.composegl.util.Log

class ShaderProgram private constructor( // @formatter:off
    private val impl: GLES20,
    private val stages: List<Shader>,
    val format: VertexFormat
) : Resource { // @formatter:on
    companion object {
        @GLRenderScopeDsl
        fun GLRenderScope.shaderProgram(format: VertexFormat, vararg stages: Shader): ShaderProgram =
            ShaderProgram(this, stages.toList(), format)

        @GLRenderScopeDsl
        fun GLRenderScope.shaderProgram(format: VertexFormat, stages: List<Shader>): ShaderProgram =
            ShaderProgram(this, stages, format)
    }

    val handle: GLESShaderProgram = impl.glCreateProgram()
    private var isDisposed = false
    private var needsRelink: Boolean = false
    private val uniformLocations: HashMap<String, GLESUniformLocation> = HashMap()

    var isLinked: Boolean = false
        private set

    init {
        for (stage in stages) impl.glAttachShader(handle, stage.handle)
        Log.debug { "Created shader program $handle" }
    }

    private fun link() = with(impl) {
        isLinked = false
        for (stage in stages) stage.compile()
        glLinkProgram(handle)
        if (glGetProgrami(handle, GL_LINK_STATUS) == GL_FALSE) {
            error("Could not link program $handle: ${glGetProgramInfoLog(handle) ?: "unknown error"}")
        }
        var index = 0
        for (element in format.elements) {
            impl.glBindAttribLocation(handle, index++, element.name)
        }
        //glValidateProgram(handle)
        //if (glGetProgrami(handle, GL_VALIDATE_STATUS) == GL_FALSE) {
        //    error("Could not validate program $handle: ${glGetProgramInfoLog(handle) ?: "unknown error"}")
        //}
        isLinked = true
    }

    fun getUniformLocation(name: String): GLESUniformLocation = with(impl) {
        return uniformLocations.getOrPut(name) {
            glGetUniformLocation(handle, name) ?: error("Could not obtain uniform location for uniform '$name'")
        }
    }

    fun requestRelink() {
        needsRelink = true
    }

    fun uniform1i(name: String, x: Int) = with(impl) {
        glUniform1i(getUniformLocation(name), x)
    }

    fun uniform2i(name: String, x: Int, y: Int) = with(impl) {
        glUniform2i(getUniformLocation(name), x, y)
    }

    fun uniform3i(name: String, x: Int, y: Int, z: Int) = with(impl) {
        glUniform3i(getUniformLocation(name), x, y, z)
    }

    fun uniform4i(name: String, x: Int, y: Int, z: Int, w: Int) = with(impl) {
        glUniform4i(getUniformLocation(name), x, y, z, w)
    }

    fun uniform1f(name: String, x: Float) = with(impl) {
        glUniform1f(getUniformLocation(name), x)
    }

    fun uniform2f(name: String, x: Float, y: Float) = with(impl) {
        glUniform2f(getUniformLocation(name), x, y)
    }

    fun uniform3f(name: String, x: Float, y: Float, z: Float) = with(impl) {
        glUniform3f(getUniformLocation(name), x, y, z)
    }

    fun uniform4f(name: String, x: Float, y: Float, z: Float, w: Float) = with(impl) {
        glUniform4f(getUniformLocation(name), x, y, z, w)
    }

    fun bind() {
        if (needsRelink || !isLinked) {
            link()
            needsRelink = false
        }
        if (!isLinked) return
        impl.glUseProgram(handle)
    }

    fun unbind() = impl.glUseProgram(glesNoShaderProgram)

    override fun dispose() {
        if (isDisposed) return
        for (stage in stages) {
            impl.glDetachShader(handle, stage.handle)
            stage.dispose()
        }
        impl.glDeleteProgram(handle)
        Log.debug { "Disposed shader program $handle" }
        isDisposed = true
    }
}