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
import dev.karmakrafts.composegl.gles.GLESExtVertexArrayObject
import dev.karmakrafts.composegl.gles.GLESVertexArrayObject
import dev.karmakrafts.composegl.gles.glesNoVertexArrayObject
import dev.karmakrafts.composegl.util.Log

class VertexArrayObject internal constructor(
    private val impl: GLES20
) : BindableResource {
    companion object {
        @GLRenderScopeDsl
        fun GLRenderScope.vertexArrayObject(): VertexArrayObject = VertexArrayObject(this)
    }

    private inline val extension: GLESExtVertexArrayObject
        get() = impl.getExtension(GLESExtVertexArrayObject.NAME)

    val handle: GLESVertexArrayObject = extension.glGenVertexArray()
    private var isDisposed: Boolean = false

    init {
        Log.debug { "Created vertex array object $handle" }
    }

    override fun bind() = extension.glBindVertexArray(handle)
    override fun unbind() = extension.glBindVertexArray(glesNoVertexArrayObject)

    override fun dispose() {
        if (isDisposed) return
        extension.glDeleteVertexArray(handle)
        Log.debug { "Deleted vertex array object $handle" }
        isDisposed = true
    }
}