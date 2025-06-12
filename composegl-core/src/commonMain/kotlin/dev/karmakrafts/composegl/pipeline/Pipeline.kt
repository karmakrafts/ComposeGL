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
import dev.karmakrafts.composegl.gles.GLESExtVertexArrayObject
import dev.karmakrafts.composegl.util.Log

interface Pipeline : Resource {
    companion object {
        @GLRenderScopeDsl
        fun GLRenderScope.pipeline( // @formatter:off
            vertexBuffer: VertexBuffer,
            indexBuffer: IndexBuffer,
            program: ShaderProgram
        ): Pipeline { // @formatter:on
            return if (GLESExtVertexArrayObject.NAME in this) VaoPipeline(this, vertexBuffer, indexBuffer, program)
            else DynamicPipeline(this, vertexBuffer, indexBuffer, program)
        }
    }

    val vbo: VertexBuffer
    val ibo: IndexBuffer
    val program: ShaderProgram
    fun draw(mode: Int, offset: Long = 0L)
}

private class DynamicPipeline( // @formatter:off
    val impl: GLES20,
    override val vbo: VertexBuffer,
    override val ibo: IndexBuffer,
    override val program: ShaderProgram
) : Pipeline { // @formatter:on
    init {
        Log.debug { "Created dynamic pipeline [VBO:${vbo.handle}/IBO:${ibo.handle}/PRG:${program.handle}]" }
    }

    override fun dispose() {
        Log.debug { "Disposing dynamic pipeline [VBO:${vbo.handle}/IBO:${ibo.handle}/PRG:${program.handle}]" }
        ibo.dispose()
        vbo.dispose()
        program.dispose()
    }

    override fun draw(mode: Int, offset: Long) = with(impl) {
        program.bind()
        vbo.bind()
        ibo.bind()
        vbo.format.enableVAAs(impl)
        glDrawElements(mode, ibo.indexCount, ibo.format(impl), offset)
        vbo.format.disableVAAs(impl)
        ibo.unbind()
        vbo.unbind()
        program.unbind()
    }
}

private class VaoPipeline( // @formatter:off
    val impl: GLES20,
    override val vbo: VertexBuffer,
    override val ibo: IndexBuffer,
    override val program: ShaderProgram
) : Pipeline { // @formatter:on
    val vao: VertexArrayObject = VertexArrayObject(impl)

    init {
        // Attach VBO, IBO and attrib pointers to our VAO and validate program
        vao.use {
            vbo.bind()
            ibo.bind()
            vbo.format.enableVAAs(impl)
            program.validate()
        }
        Log.debug { "Created VAO pipeline [VBO:${vbo.handle}/IBO:${ibo.handle}/PRG:${program.handle}/VAO:${vao.handle}]" }
    }

    override fun dispose() {
        Log.debug { "Disposing VAO pipeline [VBO:${vbo.handle}/IBO:${ibo.handle}/PRG:${program.handle}/VAO:${vao.handle}]" }
        vao.dispose()
        ibo.dispose()
        vbo.dispose()
        program.dispose()
    }

    override fun draw(mode: Int, offset: Long) = with(impl) {
        program.bind()
        vao.bind()
        glDrawElements(mode, ibo.indexCount, ibo.format(impl), offset)
        vao.unbind()
        program.unbind()
    }
}