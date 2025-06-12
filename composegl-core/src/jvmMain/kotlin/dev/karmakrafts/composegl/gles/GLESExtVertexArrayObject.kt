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

import org.lwjgl.opengl.GL30

actual typealias GLESVertexArrayObject = Int

actual val glesNoVertexArrayObject: GLESVertexArrayObject = 0

internal object PlatformExtVertexArrayObject : GLESExtVertexArrayObject {
    override fun glGenVertexArray(): GLESVertexArrayObject {
        return GL30.glGenVertexArrays()
    }

    override fun glDeleteVertexArray(handle: GLESVertexArrayObject) {
        GL30.glDeleteVertexArrays(handle)
    }

    override fun glBindVertexArray(handle: GLESVertexArrayObject) {
        GL30.glBindVertexArray(handle)
    }
}