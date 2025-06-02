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

// No concrete types as the modality of the WGL types doesn't match our expect decls
actual typealias GLESTexture = Any // WebGLTexture
actual typealias GLESBuffer = Any // WebGLBuffer
actual typealias GLESFrameBuffer = Any // WebGLFramebuffer
actual typealias GLESRenderBuffer = Any // WebGLRenderbuffer
actual typealias GLESShader = Any // WebGLShader
actual typealias GLESShaderProgram = Any // WebGLProgram
actual typealias GLESUniformLocation = Any // WebGLUniformLocation

actual val glesNoTexture: GLESTexture get() = null.asDynamic()
actual val glesNoBuffer: GLESBuffer get() = null.asDynamic()
actual val glesNoFrameBuffer: GLESFrameBuffer get() = null.asDynamic()
actual val glesNoRenderBuffer: GLESRenderBuffer get() = null.asDynamic()
actual val glesNoShader: GLESShader get() = null.asDynamic()
actual val glesNoShaderProgram: GLESShaderProgram get() = null.asDynamic()
actual val glesNoUniformLocation: GLESUniformLocation get() = null.asDynamic()