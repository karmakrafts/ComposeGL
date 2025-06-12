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
import kotlinx.io.Buffer
import kotlinx.io.readFloat
import kotlinx.io.writeFloat

class VertexBuffer internal constructor( // @formatter:off
    private val impl: GLES20,
    val usage: BufferUsage,
    val format: VertexFormat
) : BindableResource { // @formatter:on
    val handle: GLESBuffer = impl.glGenBuffer()
    private var isDisposed: Boolean = false

    var vertexCount: Int = 0
        private set

    init {
        Log.debug { "Created vertex buffer $handle" }
    }

    override fun dispose() {
        if (isDisposed) return
        impl.glDeleteBuffer(handle)
        Log.debug { "Disposed vertex buffer $handle" }
        isDisposed = true
    }

    override fun bind() = impl.glBindBuffer(impl.GL_ARRAY_BUFFER, handle)
    override fun unbind() = impl.glBindBuffer(impl.GL_ARRAY_BUFFER, glesNoBuffer)

    fun upload(buffer: Buffer) {
        val bufferSize = buffer.size.toInt()
        val formatSize = format.sizeInBytes
        check(bufferSize % formatSize == 0) { "Incomplete vertex buffer data" }
        val data = IntArray(bufferSize / Int.SIZE_BYTES)
        vertexCount = bufferSize / formatSize
        var dataIndex = 0
        for (vertexIndex in 0..<vertexCount) {
            for (element in format.elements) {
                val elementType = element.type
                for (componentIndex in 0..<elementType.componentCount) {
                    data[dataIndex++] = when (elementType.primitiveType) {
                        VertexFormatPrimitiveType.INT -> buffer.readInt()
                        VertexFormatPrimitiveType.FLOAT -> buffer.readFloat().toBits()
                    }
                }
            }
        }
        bind()
        impl.glBufferData(impl.GL_ARRAY_BUFFER, data, usage(impl))
        unbind()
    }
}

class VertexBufferBuilder @PublishedApi internal constructor(
    private val buffer: Buffer
) {
    companion object {
        @PublishedApi
        internal val buffer: Buffer = Buffer()

        @GLRenderScopeDsl
        inline fun GLRenderScope.vertexBuffer(builder: VertexBufferBuilder.() -> Unit): VertexBuffer {
            buffer.clear()
            return VertexBufferBuilder(buffer).apply(builder).build(this)
        }
    }

    var format: VertexFormat = VertexFormat.empty
    var usage: BufferUsage = BufferUsage.STATIC_DRAW

    fun write(x: Int) = buffer.writeInt(x)

    fun write(x: Int, y: Int) {
        buffer.writeInt(x)
        buffer.writeInt(y)
    }

    fun write(x: Int, y: Int, z: Int) {
        buffer.writeInt(x)
        buffer.writeInt(y)
        buffer.writeInt(z)
    }

    fun write(x: Int, y: Int, z: Int, w: Int) {
        buffer.writeInt(x)
        buffer.writeInt(y)
        buffer.writeInt(z)
        buffer.writeInt(w)
    }

    fun write(x: Float) = buffer.writeFloat(x)

    fun write(x: Float, y: Float) {
        buffer.writeFloat(x)
        buffer.writeFloat(y)
    }

    fun write(x: Float, y: Float, z: Float) {
        buffer.writeFloat(x)
        buffer.writeFloat(y)
        buffer.writeFloat(z)
    }

    fun write(x: Float, y: Float, z: Float, w: Float) {
        buffer.writeFloat(x)
        buffer.writeFloat(y)
        buffer.writeFloat(z)
        buffer.writeFloat(w)
    }

    @PublishedApi
    internal fun build(impl: GLES20): VertexBuffer = VertexBuffer(impl, usage, format).apply {
        upload(buffer)
    }
}