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

actual typealias GLESVertexArrayObject = Any

actual val glesNoVertexArrayObject: GLESVertexArrayObject = null.asDynamic()

internal class PlatformExtVertexArrayObject(
    private val impl: PlatformGLES11
) : GLESExtVertexArrayObject {
    private val extension: dynamic by lazy { impl.context.getExtension(GLESExtVertexArrayObject.NAME) }
    private val hasExtension: Boolean = GLESExtVertexArrayObject.NAME in impl

    override fun glGenVertexArray(): GLESVertexArrayObject {
        if (hasExtension) {
            return extension.createVertexArrayOES()
        }
        return impl.context.asDynamic().createVertexArray()
    }

    override fun glDeleteVertexArray(handle: GLESVertexArrayObject) {
        if (hasExtension) {
            extension.deleteVertexArrayOES(handle)
            return
        }
        impl.context.asDynamic().deleteVertexArray(handle)
    }

    override fun glBindVertexArray(handle: GLESVertexArrayObject) {
        if (hasExtension) {
            extension.bindVertexArrayOES(handle)
            return
        }
        impl.context.asDynamic().bindVertexArray(handle)
    }
}