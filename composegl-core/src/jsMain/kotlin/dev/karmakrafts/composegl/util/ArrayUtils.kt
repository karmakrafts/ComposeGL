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

package dev.karmakrafts.composegl.util

import org.khronos.webgl.Float32Array
import org.khronos.webgl.Int16Array
import org.khronos.webgl.Int32Array
import org.khronos.webgl.Int8Array
import org.khronos.webgl.get

internal fun ByteArray.toInt8Array(): Int8Array = Int8Array(toTypedArray())
internal fun ShortArray.toInt16Array(): Int16Array = Int16Array(toTypedArray())
internal fun IntArray.toInt32Array(): Int32Array = Int32Array(toTypedArray())
internal fun FloatArray.toFloat32Array(): Float32Array = Float32Array(toTypedArray())

internal fun Int8Array.copyTo(dest: ByteArray, destOffset: Int = 0, srcOffset: Int = 0, size: Int = dest.size) {
    for (index in 0..<size) {
        dest[destOffset + index] = this[srcOffset + index]
    }
}

internal fun Int16Array.copyTo(dest: ShortArray, destOffset: Int = 0, srcOffset: Int = 0, size: Int = dest.size) {
    for (index in 0..<size) {
        dest[destOffset + index] = this[srcOffset + index]
    }
}

internal fun Int32Array.copyTo(dest: IntArray, destOffset: Int = 0, srcOffset: Int = 0, size: Int = dest.size) {
    for (index in 0..<size) {
        dest[destOffset + index] = this[srcOffset + index]
    }
}

internal fun Float32Array.copyTo(dest: FloatArray, destOffset: Int = 0, srcOffset: Int = 0, size: Int = dest.size) {
    for (index in 0..<size) {
        dest[destOffset + index] = this[srcOffset + index]
    }
}