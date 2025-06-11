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

import org.khronos.webgl.WebGLRenderingContext

internal class PlatformGLES20(context: WebGLRenderingContext) : PlatformGLES11(context), GLES20 {
    override val GL_FUNC_ADD: Int get() = WebGLRenderingContext.FUNC_ADD
    override val GL_BLEND_EQUATION: Int get() = WebGLRenderingContext.BLEND_EQUATION
    override val GL_BLEND_EQUATION_RGB: Int get() = WebGLRenderingContext.BLEND_EQUATION_RGB
    override val GL_BLEND_EQUATION_ALPHA: Int get() = WebGLRenderingContext.BLEND_EQUATION_ALPHA
    override val GL_FUNC_SUBTRACT: Int get() = WebGLRenderingContext.FUNC_SUBTRACT
    override val GL_FUNC_REVERSE_SUBTRACT: Int get() = WebGLRenderingContext.FUNC_REVERSE_SUBTRACT
    override val GL_BLEND_DST_RGB: Int get() = WebGLRenderingContext.BLEND_DST_RGB
    override val GL_BLEND_SRC_RGB: Int get() = WebGLRenderingContext.BLEND_SRC_RGB
    override val GL_BLEND_DST_ALPHA: Int get() = WebGLRenderingContext.BLEND_DST_ALPHA
    override val GL_BLEND_SRC_ALPHA: Int get() = WebGLRenderingContext.BLEND_SRC_ALPHA
    override val GL_CONSTANT_COLOR: Int get() = WebGLRenderingContext.CONSTANT_COLOR
    override val GL_ONE_MINUS_CONSTANT_COLOR: Int get() = WebGLRenderingContext.ONE_MINUS_CONSTANT_COLOR
    override val GL_CONSTANT_ALPHA: Int get() = WebGLRenderingContext.CONSTANT_ALPHA
    override val GL_ONE_MINUS_CONSTANT_ALPHA: Int get() = WebGLRenderingContext.ONE_MINUS_CONSTANT_ALPHA
    override val GL_BLEND_COLOR: Int get() = WebGLRenderingContext.BLEND_COLOR
    override val GL_STREAM_DRAW: Int get() = WebGLRenderingContext.STREAM_DRAW
    override val GL_CURRENT_VERTEX_ATTRIB: Int get() = WebGLRenderingContext.CURRENT_VERTEX_ATTRIB
    override val GL_STENCIL_BACK_FUNC: Int get() = WebGLRenderingContext.STENCIL_BACK_FUNC
    override val GL_STENCIL_BACK_FAIL: Int get() = WebGLRenderingContext.STENCIL_BACK_FAIL
    override val GL_STENCIL_BACK_PASS_DEPTH_FAIL: Int get() = WebGLRenderingContext.STENCIL_BACK_PASS_DEPTH_FAIL
    override val GL_STENCIL_BACK_PASS_DEPTH_PASS: Int get() = WebGLRenderingContext.STENCIL_BACK_PASS_DEPTH_PASS
    override val GL_STENCIL_BACK_REF: Int get() = WebGLRenderingContext.STENCIL_BACK_REF
    override val GL_STENCIL_BACK_VALUE_MASK: Int get() = WebGLRenderingContext.STENCIL_VALUE_MASK
    override val GL_STENCIL_BACK_WRITEMASK: Int get() = WebGLRenderingContext.STENCIL_BACK_WRITEMASK
    override val GL_MIRRORED_REPEAT: Int get() = WebGLRenderingContext.MIRRORED_REPEAT
    override val GL_FRAGMENT_SHADER: Int get() = WebGLRenderingContext.FRAGMENT_SHADER
    override val GL_VERTEX_SHADER: Int get() = WebGLRenderingContext.VERTEX_SHADER
    override val GL_MAX_VERTEX_ATTRIBS: Int get() = WebGLRenderingContext.MAX_VERTEX_ATTRIBS
    override val GL_MAX_VERTEX_UNIFORM_VECTORS: Int get() = WebGLRenderingContext.MAX_VERTEX_UNIFORM_VECTORS
    override val GL_MAX_VARYING_VECTORS: Int get() = WebGLRenderingContext.MAX_VARYING_VECTORS
    override val GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS: Int get() = WebGLRenderingContext.MAX_COMBINED_TEXTURE_IMAGE_UNITS
    override val GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS: Int get() = WebGLRenderingContext.MAX_VERTEX_TEXTURE_IMAGE_UNITS
    override val GL_MAX_TEXTURE_IMAGE_UNITS: Int get() = WebGLRenderingContext.MAX_TEXTURE_IMAGE_UNITS
    override val GL_MAX_FRAGMENT_UNIFORM_VECTORS: Int get() = WebGLRenderingContext.MAX_FRAGMENT_UNIFORM_VECTORS
    override val GL_SHADER_TYPE: Int get() = WebGLRenderingContext.SHADER_TYPE
    override val GL_DELETE_STATUS: Int get() = WebGLRenderingContext.DELETE_STATUS
    override val GL_LINK_STATUS: Int get() = WebGLRenderingContext.LINK_STATUS
    override val GL_VALIDATE_STATUS: Int get() = WebGLRenderingContext.VALIDATE_STATUS
    override val GL_ATTACHED_SHADERS: Int get() = WebGLRenderingContext.ATTACHED_SHADERS
    override val GL_ACTIVE_UNIFORMS: Int get() = WebGLRenderingContext.ACTIVE_UNIFORMS
    override val GL_ACTIVE_ATTRIBUTES: Int get() = WebGLRenderingContext.ACTIVE_ATTRIBUTES
    override val GL_SHADING_LANGUAGE_VERSION: Int get() = WebGLRenderingContext.SHADING_LANGUAGE_VERSION
    override val GL_CURRENT_PROGRAM: Int get() = WebGLRenderingContext.CURRENT_PROGRAM
    override val GL_INCR_WRAP: Int get() = WebGLRenderingContext.INCR_WRAP
    override val GL_DECR_WRAP: Int get() = WebGLRenderingContext.DECR_WRAP
    override val GL_TEXTURE_CUBE_MAP: Int get() = WebGLRenderingContext.TEXTURE_CUBE_MAP
    override val GL_TEXTURE_BINDING_CUBE_MAP: Int get() = WebGLRenderingContext.TEXTURE_BINDING_CUBE_MAP
    override val GL_TEXTURE_CUBE_MAP_POSITIVE_X: Int get() = WebGLRenderingContext.TEXTURE_CUBE_MAP_POSITIVE_X
    override val GL_TEXTURE_CUBE_MAP_NEGATIVE_X: Int get() = WebGLRenderingContext.TEXTURE_CUBE_MAP_NEGATIVE_X
    override val GL_TEXTURE_CUBE_MAP_POSITIVE_Y: Int get() = WebGLRenderingContext.TEXTURE_CUBE_MAP_POSITIVE_Y
    override val GL_TEXTURE_CUBE_MAP_NEGATIVE_Y: Int get() = WebGLRenderingContext.TEXTURE_CUBE_MAP_NEGATIVE_Y
    override val GL_TEXTURE_CUBE_MAP_POSITIVE_Z: Int get() = WebGLRenderingContext.TEXTURE_CUBE_MAP_POSITIVE_Z
    override val GL_TEXTURE_CUBE_MAP_NEGATIVE_Z: Int get() = WebGLRenderingContext.TEXTURE_CUBE_MAP_NEGATIVE_Z
    override val GL_MAX_CUBE_MAP_TEXTURE_SIZE: Int get() = WebGLRenderingContext.MAX_CUBE_MAP_TEXTURE_SIZE
    override val GL_FLOAT_VEC2: Int get() = WebGLRenderingContext.FLOAT_VEC2
    override val GL_FLOAT_VEC3: Int get() = WebGLRenderingContext.FLOAT_VEC3
    override val GL_FLOAT_VEC4: Int get() = WebGLRenderingContext.FLOAT_VEC4
    override val GL_INT_VEC2: Int get() = WebGLRenderingContext.INT_VEC2
    override val GL_INT_VEC3: Int get() = WebGLRenderingContext.INT_VEC3
    override val GL_INT_VEC4: Int get() = WebGLRenderingContext.INT_VEC4
    override val GL_BOOL: Int get() = WebGLRenderingContext.BOOL
    override val GL_BOOL_VEC2: Int get() = WebGLRenderingContext.BOOL_VEC2
    override val GL_BOOL_VEC3: Int get() = WebGLRenderingContext.BOOL_VEC3
    override val GL_BOOL_VEC4: Int get() = WebGLRenderingContext.BOOL_VEC4
    override val GL_FLOAT_MAT2: Int get() = WebGLRenderingContext.FLOAT_MAT2
    override val GL_FLOAT_MAT3: Int get() = WebGLRenderingContext.FLOAT_MAT3
    override val GL_FLOAT_MAT4: Int get() = WebGLRenderingContext.FLOAT_MAT4
    override val GL_SAMPLER_2D: Int get() = WebGLRenderingContext.SAMPLER_2D
    override val GL_SAMPLER_CUBE: Int get() = WebGLRenderingContext.SAMPLER_CUBE
    override val GL_VERTEX_ATTRIB_ARRAY_ENABLED: Int get() = WebGLRenderingContext.VERTEX_ATTRIB_ARRAY_ENABLED
    override val GL_VERTEX_ATTRIB_ARRAY_SIZE: Int get() = WebGLRenderingContext.VERTEX_ATTRIB_ARRAY_SIZE
    override val GL_VERTEX_ATTRIB_ARRAY_STRIDE: Int get() = WebGLRenderingContext.VERTEX_ATTRIB_ARRAY_STRIDE
    override val GL_VERTEX_ATTRIB_ARRAY_TYPE: Int get() = WebGLRenderingContext.VERTEX_ATTRIB_ARRAY_TYPE
    override val GL_VERTEX_ATTRIB_ARRAY_NORMALIZED: Int get() = WebGLRenderingContext.VERTEX_ATTRIB_ARRAY_NORMALIZED
    override val GL_VERTEX_ATTRIB_ARRAY_POINTER: Int get() = WebGLRenderingContext.VERTEX_ATTRIB_ARRAY_POINTER
    override val GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING: Int get() = WebGLRenderingContext.VERTEX_ATTRIB_ARRAY_BUFFER_BINDING
    override val GL_COMPILE_STATUS: Int get() = WebGLRenderingContext.COMPILE_STATUS
    override val GL_FRAMEBUFFER: Int get() = WebGLRenderingContext.FRAMEBUFFER
    override val GL_RENDERBUFFER: Int get() = WebGLRenderingContext.RENDERBUFFER
    override val GL_RGBA4: Int get() = WebGLRenderingContext.RGBA4
    override val GL_RGB5_A1: Int get() = WebGLRenderingContext.RGB5_A1
    override val GL_DEPTH_COMPONENT: Int get() = WebGLRenderingContext.DEPTH_COMPONENT
    override val GL_DEPTH_COMPONENT16: Int get() = WebGLRenderingContext.DEPTH_COMPONENT16
    override val GL_STENCIL_INDEX: Int get() = WebGLRenderingContext.STENCIL_INDEX
    override val GL_STENCIL_INDEX8: Int get() = WebGLRenderingContext.STENCIL_INDEX8
    override val GL_RENDERBUFFER_WIDTH: Int get() = WebGLRenderingContext.RENDERBUFFER_WIDTH
    override val GL_RENDERBUFFER_HEIGHT: Int get() = WebGLRenderingContext.RENDERBUFFER_HEIGHT
    override val GL_RENDERBUFFER_INTERNAL_FORMAT: Int get() = WebGLRenderingContext.RENDERBUFFER_INTERNAL_FORMAT
    override val GL_RENDERBUFFER_RED_SIZE: Int get() = WebGLRenderingContext.RENDERBUFFER_RED_SIZE
    override val GL_RENDERBUFFER_GREEN_SIZE: Int get() = WebGLRenderingContext.RENDERBUFFER_GREEN_SIZE
    override val GL_RENDERBUFFER_BLUE_SIZE: Int get() = WebGLRenderingContext.RENDERBUFFER_BLUE_SIZE
    override val GL_RENDERBUFFER_ALPHA_SIZE: Int get() = WebGLRenderingContext.RENDERBUFFER_ALPHA_SIZE
    override val GL_RENDERBUFFER_DEPTH_SIZE: Int get() = WebGLRenderingContext.RENDERBUFFER_DEPTH_SIZE
    override val GL_RENDERBUFFER_STENCIL_SIZE: Int get() = WebGLRenderingContext.RENDERBUFFER_STENCIL_SIZE
    override val GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE: Int get() = WebGLRenderingContext.FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE
    override val GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME: Int get() = WebGLRenderingContext.FRAMEBUFFER_ATTACHMENT_OBJECT_NAME
    override val GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL: Int get() = WebGLRenderingContext.FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL
    override val GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE: Int get() = WebGLRenderingContext.FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE
    override val GL_COLOR_ATTACHMENT0: Int get() = WebGLRenderingContext.COLOR_ATTACHMENT0
    override val GL_DEPTH_ATTACHMENT: Int get() = WebGLRenderingContext.DEPTH_ATTACHMENT
    override val GL_STENCIL_ATTACHMENT: Int get() = WebGLRenderingContext.STENCIL_ATTACHMENT
    override val GL_NONE: Int get() = WebGLRenderingContext.NONE
    override val GL_FRAMEBUFFER_COMPLETE: Int get() = WebGLRenderingContext.FRAMEBUFFER_COMPLETE
    override val GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT: Int get() = WebGLRenderingContext.FRAMEBUFFER_INCOMPLETE_ATTACHMENT
    override val GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT: Int get() = WebGLRenderingContext.FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT
    override val GL_FRAMEBUFFER_UNSUPPORTED: Int get() = WebGLRenderingContext.FRAMEBUFFER_UNSUPPORTED
    override val GL_FRAMEBUFFER_BINDING: Int get() = WebGLRenderingContext.FRAMEBUFFER_BINDING
    override val GL_RENDERBUFFER_BINDING: Int get() = WebGLRenderingContext.RENDERBUFFER_BINDING
    override val GL_MAX_RENDERBUFFER_SIZE: Int get() = WebGLRenderingContext.MAX_RENDERBUFFER_SIZE
    override val GL_INVALID_FRAMEBUFFER_OPERATION: Int get() = WebGLRenderingContext.INVALID_FRAMEBUFFER_OPERATION

    // We assume WebGL 2 at this point in the API, so why does Kotlin not bind against WGL2??
    override val GL_INT: Int get() = WebGLRenderingContext.asDynamic().GL_INT
    override val GL_UNSIGNED_INT: Int get() = WebGLRenderingContext.asDynamic().GL_UNSIGNED_INT

    override fun glAttachShader(program: GLESShaderProgram, shader: GLESShader) {
        context.attachShader(program.asDynamic(), shader.asDynamic())
    }

    override fun glBindAttribLocation(program: GLESShaderProgram, index: Int, name: String) {
        context.bindAttribLocation(program.asDynamic(), index, name)
    }

    override fun glBindFramebuffer(target: Int, framebuffer: GLESFrameBuffer) {
        context.bindFramebuffer(target, framebuffer.asDynamic())
    }

    override fun glBindRenderbuffer(target: Int, renderbuffer: GLESRenderBuffer) {
        context.bindRenderbuffer(target, renderbuffer.asDynamic())
    }

    override fun glBlendColor(red: Float, green: Float, blue: Float, alpha: Float) {
        context.blendColor(red, green, blue, alpha)
    }

    override fun glBlendEquation(mode: Int) {
        context.blendEquation(mode)
    }

    override fun glBlendEquationSeparate(modeRGB: Int, modeAlpha: Int) {
        context.blendEquationSeparate(modeRGB, modeAlpha)
    }

    override fun glBlendFuncSeparate(
        sfactorRGB: Int, dfactorRGB: Int, sfactorAlpha: Int, dfactorAlpha: Int
    ) {
        context.blendFuncSeparate(sfactorRGB, dfactorAlpha, sfactorAlpha, dfactorAlpha)
    }

    override fun glCheckFramebufferStatus(target: Int): Int {
        return context.checkFramebufferStatus(target)
    }

    override fun glCompileShader(shader: GLESShader) {
        context.compileShader(shader.asDynamic())
    }

    override fun glCreateProgram(): GLESShaderProgram {
        return context.createProgram()!!
    }

    override fun glCreateShader(type: Int): GLESShader {
        return context.createShader(type)!!
    }

    override fun glDeleteFramebuffer(framebuffer: GLESFrameBuffer) {
        context.deleteFramebuffer(framebuffer.asDynamic())
    }

    override fun glDeleteProgram(program: GLESShaderProgram) {
        context.deleteProgram(program.asDynamic())
    }

    override fun glDeleteRenderbuffer(renderbuffer: GLESRenderBuffer) {
        context.deleteRenderbuffer(renderbuffer.asDynamic())
    }

    override fun glDeleteShader(shader: GLESShader) {
        context.deleteShader(shader.asDynamic())
    }

    override fun glDetachShader(program: GLESShaderProgram, shader: GLESShader) {
        context.detachShader(program.asDynamic(), shader.asDynamic())
    }

    override fun glDisableVertexAttribArray(index: Int) {
        context.disableVertexAttribArray(index)
    }

    override fun glEnableVertexAttribArray(index: Int) {
        context.enableVertexAttribArray(index)
    }

    override fun glFramebufferRenderbuffer(
        target: Int, attachment: Int, renderbuffertarget: Int, renderbuffer: GLESRenderBuffer
    ) {
        context.framebufferRenderbuffer(target, attachment, renderbuffertarget, renderbuffer.asDynamic())
    }

    override fun glFramebufferTexture2D(
        target: Int, attachment: Int, textarget: Int, texture: GLESTexture, level: Int
    ) {
        context.framebufferTexture2D(target, attachment, textarget, texture.asDynamic(), level)
    }

    override fun glGetFramebufferAttachmentParameteri(target: Int, attachment: Int, pname: Int): Int {
        return context.getFramebufferAttachmentParameter(target, attachment, pname) as? Int ?: 0
    }

    override fun glGenerateMipmap(target: Int) {
        context.generateMipmap(target)
    }

    override fun glGenFramebuffer(): GLESFrameBuffer {
        return context.createFramebuffer()!!
    }

    override fun glGenRenderbuffer(): GLESRenderBuffer {
        return context.createRenderbuffer()!!
    }

    override fun glGetActiveAttrib(
        program: GLESShaderProgram, index: Int, info: GLESActiveInfo
    ) {
        val wglInfo = context.getActiveAttrib(program.asDynamic(), index) ?: return
        info.type = wglInfo.type
        info.size = wglInfo.size
        info.name = wglInfo.name
    }

    override fun glGetActiveUniform(
        program: GLESShaderProgram, index: Int, info: GLESActiveInfo
    ) {
        val wglInfo = context.getActiveUniform(program.asDynamic(), index) ?: return
        info.type = wglInfo.type
        info.size = wglInfo.size
        info.name = wglInfo.name
    }

    override fun glGetAttribLocation(program: GLESShaderProgram, name: String): Int {
        return context.getAttribLocation(program.asDynamic(), name)
    }

    override fun glGetProgramInfoLog(program: GLESShaderProgram): String? {
        return context.getProgramInfoLog(program.asDynamic())
    }

    override fun glGetShaderInfoLog(shader: GLESShader): String? {
        return context.getShaderInfoLog(shader.asDynamic())
    }

    override fun glGetShaderPrecisionFormat(
        shadertype: Int, precisiontype: Int, format: GLESShaderPrecisionFormat
    ) {
        val wglFormat = context.getShaderPrecisionFormat(shadertype, precisiontype) ?: return
        format.precision = wglFormat.precision
        format.rangeMin = wglFormat.rangeMin
        format.rangeMax = wglFormat.rangeMax
    }

    override fun glGetShaderSource(shader: GLESShader): String? {
        return context.getShaderSource(shader.asDynamic())
    }

    override fun glGetUniformLocation(program: GLESShaderProgram, name: String): GLESUniformLocation? {
        return context.getUniformLocation(program.asDynamic(), name)
    }

    override fun glIsFramebuffer(framebuffer: GLESFrameBuffer): Boolean {
        return context.isFramebuffer(framebuffer.asDynamic())
    }

    override fun glIsProgram(program: GLESShaderProgram): Boolean {
        return context.isProgram(program.asDynamic())
    }

    override fun glIsRenderbuffer(renderbuffer: GLESRenderBuffer): Boolean {
        return context.isRenderbuffer(renderbuffer.asDynamic())
    }

    override fun glIsShader(shader: GLESShader): Boolean {
        return context.isShader(shader.asDynamic())
    }

    override fun glLinkProgram(program: GLESShaderProgram) {
        context.linkProgram(program.asDynamic())
    }

    override fun glRenderbufferStorage(
        target: Int, internalformat: Int, width: Int, height: Int
    ) {
        context.renderbufferStorage(target, internalformat, width, height)
    }

    override fun glGetRenderbufferParameteri(target: Int, pname: Int): Int {
        return context.getRenderbufferParameter(target, pname) as? Int ?: 0
    }

    override fun glShaderSource(shader: GLESShader, source: String) {
        context.shaderSource(shader.asDynamic(), source)
    }

    override fun glGetProgrami(program: GLESShaderProgram, pname: Int): Int {
        return context.getProgramParameter(program.asDynamic(), pname) as? Int ?: 0
    }

    override fun glGetShaderi(shader: GLESShader, pname: Int): Int {
        return context.getShaderParameter(shader.asDynamic(), pname) as? Int ?: 0
    }

    override fun glStencilFuncSeparate(face: Int, func: Int, ref: Int, mask: Int) {
        context.stencilFuncSeparate(face, func, ref, mask)
    }

    override fun glStencilMaskSeparate(face: Int, mask: Int) {
        context.stencilMaskSeparate(face, mask)
    }

    override fun glStencilOpSeparate(face: Int, sfail: Int, dpfail: Int, dppass: Int) {
        context.stencilOpSeparate(face, sfail, dpfail, dppass)
    }

    override fun glUniform1f(location: GLESUniformLocation, v0: Float) {
        context.uniform1f(location.asDynamic(), v0)
    }

    override fun glUniform1fv(location: GLESUniformLocation, value: FloatArray) {
        context.uniform1fv(location.asDynamic(), value.toTypedArray())
    }

    override fun glUniform1i(location: GLESUniformLocation, v0: Int) {
        context.uniform1i(location.asDynamic(), v0)
    }

    override fun glUniform1iv(location: GLESUniformLocation, value: IntArray) {
        context.uniform1iv(location.asDynamic(), value.toTypedArray())
    }

    override fun glUniform2f(location: GLESUniformLocation, v0: Float, v1: Float) {
        context.uniform2f(location.asDynamic(), v0, v1)
    }

    override fun glUniform2fv(location: GLESUniformLocation, value: FloatArray) {
        context.uniform2fv(location.asDynamic(), value.toTypedArray())
    }

    override fun glUniform2i(location: GLESUniformLocation, v0: Int, v1: Int) {
        context.uniform2i(location.asDynamic(), v0, v1)
    }

    override fun glUniform2iv(location: GLESUniformLocation, value: IntArray) {
        context.uniform2iv(location.asDynamic(), value.toTypedArray())
    }

    override fun glUniform3f(location: GLESUniformLocation, v0: Float, v1: Float, v2: Float) {
        context.uniform3f(location.asDynamic(), v0, v1, v2)
    }

    override fun glUniform3fv(location: GLESUniformLocation, value: FloatArray) {
        context.uniform3fv(location.asDynamic(), value.toTypedArray())
    }

    override fun glUniform3i(location: GLESUniformLocation, v0: Int, v1: Int, v2: Int) {
        context.uniform3i(location.asDynamic(), v0, v1, v2)
    }

    override fun glUniform3iv(location: GLESUniformLocation, value: IntArray) {
        context.uniform3iv(location.asDynamic(), value.toTypedArray())
    }

    override fun glUniform4f(
        location: GLESUniformLocation, v0: Float, v1: Float, v2: Float, v3: Float
    ) {
        context.uniform4f(location.asDynamic(), v0, v1, v2, v3)
    }

    override fun glUniform4fv(location: GLESUniformLocation, value: FloatArray) {
        context.uniform4fv(location.asDynamic(), value.toTypedArray())
    }

    override fun glUniform4i(location: GLESUniformLocation, v0: Int, v1: Int, v2: Int, v3: Int) {
        context.uniform4i(location.asDynamic(), v0, v1, v2, v3)
    }

    override fun glUniform4iv(location: GLESUniformLocation, value: IntArray) {
        context.uniform4iv(location.asDynamic(), value.toTypedArray())
    }

    override fun glUniformMatrix2fv(location: GLESUniformLocation, transpose: Boolean, value: FloatArray) {
        context.uniformMatrix2fv(location.asDynamic(), transpose, value.toTypedArray())
    }

    override fun glUniformMatrix3fv(location: GLESUniformLocation, transpose: Boolean, value: FloatArray) {
        context.uniformMatrix3fv(location.asDynamic(), transpose, value.toTypedArray())
    }

    override fun glUniformMatrix4fv(location: GLESUniformLocation, transpose: Boolean, value: FloatArray) {
        context.uniformMatrix4fv(location.asDynamic(), transpose, value.toTypedArray())
    }

    override fun glUseProgram(program: GLESShaderProgram) {
        context.useProgram(program.asDynamic())
    }

    override fun glValidateProgram(program: GLESShaderProgram) {
        context.validateProgram(program.asDynamic())
    }

    override fun glVertexAttrib1f(index: Int, x: Float) {
        context.vertexAttrib1f(index, x)
    }

    override fun glVertexAttrib1fv(index: Int, v: FloatArray) {
        context.vertexAttrib1fv(index, v.toTypedArray())
    }

    override fun glVertexAttrib2f(index: Int, x: Float, y: Float) {
        context.vertexAttrib2f(index, x, y)
    }

    override fun glVertexAttrib2fv(index: Int, v: FloatArray) {
        context.vertexAttrib2fv(index, v.toTypedArray())
    }

    override fun glVertexAttrib3f(index: Int, x: Float, y: Float, z: Float) {
        context.vertexAttrib3f(index, x, y, z)
    }

    override fun glVertexAttrib3fv(index: Int, v: FloatArray) {
        context.vertexAttrib3fv(index, v.toTypedArray())
    }

    override fun glVertexAttrib4f(
        index: Int, x: Float, y: Float, z: Float, w: Float
    ) {
        context.vertexAttrib4f(index, x, y, z, w)
    }

    override fun glVertexAttrib4fv(index: Int, v: FloatArray) {
        context.vertexAttrib4fv(index, v.toTypedArray())
    }

    override fun glVertexAttribPointer(
        index: Int, size: Int, type: Int, normalized: Boolean, stride: Int, offset: Long
    ) {
        context.vertexAttribPointer(index, size, type, normalized, stride, offset.toInt())
    }
}