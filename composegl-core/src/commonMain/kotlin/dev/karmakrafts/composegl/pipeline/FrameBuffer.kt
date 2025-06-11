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
import dev.karmakrafts.composegl.gles.GLESFrameBuffer
import dev.karmakrafts.composegl.gles.glesNoFrameBuffer
import dev.karmakrafts.composegl.util.Log
import dev.karmakrafts.composegl.pipeline.RenderBuffer as RBO
import dev.karmakrafts.composegl.pipeline.Texture as TextureObject

enum class FrameBufferAttachmentType(private val typeGetter: GLES20.() -> Int) {
    // @formatter:off
    COLOR  ({ GL_COLOR_ATTACHMENT0 }),
    DEPTH  ({ GL_DEPTH_ATTACHMENT }),
    STENCIL({ GL_STENCIL_ATTACHMENT });
    // @formatter:on

    internal operator fun invoke(impl: GLES20): Int = impl.typeGetter()
}

sealed interface FrameBufferAttachment {
    val type: FrameBufferAttachmentType

    fun resize(width: Int, height: Int)

    data class Texture(
        override val type: FrameBufferAttachmentType, val texture: TextureObject
    ) : FrameBufferAttachment {
        override fun resize(width: Int, height: Int) {
            texture.clear(width, height)
        }
    }

    data class RenderBuffer(
        override val type: FrameBufferAttachmentType, val buffer: RBO
    ) : FrameBufferAttachment {
        override fun resize(width: Int, height: Int) {
            buffer.storage(width, height)
        }
    }
}

class FrameBuffer private constructor(
    private val impl: GLES20,
    val attachments: List<FrameBufferAttachment>
) : BindableResource {
    companion object {
        @GLRenderScopeDsl
        fun GLRenderScope.frameBuffer(vararg attachments: FrameBufferAttachment): FrameBuffer =
            FrameBuffer(this, attachments.toList())

        @GLRenderScopeDsl
        fun GLRenderScope.frameBuffer(attachments: List<FrameBufferAttachment>): FrameBuffer =
            FrameBuffer(this, attachments)
    }

    val handle: GLESFrameBuffer = impl.glGenFramebuffer()
    private var isDisposed: Boolean = false

    init {
        with(impl) {
            use<Unit> {
                for (attachment in attachments) {
                    val attachmentType = attachment.type(this)
                    when (attachment) {
                        is FrameBufferAttachment.RenderBuffer -> {
                            val rboHandle = attachment.buffer.handle
                            glFramebufferRenderbuffer(GL_FRAMEBUFFER, attachmentType, GL_RENDERBUFFER, rboHandle)
                            Log.debug { "Attached render buffer $rboHandle to framebuffer $handle" }
                        }

                        is FrameBufferAttachment.Texture -> {
                            val textureHandle = attachment.texture.handle
                            glFramebufferTexture2D(GL_FRAMEBUFFER, attachmentType, GL_TEXTURE_2D, textureHandle, 0)
                            Log.debug { "Attached texture $textureHandle to framebuffer $handle" }
                        }
                    }
                }
                val status = glCheckFramebufferStatus(GL_FRAMEBUFFER)
                if (status != GL_FRAMEBUFFER_COMPLETE) {
                    val errorMessage = when (status) {
                        GL_FRAMEBUFFER_UNSUPPORTED -> "framebuffer unsupported"
                        GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT -> "incomplete attachment"
                        GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT -> "missing framebuffer attachment"
                        else -> "unknown error"
                    }
                    error("Could not initialize framebuffer $handle: $errorMessage")
                }
            }
        }
        Log.debug { "Created framebuffer $handle" }
    }

    override fun bind() = impl.glBindFramebuffer(impl.GL_FRAMEBUFFER, handle)
    override fun unbind() = impl.glBindFramebuffer(impl.GL_FRAMEBUFFER, glesNoFrameBuffer)

    fun resize(width: Int, height: Int) {
        for (attachment in attachments) attachment.resize(width, height)
    }

    override fun dispose() = with(impl) {
        if (isDisposed) return@with
        glDeleteFramebuffer(handle)
        Log.debug { "Disposed framebuffer $handle" }
        isDisposed = true
    }
}