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

package dev.karmakrafts.composegl.gles

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.alloc
import kotlinx.cinterop.cValuesOf
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.value
import platform.OpenGLCommon.GLintVar

actual typealias GLESVertexArrayObject = Int

actual val glesNoVertexArrayObject: GLESVertexArrayObject = 0

@OptIn(ExperimentalForeignApi::class)
internal object PlatformExtVertexArrayObject : GLESExtVertexArrayObject {
    override fun glGenVertexArray(): GLESVertexArrayObject = memScoped {
        val value = alloc<GLintVar>()
        platform.OpenGL3.glGenVertexArrays(1, value.ptr.reinterpret())
        value.value
    }

    override fun glDeleteVertexArray(handle: GLESVertexArrayObject) {
        platform.OpenGL3.glDeleteVertexArrays(1, cValuesOf(handle.toUInt()))
    }

    override fun glBindVertexArray(handle: GLESVertexArrayObject) {
        platform.OpenGL3.glBindVertexArray(handle.toUInt())
    }
}