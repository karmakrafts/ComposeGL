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
import dev.karmakrafts.composegl.gles.GLESShader
import dev.karmakrafts.composegl.util.Log
import org.intellij.lang.annotations.Language

class Shader private constructor( // @formatter:off
    private val impl: GLES20,
    val stage: ShaderStage,
    val source: String
) : Resource { // @formatter:on
    companion object {
        @GLRenderScopeDsl
        fun GLRenderScope.shader( // @formatter:off
            stage: ShaderStage,
            @Language("glsl") source: String
        ): Shader = Shader(this, stage, source) // @formatter:on
    }

    val handle: GLESShader = impl.glCreateShader(stage(impl))
    private var isDisposed: Boolean = false

    var isCompiled: Boolean = false
        private set

    init {
        Log.debug { "Created shader $handle for stage $stage" }
    }

    internal fun compile() = with(impl) {
        isCompiled = false
        glShaderSource(handle, source)
        glCompileShader(handle)
        if (glGetShaderi(handle, GL_COMPILE_STATUS) == GL_FALSE) {
            error("Could not compile shader $handle: ${glGetShaderInfoLog(handle) ?: "unknown error"}")
        }
        isCompiled = true
    }

    override fun dispose() {
        if (isDisposed) return
        impl.glDeleteShader(handle)
        Log.debug { "Disposed shader $handle for stage $stage" }
        isDisposed = true
    }
}