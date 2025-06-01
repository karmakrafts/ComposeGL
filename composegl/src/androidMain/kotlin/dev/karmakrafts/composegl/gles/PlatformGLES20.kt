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

import android.opengl.GLES20 as AndroidGLES20

internal object PlatformGLES20 : GLES20, GLES11 by PlatformGLES11 {
    override val GL_FUNC_ADD: Int get() = AndroidGLES20.GL_FUNC_ADD
    override val GL_BLEND_EQUATION: Int get() = AndroidGLES20.GL_BLEND_EQUATION
    override val GL_BLEND_EQUATION_RGB: Int get() = AndroidGLES20.GL_BLEND_EQUATION_RGB
    override val GL_BLEND_EQUATION_ALPHA: Int get() = AndroidGLES20.GL_BLEND_EQUATION_ALPHA
    override val GL_FUNC_SUBTRACT: Int get() = AndroidGLES20.GL_FUNC_SUBTRACT
    override val GL_FUNC_REVERSE_SUBTRACT: Int get() = AndroidGLES20.GL_FUNC_REVERSE_SUBTRACT
    override val GL_BLEND_DST_RGB: Int get() = AndroidGLES20.GL_BLEND_DST_RGB
    override val GL_BLEND_SRC_RGB: Int get() = AndroidGLES20.GL_BLEND_SRC_RGB
    override val GL_BLEND_DST_ALPHA: Int get() = AndroidGLES20.GL_BLEND_DST_ALPHA
    override val GL_BLEND_SRC_ALPHA: Int get() = AndroidGLES20.GL_BLEND_SRC_ALPHA
    override val GL_CONSTANT_COLOR: Int get() = AndroidGLES20.GL_CONSTANT_COLOR
    override val GL_ONE_MINUS_CONSTANT_COLOR: Int get() = AndroidGLES20.GL_ONE_MINUS_CONSTANT_COLOR
    override val GL_CONSTANT_ALPHA: Int get() = AndroidGLES20.GL_CONSTANT_ALPHA
    override val GL_ONE_MINUS_CONSTANT_ALPHA: Int get() = AndroidGLES20.GL_ONE_MINUS_CONSTANT_ALPHA
    override val GL_BLEND_COLOR: Int get() = AndroidGLES20.GL_BLEND_COLOR
    override val GL_STREAM_DRAW: Int get() = AndroidGLES20.GL_STREAM_DRAW
    override val GL_CURRENT_VERTEX_ATTRIB: Int get() = AndroidGLES20.GL_CURRENT_VERTEX_ATTRIB
    override val GL_STENCIL_BACK_FUNC: Int get() = AndroidGLES20.GL_STENCIL_BACK_FUNC
    override val GL_STENCIL_BACK_FAIL: Int get() = AndroidGLES20.GL_STENCIL_BACK_FAIL
    override val GL_STENCIL_BACK_PASS_DEPTH_FAIL: Int get() = AndroidGLES20.GL_STENCIL_BACK_PASS_DEPTH_FAIL
    override val GL_STENCIL_BACK_PASS_DEPTH_PASS: Int get() = AndroidGLES20.GL_STENCIL_BACK_PASS_DEPTH_PASS
    override val GL_STENCIL_BACK_REF: Int get() = AndroidGLES20.GL_STENCIL_BACK_REF
    override val GL_STENCIL_BACK_VALUE_MASK: Int get() = AndroidGLES20.GL_STENCIL_BACK_VALUE_MASK
    override val GL_STENCIL_BACK_WRITEMASK: Int get() = AndroidGLES20.GL_STENCIL_BACK_WRITEMASK
    override val GL_MIRRORED_REPEAT: Int get() = AndroidGLES20.GL_MIRRORED_REPEAT
    override val GL_FRAGMENT_SHADER: Int get() = AndroidGLES20.GL_FRAGMENT_SHADER
    override val GL_VERTEX_SHADER: Int get() = AndroidGLES20.GL_VERTEX_SHADER
    override val GL_MAX_VERTEX_ATTRIBS: Int get() = AndroidGLES20.GL_MAX_VERTEX_ATTRIBS
    override val GL_MAX_VERTEX_UNIFORM_VECTORS: Int get() = AndroidGLES20.GL_MAX_VERTEX_UNIFORM_VECTORS
    override val GL_MAX_VARYING_VECTORS: Int get() = AndroidGLES20.GL_MAX_VARYING_VECTORS
    override val GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS: Int get() = AndroidGLES20.GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS
    override val GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS: Int get() = AndroidGLES20.GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS
    override val GL_MAX_TEXTURE_IMAGE_UNITS: Int get() = AndroidGLES20.GL_MAX_TEXTURE_IMAGE_UNITS
    override val GL_MAX_FRAGMENT_UNIFORM_VECTORS: Int get() = AndroidGLES20.GL_MAX_FRAGMENT_UNIFORM_VECTORS
    override val GL_SHADER_TYPE: Int get() = AndroidGLES20.GL_SHADER_TYPE
    override val GL_DELETE_STATUS: Int get() = AndroidGLES20.GL_DELETE_STATUS
    override val GL_LINK_STATUS: Int get() = AndroidGLES20.GL_LINK_STATUS
    override val GL_VALIDATE_STATUS: Int get() = AndroidGLES20.GL_VALIDATE_STATUS
    override val GL_ATTACHED_SHADERS: Int get() = AndroidGLES20.GL_ATTACHED_SHADERS
    override val GL_ACTIVE_UNIFORMS: Int get() = AndroidGLES20.GL_ACTIVE_UNIFORMS
    override val GL_ACTIVE_ATTRIBUTES: Int get() = AndroidGLES20.GL_ACTIVE_ATTRIBUTES
    override val GL_SHADING_LANGUAGE_VERSION: Int get() = AndroidGLES20.GL_SHADING_LANGUAGE_VERSION
    override val GL_CURRENT_PROGRAM: Int get() = AndroidGLES20.GL_CURRENT_PROGRAM
    override val GL_INCR_WRAP: Int get() = AndroidGLES20.GL_INCR_WRAP
    override val GL_DECR_WRAP: Int get() = AndroidGLES20.GL_DECR_WRAP
    override val GL_TEXTURE_CUBE_MAP: Int get() = AndroidGLES20.GL_TEXTURE_CUBE_MAP
    override val GL_TEXTURE_BINDING_CUBE_MAP: Int get() = AndroidGLES20.GL_TEXTURE_BINDING_CUBE_MAP
    override val GL_TEXTURE_CUBE_MAP_POSITIVE_X: Int get() = AndroidGLES20.GL_TEXTURE_CUBE_MAP_POSITIVE_X
    override val GL_TEXTURE_CUBE_MAP_NEGATIVE_X: Int get() = AndroidGLES20.GL_TEXTURE_CUBE_MAP_NEGATIVE_X
    override val GL_TEXTURE_CUBE_MAP_POSITIVE_Y: Int get() = AndroidGLES20.GL_TEXTURE_CUBE_MAP_POSITIVE_Y
    override val GL_TEXTURE_CUBE_MAP_NEGATIVE_Y: Int get() = AndroidGLES20.GL_TEXTURE_CUBE_MAP_NEGATIVE_Y
    override val GL_TEXTURE_CUBE_MAP_POSITIVE_Z: Int get() = AndroidGLES20.GL_TEXTURE_CUBE_MAP_POSITIVE_Z
    override val GL_TEXTURE_CUBE_MAP_NEGATIVE_Z: Int get() = AndroidGLES20.GL_TEXTURE_CUBE_MAP_NEGATIVE_Z
    override val GL_MAX_CUBE_MAP_TEXTURE_SIZE: Int get() = AndroidGLES20.GL_MAX_CUBE_MAP_TEXTURE_SIZE
    override val GL_FLOAT_VEC2: Int get() = AndroidGLES20.GL_FLOAT_VEC2
    override val GL_FLOAT_VEC3: Int get() = AndroidGLES20.GL_FLOAT_VEC3
    override val GL_FLOAT_VEC4: Int get() = AndroidGLES20.GL_FLOAT_VEC4
    override val GL_INT_VEC2: Int get() = AndroidGLES20.GL_INT_VEC2
    override val GL_INT_VEC3: Int get() = AndroidGLES20.GL_INT_VEC3
    override val GL_INT_VEC4: Int get() = AndroidGLES20.GL_INT_VEC4
    override val GL_BOOL: Int get() = AndroidGLES20.GL_BOOL
    override val GL_BOOL_VEC2: Int get() = AndroidGLES20.GL_BOOL_VEC2
    override val GL_BOOL_VEC3: Int get() = AndroidGLES20.GL_BOOL_VEC3
    override val GL_BOOL_VEC4: Int get() = AndroidGLES20.GL_BOOL_VEC4
    override val GL_FLOAT_MAT2: Int get() = AndroidGLES20.GL_FLOAT_MAT2
    override val GL_FLOAT_MAT3: Int get() = AndroidGLES20.GL_FLOAT_MAT3
    override val GL_FLOAT_MAT4: Int get() = AndroidGLES20.GL_FLOAT_MAT4
    override val GL_SAMPLER_2D: Int get() = AndroidGLES20.GL_SAMPLER_2D
    override val GL_SAMPLER_CUBE: Int get() = AndroidGLES20.GL_SAMPLER_CUBE
    override val GL_VERTEX_ATTRIB_ARRAY_ENABLED: Int get() = AndroidGLES20.GL_VERTEX_ATTRIB_ARRAY_ENABLED
    override val GL_VERTEX_ATTRIB_ARRAY_SIZE: Int get() = AndroidGLES20.GL_VERTEX_ATTRIB_ARRAY_SIZE
    override val GL_VERTEX_ATTRIB_ARRAY_STRIDE: Int get() = AndroidGLES20.GL_VERTEX_ATTRIB_ARRAY_STRIDE
    override val GL_VERTEX_ATTRIB_ARRAY_TYPE: Int get() = AndroidGLES20.GL_VERTEX_ATTRIB_ARRAY_TYPE
    override val GL_VERTEX_ATTRIB_ARRAY_NORMALIZED: Int get() = AndroidGLES20.GL_VERTEX_ATTRIB_ARRAY_NORMALIZED
    override val GL_VERTEX_ATTRIB_ARRAY_POINTER: Int get() = AndroidGLES20.GL_VERTEX_ATTRIB_ARRAY_POINTER
    override val GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING: Int get() = AndroidGLES20.GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING
    override val GL_COMPILE_STATUS: Int get() = AndroidGLES20.GL_COMPILE_STATUS
    override val GL_FRAMEBUFFER: Int get() = AndroidGLES20.GL_FRAMEBUFFER
    override val GL_RENDERBUFFER: Int get() = AndroidGLES20.GL_RENDERBUFFER
    override val GL_RGBA4: Int get() = AndroidGLES20.GL_RGBA4
    override val GL_RGB5_A1: Int get() = AndroidGLES20.GL_RGB5_A1
    override val GL_DEPTH_COMPONENT16: Int get() = AndroidGLES20.GL_DEPTH_COMPONENT16
    override val GL_STENCIL_INDEX8: Int get() = AndroidGLES20.GL_STENCIL_INDEX8
    override val GL_RENDERBUFFER_WIDTH: Int get() = AndroidGLES20.GL_RENDERBUFFER_WIDTH
    override val GL_RENDERBUFFER_HEIGHT: Int get() = AndroidGLES20.GL_RENDERBUFFER_HEIGHT
    override val GL_RENDERBUFFER_INTERNAL_FORMAT: Int get() = AndroidGLES20.GL_RENDERBUFFER_INTERNAL_FORMAT
    override val GL_RENDERBUFFER_RED_SIZE: Int get() = AndroidGLES20.GL_RENDERBUFFER_RED_SIZE
    override val GL_RENDERBUFFER_GREEN_SIZE: Int get() = AndroidGLES20.GL_RENDERBUFFER_GREEN_SIZE
    override val GL_RENDERBUFFER_BLUE_SIZE: Int get() = AndroidGLES20.GL_RENDERBUFFER_BLUE_SIZE
    override val GL_RENDERBUFFER_ALPHA_SIZE: Int get() = AndroidGLES20.GL_RENDERBUFFER_ALPHA_SIZE
    override val GL_RENDERBUFFER_DEPTH_SIZE: Int get() = AndroidGLES20.GL_RENDERBUFFER_DEPTH_SIZE
    override val GL_RENDERBUFFER_STENCIL_SIZE: Int get() = AndroidGLES20.GL_RENDERBUFFER_STENCIL_SIZE
    override val GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE: Int get() = AndroidGLES20.GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE
    override val GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME: Int get() = AndroidGLES20.GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME
    override val GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL: Int get() = AndroidGLES20.GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL
    override val GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE: Int get() = AndroidGLES20.GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE
    override val GL_COLOR_ATTACHMENT0: Int get() = AndroidGLES20.GL_COLOR_ATTACHMENT0
    override val GL_DEPTH_ATTACHMENT: Int get() = AndroidGLES20.GL_DEPTH_ATTACHMENT
    override val GL_STENCIL_ATTACHMENT: Int get() = AndroidGLES20.GL_STENCIL_ATTACHMENT
    override val GL_NONE: Int get() = AndroidGLES20.GL_NONE
    override val GL_FRAMEBUFFER_COMPLETE: Int get() = AndroidGLES20.GL_FRAMEBUFFER_COMPLETE
    override val GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT: Int get() = AndroidGLES20.GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT
    override val GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT: Int get() = AndroidGLES20.GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT
    override val GL_FRAMEBUFFER_UNSUPPORTED: Int get() = AndroidGLES20.GL_FRAMEBUFFER_UNSUPPORTED
    override val GL_FRAMEBUFFER_BINDING: Int get() = AndroidGLES20.GL_FRAMEBUFFER_BINDING
    override val GL_RENDERBUFFER_BINDING: Int get() = AndroidGLES20.GL_RENDERBUFFER_BINDING
    override val GL_MAX_RENDERBUFFER_SIZE: Int get() = AndroidGLES20.GL_MAX_RENDERBUFFER_SIZE
    override val GL_INVALID_FRAMEBUFFER_OPERATION: Int get() = AndroidGLES20.GL_INVALID_FRAMEBUFFER_OPERATION

    private const val MAX_NAME_SIZE: Int = 4096

    override fun glAttachShader(program: GLESShaderProgram, shader: GLESShader) {
        AndroidGLES20.glAttachShader(program, shader)
    }

    override fun glBindAttribLocation(program: GLESShaderProgram, index: Int, name: String) {
        AndroidGLES20.glBindAttribLocation(program, index, name)
    }

    override fun glBindFramebuffer(target: Int, framebuffer: GLESFrameBuffer) {
        AndroidGLES20.glBindFramebuffer(target, framebuffer)
    }

    override fun glBindRenderbuffer(target: Int, renderbuffer: GLESRenderBuffer) {
        AndroidGLES20.glBindRenderbuffer(target, renderbuffer)
    }

    override fun glBlendColor(red: Float, green: Float, blue: Float, alpha: Float) {
        AndroidGLES20.glBlendColor(red, green, blue, alpha)
    }

    override fun glBlendEquation(mode: Int) {
        AndroidGLES20.glBlendEquation(mode)
    }

    override fun glBlendEquationSeparate(modeRGB: Int, modeAlpha: Int) {
        AndroidGLES20.glBlendEquationSeparate(modeRGB, modeAlpha)
    }

    override fun glBlendFuncSeparate(
        sfactorRGB: Int, dfactorRGB: Int, sfactorAlpha: Int, dfactorAlpha: Int
    ) {
        AndroidGLES20.glBlendFuncSeparate(sfactorRGB, dfactorRGB, sfactorAlpha, dfactorAlpha)
    }

    override fun glCheckFramebufferStatus(target: Int): Int {
        return AndroidGLES20.glCheckFramebufferStatus(target)
    }

    override fun glCompileShader(shader: GLESShader) {
        AndroidGLES20.glCompileShader(shader)
    }

    override fun glCreateProgram(): GLESShaderProgram {
        return AndroidGLES20.glCreateProgram()
    }

    override fun glCreateShader(type: Int): GLESShader {
        return AndroidGLES20.glCreateShader(type)
    }

    override fun glDeleteFramebuffer(framebuffer: GLESFrameBuffer) {
        AndroidGLES20.glDeleteFramebuffers(1, intArrayOf(framebuffer), 0)
    }

    override fun glDeleteProgram(program: GLESShaderProgram) {
        AndroidGLES20.glDeleteProgram(program)
    }

    override fun glDeleteRenderbuffer(renderbuffer: GLESRenderBuffer) {
        AndroidGLES20.glDeleteRenderbuffers(1, intArrayOf(renderbuffer), 0)
    }

    override fun glDeleteShader(shader: GLESShader) {
        AndroidGLES20.glDeleteShader(shader)
    }

    override fun glDetachShader(program: GLESShaderProgram, shader: GLESShader) {
        AndroidGLES20.glDetachShader(program, shader)
    }

    override fun glDisableVertexAttribArray(index: Int) {
        AndroidGLES20.glDisableVertexAttribArray(index)
    }

    override fun glEnableVertexAttribArray(index: Int) {
        AndroidGLES20.glEnableVertexAttribArray(index)
    }

    override fun glFramebufferRenderbuffer(
        target: Int, attachment: Int, renderbuffertarget: Int, renderbuffer: GLESRenderBuffer
    ) {
        AndroidGLES20.glFramebufferRenderbuffer(target, attachment, renderbuffertarget, renderbuffer)
    }

    override fun glFramebufferTexture2D(
        target: Int, attachment: Int, textarget: Int, texture: GLESTexture, level: Int
    ) {
        AndroidGLES20.glFramebufferTexture2D(target, attachment, textarget, texture, level)
    }

    override fun glGenerateMipmap(target: Int) {
        AndroidGLES20.glGenerateMipmap(target)
    }

    override fun glGenFramebuffer(): GLESFrameBuffer {
        val id = IntArray(1)
        AndroidGLES20.glGenFramebuffers(1, id, 0)
        return id.first()
    }

    override fun glGenRenderbuffer(): GLESRenderBuffer {
        val id = IntArray(1)
        AndroidGLES20.glGenRenderbuffers(1, id, 0)
        return id.first()
    }

    override fun glGetActiveAttrib(
        program: GLESShaderProgram, index: Int, info: GLESActiveInfo
    ) {
        val props = IntArray(2)
        val name = ByteArray(MAX_NAME_SIZE)
        AndroidGLES20.glGetActiveAttrib(program, index, 0, null, 0, props, 0, props, 1, name, 0)
        info.size = props[0]
        info.type = props[1]
        info.name = name.decodeToString()
    }

    override fun glGetActiveUniform(
        program: GLESShaderProgram, index: Int, info: GLESActiveInfo
    ) {
        val props = IntArray(2)
        val name = ByteArray(MAX_NAME_SIZE)
        AndroidGLES20.glGetActiveUniform(program, index, 0, null, 0, props, 0, props, 1, name, 0)
        info.size = props[0]
        info.type = props[1]
        info.name = name.decodeToString()
    }

    override fun glGetAttribLocation(program: GLESShaderProgram, name: String): Int {
        return AndroidGLES20.glGetAttribLocation(program, name)
    }

    override fun glGetProgramInfoLog(program: GLESShaderProgram): String? {
        return AndroidGLES20.glGetProgramInfoLog(program)
    }

    override fun glGetShaderInfoLog(shader: GLESShader): String? {
        return AndroidGLES20.glGetShaderInfoLog(shader)
    }

    override fun glGetShaderPrecisionFormat(
        shadertype: Int, precisiontype: Int, format: GLESShaderPrecisionFormat
    ) {
        val props = IntArray(3)
        AndroidGLES20.glGetShaderPrecisionFormat(shadertype, precisiontype, props, 0, props, 2)
        format.precision = props[2]
        format.rangeMin = props[0]
        format.rangeMax = props[1]
    }

    override fun glGetShaderSource(shader: GLESShader): String? {
        return AndroidGLES20.glGetShaderSource(shader)
    }

    override fun glGetUniformLocation(program: GLESShaderProgram, name: String): GLESUniformLocation {
        return AndroidGLES20.glGetUniformLocation(program, name)
    }

    override fun glIsFramebuffer(framebuffer: GLESFrameBuffer): Boolean {
        return AndroidGLES20.glIsFramebuffer(framebuffer)
    }

    override fun glIsProgram(program: GLESShaderProgram): Boolean {
        return AndroidGLES20.glIsProgram(program)
    }

    override fun glIsRenderbuffer(renderbuffer: GLESRenderBuffer): Boolean {
        return AndroidGLES20.glIsRenderbuffer(renderbuffer)
    }

    override fun glIsShader(shader: GLESShader): Boolean {
        return AndroidGLES20.glIsShader(shader)
    }

    override fun glLinkProgram(program: GLESShaderProgram) {
        AndroidGLES20.glLinkProgram(program)
    }

    override fun glRenderbufferStorage(
        target: Int, internalformat: Int, width: Int, height: Int
    ) {
        AndroidGLES20.glRenderbufferStorage(target, internalformat, width, height)
    }

    override fun glShaderSource(shader: GLESShader, source: String) {
        AndroidGLES20.glShaderSource(shader, source)
    }

    override fun glStencilFuncSeparate(face: Int, func: Int, ref: Int, mask: Int) {
        AndroidGLES20.glStencilFuncSeparate(face, func, ref, mask)
    }

    override fun glStencilMaskSeparate(face: Int, mask: Int) {
        AndroidGLES20.glStencilMaskSeparate(face, mask)
    }

    override fun glStencilOpSeparate(face: Int, sfail: Int, dpfail: Int, dppass: Int) {
        AndroidGLES20.glStencilOpSeparate(face, sfail, dpfail, dppass)
    }

    override fun glUniform1f(location: GLESUniformLocation, v0: Float) {
        AndroidGLES20.glUniform1f(location, v0)
    }

    override fun glUniform1fv(location: GLESUniformLocation, value: FloatArray) {
        AndroidGLES20.glUniform1fv(location, value.size, value, 0)
    }

    override fun glUniform1i(location: GLESUniformLocation, v0: Int) {
        AndroidGLES20.glUniform1i(location, v0)
    }

    override fun glUniform1iv(location: GLESUniformLocation, value: IntArray) {
        AndroidGLES20.glUniform1iv(location, value.size, value, 0)
    }

    override fun glUniform2f(location: GLESUniformLocation, v0: Float, v1: Float) {
        AndroidGLES20.glUniform2f(location, v0, v1)
    }

    override fun glUniform2fv(location: GLESUniformLocation, value: FloatArray) {
        AndroidGLES20.glUniform2fv(location, value.size, value, 0)
    }

    override fun glUniform2i(location: GLESUniformLocation, v0: Int, v1: Int) {
        AndroidGLES20.glUniform2i(location, v0, v1)
    }

    override fun glUniform2iv(location: GLESUniformLocation, value: IntArray) {
        AndroidGLES20.glUniform2iv(location, value.size, value, 0)
    }

    override fun glUniform3f(location: GLESUniformLocation, v0: Float, v1: Float, v2: Float) {
        AndroidGLES20.glUniform3f(location, v0, v1, v2)
    }

    override fun glUniform3fv(location: GLESUniformLocation, value: FloatArray) {
        AndroidGLES20.glUniform3fv(location, value.size, value, 0)
    }

    override fun glUniform3i(location: GLESUniformLocation, v0: Int, v1: Int, v2: Int) {
        AndroidGLES20.glUniform3i(location, v0, v1, v2)
    }

    override fun glUniform3iv(location: GLESUniformLocation, value: IntArray) {
        AndroidGLES20.glUniform3iv(location, value.size, value, 0)
    }

    override fun glUniform4f(
        location: GLESUniformLocation, v0: Float, v1: Float, v2: Float, v3: Float
    ) {
        AndroidGLES20.glUniform4f(location, v0, v1, v2, v3)
    }

    override fun glUniform4fv(location: GLESUniformLocation, value: FloatArray) {
        AndroidGLES20.glUniform4fv(location, value.size, value, 0)
    }

    override fun glUniform4i(location: GLESUniformLocation, v0: Int, v1: Int, v2: Int, v3: Int) {
        AndroidGLES20.glUniform4i(location, v0, v1, v2, v3)
    }

    override fun glUniform4iv(location: GLESUniformLocation, value: IntArray) {
        AndroidGLES20.glUniform4iv(location, value.size, value, 0)
    }

    override fun glUniformMatrix2fv(location: GLESUniformLocation, transpose: Boolean, value: FloatArray) {
        AndroidGLES20.glUniformMatrix2fv(location, value.size, transpose, value, 0)
    }

    override fun glUniformMatrix3fv(location: GLESUniformLocation, transpose: Boolean, value: FloatArray) {
        AndroidGLES20.glUniformMatrix3fv(location, value.size, transpose, value, 0)
    }

    override fun glUniformMatrix4fv(location: GLESUniformLocation, transpose: Boolean, value: FloatArray) {
        AndroidGLES20.glUniformMatrix4fv(location, value.size, transpose, value, 0)
    }

    override fun glUseProgram(program: GLESShaderProgram) {
        AndroidGLES20.glUseProgram(program)
    }

    override fun glValidateProgram(program: GLESShaderProgram) {
        AndroidGLES20.glValidateProgram(program)
    }

    override fun glVertexAttrib1f(index: Int, x: Float) {
        AndroidGLES20.glVertexAttrib1f(index, x)
    }

    override fun glVertexAttrib1fv(index: Int, v: FloatArray) {
        AndroidGLES20.glVertexAttrib1fv(index, v, 0)
    }

    override fun glVertexAttrib2f(index: Int, x: Float, y: Float) {
        AndroidGLES20.glVertexAttrib2f(index, x, y)
    }

    override fun glVertexAttrib2fv(index: Int, v: FloatArray) {
        AndroidGLES20.glVertexAttrib2fv(index, v, 0)
    }

    override fun glVertexAttrib3f(index: Int, x: Float, y: Float, z: Float) {
        AndroidGLES20.glVertexAttrib3f(index, x, y, z)
    }

    override fun glVertexAttrib3fv(index: Int, v: FloatArray) {
        AndroidGLES20.glVertexAttrib3fv(index, v, 0)
    }

    override fun glVertexAttrib4f(
        index: Int, x: Float, y: Float, z: Float, w: Float
    ) {
        AndroidGLES20.glVertexAttrib4f(index, x, y, z, w)
    }

    override fun glVertexAttrib4fv(index: Int, v: FloatArray) {
        AndroidGLES20.glVertexAttrib4fv(index, v, 0)
    }

    override fun glVertexAttribPointer(
        index: Int, size: Int, type: Int, normalized: Boolean, stride: Int, offset: Long
    ) {
        AndroidGLES20.glVertexAttribPointer(index, size, type, normalized, stride, offset.toInt())
    }
}