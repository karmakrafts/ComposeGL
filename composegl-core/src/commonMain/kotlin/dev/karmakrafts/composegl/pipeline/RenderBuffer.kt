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
import dev.karmakrafts.composegl.gles.GLESRenderBuffer
import dev.karmakrafts.composegl.gles.glesNoRenderBuffer
import dev.karmakrafts.composegl.util.Log

class RenderBuffer(
    @PublishedApi internal val impl: GLES20
) : BindableResource {
    companion object {
        @GLRenderScopeDsl
        fun GLRenderScope.renderBuffer(): RenderBuffer = RenderBuffer(this)
    }

    val handle: GLESRenderBuffer = impl.glGenRenderbuffer()
    private var isDisposed: Boolean = false

    inline val internalFormat: Int
        get() = use { impl.glGetRenderbufferParameteri(impl.GL_RENDERBUFFER, impl.GL_RENDERBUFFER_INTERNAL_FORMAT) }
    inline val width: Int
        get() = use { impl.glGetRenderbufferParameteri(impl.GL_RENDERBUFFER, impl.GL_RENDERBUFFER_WIDTH) }
    inline val height: Int
        get() = use { impl.glGetRenderbufferParameteri(impl.GL_RENDERBUFFER, impl.GL_RENDERBUFFER_HEIGHT) }

    init {
        Log.debug { "Created render buffer $handle" }
    }

    override fun bind() = impl.glBindRenderbuffer(impl.GL_RENDERBUFFER, handle)
    override fun unbind() = impl.glBindRenderbuffer(impl.GL_RENDERBUFFER, glesNoRenderBuffer)

    fun storage(width: Int, height: Int, internalFormat: Int = this.internalFormat) = with(impl) {
        bind()
        glRenderbufferStorage(GL_RENDERBUFFER, internalFormat, width, height)
        unbind()
    }

    override fun dispose() = with(impl) {
        if (isDisposed) return@with
        glDeleteRenderbuffer(handle)
        Log.debug { "Disposed render buffer $handle" }
        isDisposed = true
    }
}