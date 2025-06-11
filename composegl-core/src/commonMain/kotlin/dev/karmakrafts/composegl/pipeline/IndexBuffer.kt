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
import dev.karmakrafts.composegl.gles.GLESBuffer
import dev.karmakrafts.composegl.gles.glesNoBuffer
import dev.karmakrafts.composegl.util.Log
import dev.karmakrafts.composegl.util.readIntArray
import dev.karmakrafts.composegl.util.readShortArray
import kotlinx.io.Buffer
import kotlinx.io.readByteArray
import kotlinx.io.writeUByte
import kotlinx.io.writeUInt
import kotlinx.io.writeUShort

class IndexBuffer internal constructor( // @formatter:off
    private val impl: GLES20,
    val format: IndexFormat,
    val usage: BufferUsage
) : Resource { // @formatter:on
    val handle: GLESBuffer = impl.glGenBuffer()
    private var isDisposed: Boolean = false

    var indexCount: Int = 0
        private set

    init {
        Log.debug { "Created index buffer $handle" }
    }

    override fun dispose() {
        if (isDisposed) return
        impl.glDeleteBuffer(handle)
        Log.debug { "Disposed index buffer $handle" }
        isDisposed = true
    }

    fun bind() = impl.glBindBuffer(impl.GL_ELEMENT_ARRAY_BUFFER, handle)
    fun unbind() = impl.glBindBuffer(impl.GL_ELEMENT_ARRAY_BUFFER, glesNoBuffer)

    fun upload(buffer: Buffer) {
        val bufferSize = buffer.size.toInt()
        val formatSize = format.sizeInBytes
        check(bufferSize % formatSize == 0) { "Incomplete index buffer data" }
        indexCount = bufferSize / formatSize
        bind()
        when(format) { // @formatter:off
            IndexFormat.UBYTE ->
                impl.glBufferData(impl.GL_ELEMENT_ARRAY_BUFFER, buffer.readByteArray(indexCount), usage(impl))
            IndexFormat.USHORT ->
                impl.glBufferData(impl.GL_ELEMENT_ARRAY_BUFFER, buffer.readShortArray(indexCount), usage(impl))
            IndexFormat.UINT ->
                impl.glBufferData(impl.GL_ELEMENT_ARRAY_BUFFER, buffer.readIntArray(indexCount), usage(impl))
        } // @formatter:on
        unbind()
    }
}

class IndexBufferBuilder @PublishedApi internal constructor(
    private val buffer: Buffer
) {
    companion object {
        @PublishedApi
        internal val buffer: Buffer = Buffer()

        @GLRenderScopeDsl
        inline fun GLRenderScope.indexBuffer(builder: IndexBufferBuilder.() -> Unit): IndexBuffer {
            buffer.clear()
            return IndexBufferBuilder(buffer).apply(builder).build(this)
        }
    }

    var format: IndexFormat = IndexFormat.USHORT
    var usage: BufferUsage = BufferUsage.STATIC_DRAW

    fun write(index: UByte) = buffer.writeUByte(index)

    fun write(i1: UByte, i2: UByte) {
        buffer.writeUByte(i1)
        buffer.writeUByte(i2)
    }

    fun write(i1: UByte, i2: UByte, i3: UByte) {
        buffer.writeUByte(i1)
        buffer.writeUByte(i2)
        buffer.writeUByte(i3)
    }

    fun write(i1: UByte, i2: UByte, i3: UByte, i4: UByte) {
        buffer.writeUByte(i1)
        buffer.writeUByte(i2)
        buffer.writeUByte(i3)
        buffer.writeUByte(i4)
    }

    fun write(index: UShort) = buffer.writeUShort(index)

    fun write(i1: UShort, i2: UShort) {
        buffer.writeUShort(i1)
        buffer.writeUShort(i2)
    }

    fun write(i1: UShort, i2: UShort, i3: UShort) {
        buffer.writeUShort(i1)
        buffer.writeUShort(i2)
        buffer.writeUShort(i3)
    }

    fun write(i1: UShort, i2: UShort, i3: UShort, i4: UShort) {
        buffer.writeUShort(i1)
        buffer.writeUShort(i2)
        buffer.writeUShort(i3)
        buffer.writeUShort(i4)
    }

    fun write(index: UInt) = buffer.writeUInt(index)

    fun write(i1: UInt, i2: UInt) {
        buffer.writeUInt(i1)
        buffer.writeUInt(i2)
    }

    fun write(i1: UInt, i2: UInt, i3: UInt) {
        buffer.writeUInt(i1)
        buffer.writeUInt(i2)
        buffer.writeUInt(i3)
    }

    fun write(i1: UInt, i2: UInt, i3: UInt, i4: UInt) {
        buffer.writeUInt(i1)
        buffer.writeUInt(i2)
        buffer.writeUInt(i3)
        buffer.writeUInt(i4)
    }

    @PublishedApi
    internal fun build(impl: GLES20): IndexBuffer = IndexBuffer(impl, format, usage).apply {
        upload(buffer)
    }
}