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

enum class TextureFormat(
    internal val internalFormatGetter: GLES20.() -> Int,
    internal val formatGetter: GLES20.() -> Int,
    internal val typeGetter: GLES20.() -> Int
) {
    // @formatter:off
    RGB_8UI     ({ GL_RGB },                { GL_RGB },             { GL_UNSIGNED_BYTE }),
    RGB_32F     ({ GL_RGB },                { GL_RGB },             { GL_FLOAT }),
    RGBA_8UI    ({ GL_RGBA },               { GL_RGBA },            { GL_UNSIGNED_BYTE }),
    RGBA_32F    ({ GL_RGBA },               { GL_RGBA },            { GL_FLOAT }),
    DEPTH_16    ({ GL_DEPTH_COMPONENT16 },  { GL_DEPTH_COMPONENT }, { GL_UNSIGNED_SHORT }),
    STENCIL_8   ({ GL_STENCIL_INDEX8 },     { GL_STENCIL_INDEX },   { GL_UNSIGNED_BYTE });
    // @formatter:on
}

enum class TextureFilter(private val typeGetter: GLES20.() -> Int) {
    // @formatter:off
    NEAREST ({ GL_NEAREST }),
    LINEAR  ({ GL_LINEAR });
    // @formatter:on

    internal operator fun invoke(impl: GLES20): Int = impl.typeGetter()
}

enum class TextureWrapMode(private val typeGetter: GLES20.() -> Int) {
    // @formatter:off
    CLAMP_TO_EDGE({ GL_CLAMP_TO_EDGE }),
    REPEAT       ({ GL_REPEAT });
    // @formatter:on

    internal operator fun invoke(impl: GLES20): Int = impl.typeGetter()
}

class Texture private constructor( // @formatter:off
    private val impl: GLES20,
    val format: TextureFormat,
    initialWidth: Int,
    initialHeight: Int,
    minFilter: TextureFilter,
    magFilter: TextureFilter,
    wrapModeS: TextureWrapMode,
    wrapModeT: TextureWrapMode
) : BindableResource { // @formatter:on
    companion object {
        @GLRenderScopeDsl
        fun GLRenderScope.texture(
            format: TextureFormat,
            width: Int = 0,
            height: Int = 0,
            minFilter: TextureFilter = TextureFilter.NEAREST,
            magFilter: TextureFilter = TextureFilter.NEAREST,
            wrapModeS: TextureWrapMode = TextureWrapMode.CLAMP_TO_EDGE,
            wrapModeT: TextureWrapMode = TextureWrapMode.CLAMP_TO_EDGE
        ): Texture = Texture(this, format, width, height, minFilter, magFilter, wrapModeS, wrapModeT)
    }

    val handle: GLESTexture = impl.glGenTexture()
    private var isDisposed: Boolean = false

    init {
        use<Unit> {
            impl.glTexParameteri(impl.GL_TEXTURE_2D, impl.GL_TEXTURE_MIN_FILTER, minFilter(impl))
            impl.glTexParameteri(impl.GL_TEXTURE_2D, impl.GL_TEXTURE_MAG_FILTER, magFilter(impl))
            impl.glTexParameteri(impl.GL_TEXTURE_2D, impl.GL_TEXTURE_WRAP_S, wrapModeS(impl))
            impl.glTexParameteri(impl.GL_TEXTURE_2D, impl.GL_TEXTURE_WRAP_T, wrapModeT(impl))
        }
        Log.debug { "Created texture $handle" }
    }

    var width: Int = initialWidth
        private set
    var height: Int = initialHeight
        private set

    var minFilter: TextureFilter = minFilter
        set(value) {
            use { impl.glTexParameteri(impl.GL_TEXTURE_2D, impl.GL_TEXTURE_MIN_FILTER, value(impl)) }
            field = value
        }

    var magFilter: TextureFilter = magFilter
        set(value) {
            use { impl.glTexParameteri(impl.GL_TEXTURE_2D, impl.GL_TEXTURE_MAG_FILTER, value(impl)) }
            field = value
        }

    var wrapModeS: TextureWrapMode = wrapModeS
        set(value) {
            use { impl.glTexParameteri(impl.GL_TEXTURE_2D, impl.GL_TEXTURE_WRAP_S, value(impl)) }
            field = value
        }

    var wrapModeT: TextureWrapMode = wrapModeT
        set(value) {
            use { impl.glTexParameteri(impl.GL_TEXTURE_2D, impl.GL_TEXTURE_WRAP_T, value(impl)) }
            field = value
        }

    override fun bind() = impl.glBindTexture(impl.GL_TEXTURE_2D, handle)
    override fun unbind() = impl.glBindTexture(impl.GL_TEXTURE_2D, glesNoTexture)

    fun upload(width: Int = this.width, height: Int = this.height, buffer: Buffer) = with(impl) {
        use<Unit> {
            glTexImage2D(
                target = GL_TEXTURE_2D,
                level = 0,
                internalformat = format.internalFormatGetter(this),
                width = width,
                height = height,
                border = 0,
                format = format.formatGetter(this),
                type = format.typeGetter(this),
                pixels = buffer.readByteArray(buffer.size.toInt())
            )
        }
        this@Texture.width = width
        this@Texture.height = height
    }

    fun clear(width: Int = this.width, height: Int = this.height) = with(impl) {
        use<Unit> {
            glTexImage2D(
                target = GL_TEXTURE_2D,
                level = 0,
                internalformat = format.internalFormatGetter(this),
                width = width,
                height = height,
                border = 0,
                format = format.formatGetter(this),
                type = format.typeGetter(this),
                pixels = ByteArray(0)
            )
        }
        this@Texture.width = width
        this@Texture.height = height
    }

    override fun dispose() {
        if (isDisposed) return
        impl.glDeleteTexture(handle)
        Log.debug { "Disposed texture $handle" }
        isDisposed = true
    }
}