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
import dev.karmakrafts.composegl.gles.GLESTexture
import dev.karmakrafts.composegl.gles.glesNoTexture
import dev.karmakrafts.composegl.util.Log
import kotlinx.io.Buffer
import kotlinx.io.readByteArray

class Texture private constructor(
    private val impl: GLES20
) : Resource {
    companion object {
        @GLRenderScopeDsl
        fun GLRenderScope.texture(): Texture = Texture(this)
    }

    val handle: GLESTexture = impl.glGenTexture()
    private var isDisposed: Boolean = false

    init {
        Log.debug { "Created texture $handle" }
    }

    fun bind() = impl.glBindTexture(impl.GL_TEXTURE_2D, handle)
    fun unbind() = impl.glBindTexture(impl.GL_TEXTURE_2D, glesNoTexture)

    fun upload( // @formatter:off
        width: Int,
        height: Int,
        internalFormat: Int,
        format: Int,
        type: Int,
        buffer: Buffer
    ) = with(impl) { // @formatter:on
        bind()
        glTexImage2D(
            target = GL_TEXTURE_2D,
            level = 0,
            internalformat = internalFormat,
            width = width,
            height = height,
            border = 0,
            format = format,
            type = type,
            pixels = buffer.readByteArray(buffer.size.toInt())
        )
        unbind()
    }

    override fun dispose() {
        if (isDisposed) return
        impl.glDeleteTexture(handle)
        Log.debug { "Disposed texture $handle" }
        isDisposed = true
    }
}