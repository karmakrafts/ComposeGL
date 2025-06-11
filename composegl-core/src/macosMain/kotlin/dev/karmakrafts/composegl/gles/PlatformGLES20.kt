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

import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.COpaque
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.alloc
import kotlinx.cinterop.allocArray
import kotlinx.cinterop.cValuesOf
import kotlinx.cinterop.convert
import kotlinx.cinterop.cstr
import kotlinx.cinterop.free
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.nativeHeap
import kotlinx.cinterop.ptr
import kotlinx.cinterop.toCPointer
import kotlinx.cinterop.toKStringFromUtf8
import kotlinx.cinterop.value
import platform.OpenGL.GL_MAX_FRAGMENT_UNIFORM_COMPONENTS
import platform.OpenGL.GL_MAX_VARYING_COMPONENTS_EXT
import platform.OpenGL.GL_MAX_VERTEX_UNIFORM_COMPONENTS
import platform.OpenGLCommon.GLenumVar
import platform.OpenGLCommon.GLintVar
import platform.OpenGLCommon.GLuintVar

@OptIn(ExperimentalForeignApi::class)
internal object PlatformGLES20 : GLES20, GLES11 by PlatformGLES11 {
    override val GL_FUNC_ADD: Int get() = platform.OpenGL.GL_FUNC_ADD
    override val GL_BLEND_EQUATION: Int get() = platform.OpenGL.GL_BLEND_EQUATION
    override val GL_BLEND_EQUATION_RGB: Int get() = platform.OpenGL.GL_BLEND_EQUATION_RGB
    override val GL_BLEND_EQUATION_ALPHA: Int get() = platform.OpenGL.GL_BLEND_EQUATION_ALPHA
    override val GL_FUNC_SUBTRACT: Int get() = platform.OpenGL.GL_FUNC_SUBTRACT
    override val GL_FUNC_REVERSE_SUBTRACT: Int get() = platform.OpenGL.GL_FUNC_REVERSE_SUBTRACT
    override val GL_BLEND_DST_RGB: Int get() = platform.OpenGL.GL_BLEND_DST_RGB
    override val GL_BLEND_SRC_RGB: Int get() = platform.OpenGL.GL_BLEND_SRC_RGB
    override val GL_BLEND_DST_ALPHA: Int get() = platform.OpenGL.GL_BLEND_DST_ALPHA
    override val GL_BLEND_SRC_ALPHA: Int get() = platform.OpenGL.GL_BLEND_SRC_ALPHA
    override val GL_CONSTANT_COLOR: Int get() = platform.OpenGL.GL_CONSTANT_COLOR
    override val GL_ONE_MINUS_CONSTANT_COLOR: Int get() = platform.OpenGL.GL_ONE_MINUS_CONSTANT_COLOR
    override val GL_CONSTANT_ALPHA: Int get() = platform.OpenGL.GL_CONSTANT_ALPHA
    override val GL_ONE_MINUS_CONSTANT_ALPHA: Int get() = platform.OpenGL.GL_ONE_MINUS_CONSTANT_ALPHA
    override val GL_BLEND_COLOR: Int get() = platform.OpenGL.GL_BLEND_COLOR
    override val GL_STREAM_DRAW: Int get() = platform.OpenGL.GL_STREAM_DRAW
    override val GL_CURRENT_VERTEX_ATTRIB: Int get() = platform.OpenGL.GL_CURRENT_VERTEX_ATTRIB
    override val GL_STENCIL_BACK_FUNC: Int get() = platform.OpenGL.GL_STENCIL_BACK_FUNC
    override val GL_STENCIL_BACK_FAIL: Int get() = platform.OpenGL.GL_STENCIL_BACK_FAIL
    override val GL_STENCIL_BACK_PASS_DEPTH_FAIL: Int get() = platform.OpenGL.GL_STENCIL_BACK_PASS_DEPTH_FAIL
    override val GL_STENCIL_BACK_PASS_DEPTH_PASS: Int get() = platform.OpenGL.GL_STENCIL_BACK_PASS_DEPTH_PASS
    override val GL_STENCIL_BACK_REF: Int get() = platform.OpenGL.GL_STENCIL_BACK_REF
    override val GL_STENCIL_BACK_VALUE_MASK: Int get() = platform.OpenGL.GL_STENCIL_BACK_VALUE_MASK
    override val GL_STENCIL_BACK_WRITEMASK: Int get() = platform.OpenGL.GL_STENCIL_BACK_WRITEMASK
    override val GL_MIRRORED_REPEAT: Int get() = platform.OpenGL.GL_MIRRORED_REPEAT
    override val GL_FRAGMENT_SHADER: Int get() = platform.OpenGL.GL_FRAGMENT_SHADER
    override val GL_VERTEX_SHADER: Int get() = platform.OpenGL.GL_VERTEX_SHADER
    override val GL_MAX_VERTEX_ATTRIBS: Int get() = platform.OpenGL.GL_MAX_VERTEX_ATTRIBS
    override val GL_MAX_VERTEX_UNIFORM_VECTORS: Int get() = GL_MAX_VERTEX_UNIFORM_COMPONENTS
    override val GL_MAX_VARYING_VECTORS: Int get() = GL_MAX_VARYING_COMPONENTS_EXT
    override val GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS: Int get() = platform.OpenGL.GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS
    override val GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS: Int get() = platform.OpenGL.GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS
    override val GL_MAX_TEXTURE_IMAGE_UNITS: Int get() = platform.OpenGL.GL_MAX_TEXTURE_IMAGE_UNITS
    override val GL_MAX_FRAGMENT_UNIFORM_VECTORS: Int get() = GL_MAX_FRAGMENT_UNIFORM_COMPONENTS
    override val GL_SHADER_TYPE: Int get() = platform.OpenGL.GL_SHADER_TYPE
    override val GL_DELETE_STATUS: Int get() = platform.OpenGL.GL_DELETE_STATUS
    override val GL_LINK_STATUS: Int get() = platform.OpenGL.GL_LINK_STATUS
    override val GL_VALIDATE_STATUS: Int get() = platform.OpenGL.GL_VALIDATE_STATUS
    override val GL_ATTACHED_SHADERS: Int get() = platform.OpenGL.GL_ATTACHED_SHADERS
    override val GL_ACTIVE_UNIFORMS: Int get() = platform.OpenGL.GL_ACTIVE_UNIFORMS
    override val GL_ACTIVE_ATTRIBUTES: Int get() = platform.OpenGL.GL_ACTIVE_ATTRIBUTES
    override val GL_SHADING_LANGUAGE_VERSION: Int get() = platform.OpenGL.GL_SHADING_LANGUAGE_VERSION
    override val GL_CURRENT_PROGRAM: Int get() = platform.OpenGL.GL_CURRENT_PROGRAM
    override val GL_INCR_WRAP: Int get() = platform.OpenGL.GL_INCR_WRAP
    override val GL_DECR_WRAP: Int get() = platform.OpenGL.GL_DECR_WRAP
    override val GL_TEXTURE_CUBE_MAP: Int get() = platform.OpenGL.GL_TEXTURE_CUBE_MAP
    override val GL_TEXTURE_BINDING_CUBE_MAP: Int get() = platform.OpenGL.GL_TEXTURE_BINDING_CUBE_MAP
    override val GL_TEXTURE_CUBE_MAP_POSITIVE_X: Int get() = platform.OpenGL.GL_TEXTURE_CUBE_MAP_POSITIVE_X
    override val GL_TEXTURE_CUBE_MAP_NEGATIVE_X: Int get() = platform.OpenGL.GL_TEXTURE_CUBE_MAP_NEGATIVE_X
    override val GL_TEXTURE_CUBE_MAP_POSITIVE_Y: Int get() = platform.OpenGL.GL_TEXTURE_CUBE_MAP_POSITIVE_Y
    override val GL_TEXTURE_CUBE_MAP_NEGATIVE_Y: Int get() = platform.OpenGL.GL_TEXTURE_CUBE_MAP_NEGATIVE_Y
    override val GL_TEXTURE_CUBE_MAP_POSITIVE_Z: Int get() = platform.OpenGL.GL_TEXTURE_CUBE_MAP_POSITIVE_Z
    override val GL_TEXTURE_CUBE_MAP_NEGATIVE_Z: Int get() = platform.OpenGL.GL_TEXTURE_CUBE_MAP_NEGATIVE_Z
    override val GL_MAX_CUBE_MAP_TEXTURE_SIZE: Int get() = platform.OpenGL.GL_MAX_CUBE_MAP_TEXTURE_SIZE
    override val GL_INT: Int get() = platform.OpenGL.GL_INT
    override val GL_UNSIGNED_INT: Int get() = platform.OpenGL.GL_UNSIGNED_INT
    override val GL_FLOAT_VEC2: Int get() = platform.OpenGL.GL_FLOAT_VEC2
    override val GL_FLOAT_VEC3: Int get() = platform.OpenGL.GL_FLOAT_VEC3
    override val GL_FLOAT_VEC4: Int get() = platform.OpenGL.GL_FLOAT_VEC4
    override val GL_INT_VEC2: Int get() = platform.OpenGL.GL_INT_VEC2
    override val GL_INT_VEC3: Int get() = platform.OpenGL.GL_INT_VEC3
    override val GL_INT_VEC4: Int get() = platform.OpenGL.GL_INT_VEC4
    override val GL_BOOL: Int get() = platform.OpenGL.GL_BOOL
    override val GL_BOOL_VEC2: Int get() = platform.OpenGL.GL_BOOL_VEC2
    override val GL_BOOL_VEC3: Int get() = platform.OpenGL.GL_BOOL_VEC3
    override val GL_BOOL_VEC4: Int get() = platform.OpenGL.GL_BOOL_VEC4
    override val GL_FLOAT_MAT2: Int get() = platform.OpenGL.GL_FLOAT_MAT2
    override val GL_FLOAT_MAT3: Int get() = platform.OpenGL.GL_FLOAT_MAT3
    override val GL_FLOAT_MAT4: Int get() = platform.OpenGL.GL_FLOAT_MAT4
    override val GL_SAMPLER_2D: Int get() = platform.OpenGL.GL_SAMPLER_2D
    override val GL_SAMPLER_CUBE: Int get() = platform.OpenGL.GL_SAMPLER_CUBE
    override val GL_VERTEX_ATTRIB_ARRAY_ENABLED: Int get() = platform.OpenGL.GL_VERTEX_ATTRIB_ARRAY_ENABLED
    override val GL_VERTEX_ATTRIB_ARRAY_SIZE: Int get() = platform.OpenGL.GL_VERTEX_ATTRIB_ARRAY_SIZE
    override val GL_VERTEX_ATTRIB_ARRAY_STRIDE: Int get() = platform.OpenGL.GL_VERTEX_ATTRIB_ARRAY_STRIDE
    override val GL_VERTEX_ATTRIB_ARRAY_TYPE: Int get() = platform.OpenGL.GL_VERTEX_ATTRIB_ARRAY_TYPE
    override val GL_VERTEX_ATTRIB_ARRAY_NORMALIZED: Int get() = platform.OpenGL.GL_VERTEX_ATTRIB_ARRAY_NORMALIZED
    override val GL_VERTEX_ATTRIB_ARRAY_POINTER: Int get() = platform.OpenGL.GL_VERTEX_ATTRIB_ARRAY_POINTER
    override val GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING: Int get() = platform.OpenGL.GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING
    override val GL_COMPILE_STATUS: Int get() = platform.OpenGL.GL_COMPILE_STATUS
    override val GL_FRAMEBUFFER: Int get() = platform.OpenGL.GL_FRAMEBUFFER
    override val GL_RENDERBUFFER: Int get() = platform.OpenGL.GL_RENDERBUFFER
    override val GL_RGBA4: Int get() = platform.OpenGL.GL_RGBA4
    override val GL_RGB5_A1: Int get() = platform.OpenGL.GL_RGB5_A1
    override val GL_DEPTH_COMPONENT: Int get() = platform.OpenGL.GL_DEPTH_COMPONENT
    override val GL_DEPTH_COMPONENT16: Int get() = platform.OpenGL.GL_DEPTH_COMPONENT16
    override val GL_STENCIL_INDEX: Int get() = platform.OpenGL.GL_STENCIL_INDEX
    override val GL_STENCIL_INDEX8: Int get() = platform.OpenGL.GL_STENCIL_INDEX8
    override val GL_RENDERBUFFER_WIDTH: Int get() = platform.OpenGL.GL_RENDERBUFFER_WIDTH
    override val GL_RENDERBUFFER_HEIGHT: Int get() = platform.OpenGL.GL_RENDERBUFFER_HEIGHT
    override val GL_RENDERBUFFER_INTERNAL_FORMAT: Int get() = platform.OpenGL.GL_RENDERBUFFER_INTERNAL_FORMAT
    override val GL_RENDERBUFFER_RED_SIZE: Int get() = platform.OpenGL.GL_RENDERBUFFER_RED_SIZE
    override val GL_RENDERBUFFER_GREEN_SIZE: Int get() = platform.OpenGL.GL_RENDERBUFFER_GREEN_SIZE
    override val GL_RENDERBUFFER_BLUE_SIZE: Int get() = platform.OpenGL.GL_RENDERBUFFER_BLUE_SIZE
    override val GL_RENDERBUFFER_ALPHA_SIZE: Int get() = platform.OpenGL.GL_RENDERBUFFER_ALPHA_SIZE
    override val GL_RENDERBUFFER_DEPTH_SIZE: Int get() = platform.OpenGL.GL_RENDERBUFFER_DEPTH_SIZE
    override val GL_RENDERBUFFER_STENCIL_SIZE: Int get() = platform.OpenGL.GL_RENDERBUFFER_STENCIL_SIZE
    override val GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE: Int get() = platform.OpenGL.GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE
    override val GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME: Int get() = platform.OpenGL.GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME
    override val GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL: Int get() = platform.OpenGL.GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL
    override val GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE: Int get() = platform.OpenGL.GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE
    override val GL_COLOR_ATTACHMENT0: Int get() = platform.OpenGL.GL_COLOR_ATTACHMENT0
    override val GL_DEPTH_ATTACHMENT: Int get() = platform.OpenGL.GL_DEPTH_ATTACHMENT
    override val GL_STENCIL_ATTACHMENT: Int get() = platform.OpenGL.GL_STENCIL_ATTACHMENT
    override val GL_NONE: Int get() = platform.OpenGL.GL_NONE
    override val GL_FRAMEBUFFER_COMPLETE: Int get() = platform.OpenGL.GL_FRAMEBUFFER_COMPLETE
    override val GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT: Int get() = platform.OpenGL.GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT
    override val GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT: Int get() = platform.OpenGL.GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT
    override val GL_FRAMEBUFFER_UNSUPPORTED: Int get() = platform.OpenGL.GL_FRAMEBUFFER_UNSUPPORTED
    override val GL_FRAMEBUFFER_BINDING: Int get() = platform.OpenGL.GL_FRAMEBUFFER_BINDING
    override val GL_RENDERBUFFER_BINDING: Int get() = platform.OpenGL.GL_RENDERBUFFER_BINDING
    override val GL_MAX_RENDERBUFFER_SIZE: Int get() = platform.OpenGL.GL_MAX_RENDERBUFFER_SIZE
    override val GL_INVALID_FRAMEBUFFER_OPERATION: Int get() = platform.OpenGL.GL_INVALID_FRAMEBUFFER_OPERATION

    private const val MAX_NAME_SIZE: Int = 4096

    override fun glAttachShader(program: GLESShaderProgram, shader: GLESShader) {
        platform.OpenGL.glAttachShader(program.convert(), shader.convert())
    }

    override fun glBindAttribLocation(program: GLESShaderProgram, index: Int, name: String) {
        platform.OpenGL.glBindAttribLocation(program.convert(), index.convert(), name)
    }

    override fun glBindFramebuffer(target: Int, framebuffer: GLESFrameBuffer) {
        platform.OpenGL.glBindFramebuffer(target.convert(), framebuffer.convert())
    }

    override fun glBindRenderbuffer(target: Int, renderbuffer: GLESRenderBuffer) {
        platform.OpenGL.glBindRenderbuffer(target.convert(), renderbuffer.convert())
    }

    override fun glBlendColor(red: Float, green: Float, blue: Float, alpha: Float) {
        platform.OpenGL.glBlendColor(red, green, blue, alpha)
    }

    override fun glBlendEquation(mode: Int) {
        platform.OpenGL.glBlendEquation(mode.convert())
    }

    override fun glBlendEquationSeparate(modeRGB: Int, modeAlpha: Int) {
        platform.OpenGL.glBlendEquationSeparate(modeRGB.convert(), modeAlpha.convert())
    }

    override fun glBlendFuncSeparate(
        sfactorRGB: Int, dfactorRGB: Int, sfactorAlpha: Int, dfactorAlpha: Int
    ) {
        platform.OpenGL.glBlendFuncSeparate(
            sfactorRGB.convert(), dfactorRGB.convert(), sfactorAlpha.convert(), dfactorAlpha.convert()
        )
    }

    override fun glCheckFramebufferStatus(target: Int): Int {
        return platform.OpenGL.glCheckFramebufferStatus(target.convert()).convert()
    }

    override fun glCompileShader(shader: GLESShader) {
        platform.OpenGL.glCompileShader(shader.convert())
    }

    override fun glCreateProgram(): GLESShaderProgram {
        return platform.OpenGL.glCreateProgram().convert()
    }

    override fun glCreateShader(type: Int): GLESShader {
        return platform.OpenGL.glCreateShader(type.convert()).convert()
    }

    override fun glDeleteFramebuffer(framebuffer: GLESFrameBuffer) {
        platform.OpenGL.glDeleteFramebuffers(1, cValuesOf(framebuffer.toUInt()))
    }

    override fun glDeleteProgram(program: GLESShaderProgram) {
        platform.OpenGL.glDeleteProgram(program.convert())
    }

    override fun glDeleteRenderbuffer(renderbuffer: GLESRenderBuffer) {
        platform.OpenGL.glDeleteRenderbuffers(1, cValuesOf(renderbuffer.toUInt()))
    }

    override fun glDeleteShader(shader: GLESShader) {
        platform.OpenGL.glDeleteShader(shader.convert())
    }

    override fun glDetachShader(program: GLESShaderProgram, shader: GLESShader) {
        platform.OpenGL.glDetachShader(program.convert(), shader.convert())
    }

    override fun glDisableVertexAttribArray(index: Int) {
        platform.OpenGL.glDisableVertexAttribArray(index.convert())
    }

    override fun glEnableVertexAttribArray(index: Int) {
        platform.OpenGL.glEnableVertexAttribArray(index.convert())
    }

    override fun glFramebufferRenderbuffer(
        target: Int, attachment: Int, renderbuffertarget: Int, renderbuffer: GLESRenderBuffer
    ) {
        platform.OpenGL.glFramebufferRenderbuffer(
            target.convert(), attachment.convert(), renderbuffertarget.convert(), renderbuffer.convert()
        )
    }

    override fun glFramebufferTexture2D(
        target: Int, attachment: Int, textarget: Int, texture: GLESTexture, level: Int
    ) {
        platform.OpenGL.glFramebufferTexture2D(
            target.convert(), attachment.convert(), textarget.convert(), texture.convert(), level
        )
    }

    override fun glGetFramebufferAttachmentParameteri(target: Int, attachment: Int, pname: Int): Int = memScoped {
        val value = alloc<GLintVar>()
        platform.OpenGL.glGetFramebufferAttachmentParameteriv(
            target.convert(),
            attachment.convert(),
            pname.convert(),
            value.ptr
        )
        value.value
    }

    override fun glGenerateMipmap(target: Int) {
        platform.OpenGL.glGenerateMipmap(target.convert())
    }

    override fun glGenFramebuffer(): GLESFrameBuffer = memScoped {
        val id = alloc<GLuintVar>()
        platform.OpenGL.glGenFramebuffers(1, id.ptr)
        id.value.toInt()
    }

    override fun glGenRenderbuffer(): GLESRenderBuffer = memScoped {
        val id = alloc<GLuintVar>()
        platform.OpenGL.glGenRenderbuffers(1, id.ptr)
        id.value.toInt()
    }

    override fun glGetActiveAttrib(
        program: GLESShaderProgram, index: Int, info: GLESActiveInfo
    ) = memScoped {
        val size = alloc<GLintVar>()
        val type = alloc<GLenumVar>()
        val name = allocArray<ByteVar>(MAX_NAME_SIZE)
        platform.OpenGL.glGetActiveAttrib(
            program.convert(), index.convert(), MAX_NAME_SIZE, null, size.ptr, type.ptr, name
        )
        info.size = size.value
        info.type = type.value.convert()
        info.name = name.toKStringFromUtf8()
    }

    override fun glGetActiveUniform(
        program: GLESShaderProgram, index: Int, info: GLESActiveInfo
    ) = memScoped {
        val size = alloc<GLintVar>()
        val type = alloc<GLenumVar>()
        val name = allocArray<ByteVar>(MAX_NAME_SIZE)
        platform.OpenGL.glGetActiveUniform(
            program.convert(), index.convert(), MAX_NAME_SIZE, null, size.ptr, type.ptr, name
        )
        info.size = size.value
        info.type = type.value.convert()
        info.name = name.toKStringFromUtf8()
    }

    override fun glGetAttribLocation(program: GLESShaderProgram, name: String): Int {
        return platform.OpenGL.glGetAttribLocation(program.convert(), name).convert()
    }

    override fun glGetProgramInfoLog(program: GLESShaderProgram): String? = memScoped {
        val length = alloc<GLintVar>()
        platform.OpenGL.glGetProgramiv(program.convert(), platform.OpenGL.GL_INFO_LOG_LENGTH.convert(), length.ptr)
        if (length.value == 0) return@memScoped null
        val bufferSize = length.value + 1 // Include null-terminator
        val logBuffer = nativeHeap.allocArray<ByteVar>(bufferSize)
        platform.OpenGL.glGetProgramInfoLog(program.convert(), bufferSize.convert(), null, logBuffer)
        val log = logBuffer.toKStringFromUtf8()
        nativeHeap.free(logBuffer)
        log
    }

    override fun glGetShaderInfoLog(shader: GLESShader): String? = memScoped {
        val length = alloc<GLintVar>()
        platform.OpenGL.glGetShaderiv(shader.convert(), platform.OpenGL.GL_INFO_LOG_LENGTH.convert(), length.ptr)
        if (length.value == 0) return@memScoped null
        val bufferSize = length.value + 1 // Include null-terminator
        val logBuffer = nativeHeap.allocArray<ByteVar>(bufferSize)
        platform.OpenGL.glGetShaderInfoLog(shader.convert(), bufferSize.convert(), null, logBuffer)
        val log = logBuffer.toKStringFromUtf8()
        nativeHeap.free(logBuffer)
        log
    }

    override fun glGetShaderPrecisionFormat(
        shadertype: Int, precisiontype: Int, format: GLESShaderPrecisionFormat
    ) {
        // Dummy response common on macOS systems
        format.precision = 23
        format.rangeMin = 127
        format.rangeMax = 127
    }

    override fun glGetShaderSource(shader: GLESShader): String? = memScoped {
        val length = alloc<GLintVar>()
        platform.OpenGL.glGetShaderiv(shader.convert(), platform.OpenGL.GL_SHADER_SOURCE_LENGTH.convert(), length.ptr)
        if (length.value == 0) return@memScoped null
        val bufferSize = length.value + 1 // Include null-terminator
        val sourceBuffer = nativeHeap.allocArray<ByteVar>(bufferSize)
        platform.OpenGL.glGetShaderSource(shader.convert(), bufferSize.convert(), null, sourceBuffer)
        val log = sourceBuffer.toKStringFromUtf8()
        nativeHeap.free(sourceBuffer)
        log
    }

    override fun glGetUniformLocation(program: GLESShaderProgram, name: String): GLESUniformLocation {
        return platform.OpenGL.glGetUniformLocation(program.convert(), name)
    }

    override fun glIsFramebuffer(framebuffer: GLESFrameBuffer): Boolean {
        return platform.OpenGL.glIsFramebuffer(framebuffer.convert()).convert<Int>() == GL_TRUE
    }

    override fun glIsProgram(program: GLESShaderProgram): Boolean {
        return platform.OpenGL.glIsProgram(program.convert()).convert<Int>() == GL_TRUE
    }

    override fun glIsRenderbuffer(renderbuffer: GLESRenderBuffer): Boolean {
        return platform.OpenGL.glIsRenderbuffer(renderbuffer.convert()).convert<Int>() == GL_TRUE
    }

    override fun glIsShader(shader: GLESShader): Boolean {
        return platform.OpenGL.glIsShader(shader.convert()).convert<Int>() == GL_TRUE
    }

    override fun glLinkProgram(program: GLESShaderProgram) {
        platform.OpenGL.glLinkProgram(program.convert())
    }

    override fun glRenderbufferStorage(
        target: Int, internalformat: Int, width: Int, height: Int
    ) {
        platform.OpenGL.glRenderbufferStorage(target.convert(), internalformat.convert(), width, height)
    }

    override fun glGetRenderbufferParameteri(target: Int, pname: Int): Int = memScoped {
        val value = alloc<GLintVar>()
        platform.OpenGL.glGetRenderbufferParameteriv(target.convert(), pname.convert(), value.ptr)
        value.value
    }

    override fun glShaderSource(shader: GLESShader, source: String) = memScoped {
        platform.OpenGL.glShaderSource(shader.convert(), 1, cValuesOf(source.cstr.ptr), cValuesOf(source.length))
    }

    override fun glGetProgrami(program: GLESShaderProgram, pname: Int): Int = memScoped {
        val value = alloc<GLintVar>()
        platform.OpenGL.glGetProgramiv(program.convert(), pname.convert(), value.ptr)
        value.value
    }

    override fun glGetShaderi(shader: GLESShader, pname: Int): Int = memScoped {
        val value = alloc<GLintVar>()
        platform.OpenGL.glGetShaderiv(shader.convert(), pname.convert(), value.ptr)
        value.value
    }

    override fun glStencilFuncSeparate(face: Int, func: Int, ref: Int, mask: Int) {
        platform.OpenGL.glStencilFuncSeparate(face.convert(), func.convert(), ref, mask.convert())
    }

    override fun glStencilMaskSeparate(face: Int, mask: Int) {
        platform.OpenGL.glStencilMaskSeparate(face.convert(), mask.convert())
    }

    override fun glStencilOpSeparate(face: Int, sfail: Int, dpfail: Int, dppass: Int) {
        platform.OpenGL.glStencilOpSeparate(face.convert(), sfail.convert(), dpfail.convert(), dppass.convert())
    }

    override fun glUniform1f(location: GLESUniformLocation, v0: Float) {
        platform.OpenGL.glUniform1f(location, v0)
    }

    override fun glUniform1fv(location: GLESUniformLocation, value: FloatArray) {
        platform.OpenGL.glUniform1fv(location, value.size.convert(), cValuesOf(*value))
    }

    override fun glUniform1i(location: GLESUniformLocation, v0: Int) {
        platform.OpenGL.glUniform1i(location, v0)
    }

    override fun glUniform1iv(location: GLESUniformLocation, value: IntArray) {
        platform.OpenGL.glUniform1iv(location, value.size.convert(), cValuesOf(*value))
    }

    override fun glUniform2f(location: GLESUniformLocation, v0: Float, v1: Float) {
        platform.OpenGL.glUniform2f(location, v0, v1)
    }

    override fun glUniform2fv(location: GLESUniformLocation, value: FloatArray) {
        platform.OpenGL.glUniform2fv(location, value.size.convert(), cValuesOf(*value))
    }

    override fun glUniform2i(location: GLESUniformLocation, v0: Int, v1: Int) {
        platform.OpenGL.glUniform2i(location, v0, v1)
    }

    override fun glUniform2iv(location: GLESUniformLocation, value: IntArray) {
        platform.OpenGL.glUniform2iv(location, value.size.convert(), cValuesOf(*value))
    }

    override fun glUniform3f(location: GLESUniformLocation, v0: Float, v1: Float, v2: Float) {
        platform.OpenGL.glUniform3f(location, v0, v1, v2)
    }

    override fun glUniform3fv(location: GLESUniformLocation, value: FloatArray) {
        platform.OpenGL.glUniform3fv(location, value.size.convert(), cValuesOf(*value))
    }

    override fun glUniform3i(location: GLESUniformLocation, v0: Int, v1: Int, v2: Int) {
        platform.OpenGL.glUniform3i(location, v0, v1, v2)
    }

    override fun glUniform3iv(location: GLESUniformLocation, value: IntArray) {
        platform.OpenGL.glUniform3iv(location, value.size.convert(), cValuesOf(*value))
    }

    override fun glUniform4f(
        location: GLESUniformLocation, v0: Float, v1: Float, v2: Float, v3: Float
    ) {
        platform.OpenGL.glUniform4f(location, v0, v1, v2, v3)
    }

    override fun glUniform4fv(location: GLESUniformLocation, value: FloatArray) {
        platform.OpenGL.glUniform4fv(location, value.size.convert(), cValuesOf(*value))
    }

    override fun glUniform4i(location: GLESUniformLocation, v0: Int, v1: Int, v2: Int, v3: Int) {
        platform.OpenGL.glUniform4i(location, v0, v1, v2, v3)
    }

    override fun glUniform4iv(location: GLESUniformLocation, value: IntArray) {
        platform.OpenGL.glUniform4iv(location, value.size.convert(), cValuesOf(*value))
    }

    override fun glUniformMatrix2fv(location: GLESUniformLocation, transpose: Boolean, value: FloatArray) {
        platform.OpenGL.glUniformMatrix2fv(location, transpose.toGLBool(), value.size.convert(), cValuesOf(*value))
    }

    override fun glUniformMatrix3fv(location: GLESUniformLocation, transpose: Boolean, value: FloatArray) {
        platform.OpenGL.glUniformMatrix3fv(location, transpose.toGLBool(), value.size.convert(), cValuesOf(*value))
    }

    override fun glUniformMatrix4fv(location: GLESUniformLocation, transpose: Boolean, value: FloatArray) {
        platform.OpenGL.glUniformMatrix4fv(location, transpose.toGLBool(), value.size.convert(), cValuesOf(*value))
    }

    override fun glUseProgram(program: GLESShaderProgram) {
        platform.OpenGL.glUseProgram(program.convert())
    }

    override fun glValidateProgram(program: GLESShaderProgram) {
        platform.OpenGL.glValidateProgram(program.convert())
    }

    override fun glVertexAttrib1f(index: Int, x: Float) {
        platform.OpenGL.glVertexAttrib1f(index.convert(), x)
    }

    override fun glVertexAttrib1fv(index: Int, v: FloatArray) {
        platform.OpenGL.glVertexAttrib1fv(index.convert(), cValuesOf(*v))
    }

    override fun glVertexAttrib2f(index: Int, x: Float, y: Float) {
        platform.OpenGL.glVertexAttrib2f(index.convert(), x, y)
    }

    override fun glVertexAttrib2fv(index: Int, v: FloatArray) {
        platform.OpenGL.glVertexAttrib2fv(index.convert(), cValuesOf(*v))
    }

    override fun glVertexAttrib3f(index: Int, x: Float, y: Float, z: Float) {
        platform.OpenGL.glVertexAttrib3f(index.convert(), x, y, z)
    }

    override fun glVertexAttrib3fv(index: Int, v: FloatArray) {
        platform.OpenGL.glVertexAttrib3fv(index.convert(), cValuesOf(*v))
    }

    override fun glVertexAttrib4f(
        index: Int, x: Float, y: Float, z: Float, w: Float
    ) {
        platform.OpenGL.glVertexAttrib4f(index.convert(), x, y, z, w)
    }

    override fun glVertexAttrib4fv(index: Int, v: FloatArray) {
        platform.OpenGL.glVertexAttrib4fv(index.convert(), cValuesOf(*v))
    }

    override fun glVertexAttribPointer(
        index: Int, size: Int, type: Int, normalized: Boolean, stride: Int, offset: Long
    ) {
        platform.OpenGL.glVertexAttribPointer(
            index.convert(), size, type.convert(), normalized.toGLBool().convert(), stride, offset.toCPointer<COpaque>()
        )
    }
}