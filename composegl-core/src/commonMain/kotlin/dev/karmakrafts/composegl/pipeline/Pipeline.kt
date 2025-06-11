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
import dev.karmakrafts.composegl.util.Log

class Pipeline private constructor( // @formatter:off
    val impl: GLES20,
    val vbo: VertexBuffer,
    val ibo: IndexBuffer,
    val program: ShaderProgram
) : Resource { // @formatter:on
    companion object {
        @GLRenderScopeDsl
        fun GLRenderScope.pipeline( // @formatter:off
            vbo: VertexBuffer,
            ibo: IndexBuffer,
            program: ShaderProgram
        ): Pipeline = Pipeline(this, vbo, ibo, program) // @formatter:on
    }

    init {
        Log.debug { "Created pipeline [VBO:${vbo.handle}/IBO:${ibo.handle}/PRG:${program.handle}]" }
    }

    override fun dispose() {
        Log.debug { "Disposing pipeline [VBO:${vbo.handle}/IBO:${ibo.handle}/PRG:${program.handle}]" }
        program.dispose()
        ibo.dispose()
        vbo.dispose()
    }

    fun enableVAAs() = with(impl) {
        var index = 0
        val formatSize = vbo.format.sizeInBytes
        var offset = 0L
        for (element in vbo.format.elements) {
            val elementType = element.type
            glEnableVertexAttribArray(index)
            glVertexAttribPointer(
                index = index,
                size = elementType.componentCount,
                type = elementType.primitiveType(impl),
                normalized = false,
                stride = formatSize,
                offset = offset
            )
            offset += element.sizeInBytes
            ++index
        }
    }

    fun disableVAAs() = with(impl) {
        for (index in vbo.format.elements.indices) {
            glDisableVertexAttribArray(index)
        }
    }

    fun draw(mode: Int, offset: Long = 0L) = with(impl) {
        program.bind()
        vbo.bind()
        ibo.bind()
        enableVAAs()
        glDrawElements(mode, ibo.indexCount, ibo.format(impl), offset)
        disableVAAs()
        ibo.unbind()
        vbo.unbind()
        program.unbind()
    }
}