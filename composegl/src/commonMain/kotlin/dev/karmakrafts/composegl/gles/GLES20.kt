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

/**
 * GLES 2.0 conformant API minus fixed point/fixed pipeline functions,
 * compatible with the WebGL standard.
 * See https://registry.khronos.org/OpenGL/specs/es/1.1/es_full_spec_1.1.pdf
 */
interface GLES20 : GLES11 {
    val GL_FUNC_ADD: Int
    val GL_BLEND_EQUATION: Int
    val GL_BLEND_EQUATION_RGB: Int
    val GL_BLEND_EQUATION_ALPHA: Int
    val GL_FUNC_SUBTRACT: Int
    val GL_FUNC_REVERSE_SUBTRACT: Int
    val GL_BLEND_DST_RGB: Int
    val GL_BLEND_SRC_RGB: Int
    val GL_BLEND_DST_ALPHA: Int
    val GL_BLEND_SRC_ALPHA: Int
    val GL_CONSTANT_COLOR: Int
    val GL_ONE_MINUS_CONSTANT_COLOR: Int
    val GL_CONSTANT_ALPHA: Int
    val GL_ONE_MINUS_CONSTANT_ALPHA: Int
    val GL_BLEND_COLOR: Int
    val GL_STREAM_DRAW: Int
    val GL_CURRENT_VERTEX_ATTRIB: Int
    val GL_STENCIL_BACK_FUNC: Int
    val GL_STENCIL_BACK_FAIL: Int
    val GL_STENCIL_BACK_PASS_DEPTH_FAIL: Int
    val GL_STENCIL_BACK_PASS_DEPTH_PASS: Int
    val GL_STENCIL_BACK_REF: Int
    val GL_STENCIL_BACK_VALUE_MASK: Int
    val GL_STENCIL_BACK_WRITEMASK: Int
    val GL_MIRRORED_REPEAT: Int
    val GL_FRAGMENT_SHADER: Int
    val GL_VERTEX_SHADER: Int
    val GL_MAX_VERTEX_ATTRIBS: Int
    val GL_MAX_VERTEX_UNIFORM_VECTORS: Int
    val GL_MAX_VARYING_VECTORS: Int
    val GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS: Int
    val GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS: Int
    val GL_MAX_TEXTURE_IMAGE_UNITS: Int
    val GL_MAX_FRAGMENT_UNIFORM_VECTORS: Int
    val GL_SHADER_TYPE: Int
    val GL_DELETE_STATUS: Int
    val GL_LINK_STATUS: Int
    val GL_VALIDATE_STATUS: Int
    val GL_ATTACHED_SHADERS: Int
    val GL_ACTIVE_UNIFORMS: Int
    val GL_ACTIVE_ATTRIBUTES: Int
    val GL_SHADING_LANGUAGE_VERSION: Int
    val GL_CURRENT_PROGRAM: Int
    val GL_INCR_WRAP: Int
    val GL_DECR_WRAP: Int
    val GL_TEXTURE_CUBE_MAP: Int
    val GL_TEXTURE_BINDING_CUBE_MAP: Int
    val GL_TEXTURE_CUBE_MAP_POSITIVE_X: Int
    val GL_TEXTURE_CUBE_MAP_NEGATIVE_X: Int
    val GL_TEXTURE_CUBE_MAP_POSITIVE_Y: Int
    val GL_TEXTURE_CUBE_MAP_NEGATIVE_Y: Int
    val GL_TEXTURE_CUBE_MAP_POSITIVE_Z: Int
    val GL_TEXTURE_CUBE_MAP_NEGATIVE_Z: Int
    val GL_MAX_CUBE_MAP_TEXTURE_SIZE: Int
    val GL_FLOAT_VEC2: Int
    val GL_FLOAT_VEC3: Int
    val GL_FLOAT_VEC4: Int
    val GL_INT_VEC2: Int
    val GL_INT_VEC3: Int
    val GL_INT_VEC4: Int
    val GL_BOOL: Int
    val GL_BOOL_VEC2: Int
    val GL_BOOL_VEC3: Int
    val GL_BOOL_VEC4: Int
    val GL_FLOAT_MAT2: Int
    val GL_FLOAT_MAT3: Int
    val GL_FLOAT_MAT4: Int
    val GL_SAMPLER_2D: Int
    val GL_SAMPLER_CUBE: Int
    val GL_VERTEX_ATTRIB_ARRAY_ENABLED: Int
    val GL_VERTEX_ATTRIB_ARRAY_SIZE: Int
    val GL_VERTEX_ATTRIB_ARRAY_STRIDE: Int
    val GL_VERTEX_ATTRIB_ARRAY_TYPE: Int
    val GL_VERTEX_ATTRIB_ARRAY_NORMALIZED: Int
    val GL_VERTEX_ATTRIB_ARRAY_POINTER: Int
    val GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING: Int
    val GL_COMPILE_STATUS: Int
    val GL_FRAMEBUFFER: Int
    val GL_RENDERBUFFER: Int
    val GL_RGBA4: Int
    val GL_RGB5_A1: Int
    val GL_DEPTH_COMPONENT16: Int
    val GL_STENCIL_INDEX8: Int
    val GL_RENDERBUFFER_WIDTH: Int
    val GL_RENDERBUFFER_HEIGHT: Int
    val GL_RENDERBUFFER_INTERNAL_FORMAT: Int
    val GL_RENDERBUFFER_RED_SIZE: Int
    val GL_RENDERBUFFER_GREEN_SIZE: Int
    val GL_RENDERBUFFER_BLUE_SIZE: Int
    val GL_RENDERBUFFER_ALPHA_SIZE: Int
    val GL_RENDERBUFFER_DEPTH_SIZE: Int
    val GL_RENDERBUFFER_STENCIL_SIZE: Int
    val GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE: Int
    val GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME: Int
    val GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL: Int
    val GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE: Int
    val GL_COLOR_ATTACHMENT0: Int
    val GL_DEPTH_ATTACHMENT: Int
    val GL_STENCIL_ATTACHMENT: Int
    val GL_NONE: Int
    val GL_FRAMEBUFFER_COMPLETE: Int
    val GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT: Int
    val GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT: Int
    val GL_FRAMEBUFFER_UNSUPPORTED: Int
    val GL_FRAMEBUFFER_BINDING: Int
    val GL_RENDERBUFFER_BINDING: Int
    val GL_MAX_RENDERBUFFER_SIZE: Int
    val GL_INVALID_FRAMEBUFFER_OPERATION: Int

    fun glAttachShader(program: Int, shader: Int)
    fun glBindAttribLocation(program: Int, index: Int, name: String)
    fun glBindFramebuffer(target: Int, framebuffer: Int)
    fun glBindRenderbuffer(target: Int, renderbuffer: Int)
    fun glBlendColor(red: Float, green: Float, blue: Float, alpha: Float)
    fun glBlendEquation(mode: Int)
    fun glBlendEquationSeparate(modeRGB: Int, modeAlpha: Int)
    fun glBlendFuncSeparate(sfactorRGB: Int, dfactorRGB: Int, sfactorAlpha: Int, dfactorAlpha: Int)
    fun glCheckFramebufferStatus(target: Int): Int
    fun glCompileShader(shader: Int)
    fun glCreateProgram(): Int
    fun glCreateShader(type: Int): Int
    fun glDeleteFramebuffers(framebuffers: IntArray)
    fun glDeleteProgram(program: Int)
    fun glDeleteRenderbuffers(renderbuffers: IntArray)
    fun glDeleteShader(shader: Int)
    fun glDetachShader(program: Int, shader: Int)
    fun glDisableVertexAttribArray(index: Int)
    fun glEnableVertexAttribArray(index: Int)
    fun glFramebufferRenderbuffer(target: Int, attachment: Int, renderbuffertarget: Int, renderbuffer: Int)
    fun glFramebufferTexture2D(target: Int, attachment: Int, textarget: Int, texture: Int, level: Int)
    fun glGenerateMipmap(target: Int)
    fun glGenFramebuffers(framebuffers: IntArray)
    fun glGenRenderbuffers(renderbuffers: IntArray)
    fun glGetActiveAttrib(program: Int, index: Int, info: GLESActiveInfo)
    fun glGetActiveUniform(program: Int, index: Int, info: GLESActiveInfo)
    fun glGetAttachedShaders(program: Int, maxCount: Int, shaders: IntArray): Int
    fun glGetAttribLocation(program: Int, name: String): Int
    fun glGetProgramInfoLog(program: Int): String?
    fun glGetShaderInfoLog(shader: Int): String?
    fun glGetShaderPrecisionFormat(shadertype: Int, precisiontype: Int, format: GLESShaderPrecisionFormat)
    fun glGetShaderSource(shader: Int): String?
    fun glGetUniformLocation(program: Int, name: String): Int
    fun glIsFramebuffer(framebuffer: Int): Boolean
    fun glIsProgram(program: Int): Boolean
    fun glIsRenderbuffer(renderbuffer: Int): Boolean
    fun glIsShader(shader: Int): Boolean
    fun glLinkProgram(program: Int)
    fun glRenderbufferStorage(target: Int, internalformat: Int, width: Int, height: Int)
    fun glShaderSource(shader: Int, source: String)
    fun glStencilFuncSeparate(face: Int, func: Int, ref: Int, mask: Int)
    fun glStencilMaskSeparate(face: Int, mask: Int)
    fun glStencilOpSeparate(face: Int, sfail: Int, dpfail: Int, dppass: Int)
    fun glUniform1f(location: Int, v0: Float)
    fun glUniform1fv(location: Int, value: FloatArray)
    fun glUniform1i(location: Int, v0: Int)
    fun glUniform1iv(location: Int, value: IntArray)
    fun glUniform2f(location: Int, v0: Float, v1: Float)
    fun glUniform2fv(location: Int, value: FloatArray)
    fun glUniform2i(location: Int, v0: Int, v1: Int)
    fun glUniform2iv(location: Int, value: IntArray)
    fun glUniform3f(location: Int, v0: Float, v1: Float, v2: Float)
    fun glUniform3fv(location: Int, value: FloatArray)
    fun glUniform3i(location: Int, v0: Int, v1: Int, v2: Int)
    fun glUniform3iv(location: Int, value: IntArray)
    fun glUniform4f(location: Int, v0: Float, v1: Float, v2: Float, v3: Float)
    fun glUniform4fv(location: Int, value: FloatArray)
    fun glUniform4i(location: Int, v0: Int, v1: Int, v2: Int, v3: Int)
    fun glUniform4iv(location: Int, value: IntArray)
    fun glUniformMatrix2fv(location: Int, transpose: Boolean, value: FloatArray)
    fun glUniformMatrix3fv(location: Int, transpose: Boolean, value: FloatArray)
    fun glUniformMatrix4fv(location: Int, transpose: Boolean, value: FloatArray)
    fun glUseProgram(program: Int)
    fun glValidateProgram(program: Int)
    fun glVertexAttrib1f(index: Int, x: Float)
    fun glVertexAttrib1fv(index: Int, v: FloatArray)
    fun glVertexAttrib2f(index: Int, x: Float, y: Float)
    fun glVertexAttrib2fv(index: Int, v: FloatArray)
    fun glVertexAttrib3f(index: Int, x: Float, y: Float, z: Float)
    fun glVertexAttrib3fv(index: Int, v: FloatArray)
    fun glVertexAttrib4f(index: Int, x: Float, y: Float, z: Float, w: Float)
    fun glVertexAttrib4fv(index: Int, v: FloatArray)
    fun glVertexAttribPointer(index: Int, size: Int, type: Int, normalized: Boolean, stride: Int, offset: Long)
}
