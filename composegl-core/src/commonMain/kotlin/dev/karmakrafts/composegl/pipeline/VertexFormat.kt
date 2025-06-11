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

import dev.karmakrafts.composegl.gles.GLES20
import kotlin.jvm.JvmInline

enum class VertexFormatPrimitiveType(
    val sizeInBytes: Int, val typeGetter: GLES20.() -> Int
) {
    // @formatter:off
    FLOAT(Float.SIZE_BYTES, { GL_FLOAT }),
    INT  (Int.SIZE_BYTES,   { GL_INT });
    // @formatter:on

    internal operator fun invoke(impl: GLES20): Int = impl.typeGetter()
}

enum class VertexFormatElementType( // @formatter:off
    val primitiveType: VertexFormatPrimitiveType,
    val componentCount: Int
) { // @formatter:on
    // @formatter:off
    FLOAT   (VertexFormatPrimitiveType.FLOAT, 1),
    FLOAT_2 (VertexFormatPrimitiveType.FLOAT, 2),
    FLOAT_3 (VertexFormatPrimitiveType.FLOAT, 3),
    FLOAT_4 (VertexFormatPrimitiveType.FLOAT, 4),
    INT     (VertexFormatPrimitiveType.INT, 1),
    INT_2   (VertexFormatPrimitiveType.INT, 2),
    INT_3   (VertexFormatPrimitiveType.INT, 3),
    INT_4   (VertexFormatPrimitiveType.INT, 4);
    // @formatter:on

    inline val sizeInBytes: Int
        get() = primitiveType.sizeInBytes * componentCount
}

data class VertexFormatElement(
    val type: VertexFormatElementType, val name: String
) {
    inline val sizeInBytes: Int
        get() = type.sizeInBytes
}

@JvmInline
value class VertexFormat(val elements: List<VertexFormatElement>) {
    companion object {
        val empty: VertexFormat = VertexFormat(emptyList())
    }

    constructor(vararg elements: VertexFormatElement) : this(elements.toList())

    inline val sizeInBytes: Int
        get() = elements.sumOf { it.sizeInBytes }
}