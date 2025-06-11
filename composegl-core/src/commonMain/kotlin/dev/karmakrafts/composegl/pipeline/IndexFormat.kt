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

enum class IndexFormat(
    val sizeInBytes: Int,
    val isUnsigned: Boolean,
    private val typeGetter: GLES20.() -> Int
) {
    // @formatter:off
    UBYTE   (UByte.SIZE_BYTES,  true,  { GL_UNSIGNED_BYTE }),
    USHORT  (UShort.SIZE_BYTES, true,  { GL_UNSIGNED_SHORT }),
    UINT    (UInt.SIZE_BYTES,   true,  { GL_UNSIGNED_INT });
    // @formatter:on

    internal operator fun invoke(impl: GLES20): Int = impl.typeGetter()
}