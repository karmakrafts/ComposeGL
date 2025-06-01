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

import dev.karmakrafts.composegl.util.HandleMap
import org.khronos.webgl.WebGLFramebuffer
import org.khronos.webgl.WebGLProgram
import org.khronos.webgl.WebGLRenderbuffer
import org.khronos.webgl.WebGLRenderingContext
import org.khronos.webgl.WebGLShader
import org.khronos.webgl.WebGLUniformLocation
import kotlin.math.min

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
    override val GL_DEPTH_COMPONENT16: Int get() = WebGLRenderingContext.DEPTH_COMPONENT16
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

    private val shaderPrograms: HandleMap<WebGLProgram> = HandleMap()
    private val shaders: HandleMap<WebGLShader> = HandleMap()
    private val frameBuffers: HandleMap<WebGLFramebuffer> = HandleMap()
    private val renderBuffers: HandleMap<WebGLRenderbuffer> = HandleMap()

    private val uniformLocations: HandleMap<WebGLUniformLocation> = HandleMap()
    private val uniformLocationCache: HashMap<Pair<WebGLProgram, String>, WebGLUniformLocation> = HashMap()

    override fun glAttachShader(program: Int, shader: Int) {
        context.attachShader(shaderPrograms[program], shaders[shader])
    }

    override fun glBindAttribLocation(program: Int, index: Int, name: String) {
        context.bindAttribLocation(shaderPrograms[program], index, name)
    }

    override fun glBindFramebuffer(target: Int, framebuffer: Int) {
        context.bindFramebuffer(target, frameBuffers[framebuffer])
    }

    override fun glBindRenderbuffer(target: Int, renderbuffer: Int) {
        context.bindRenderbuffer(target, renderBuffers[renderbuffer])
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

    override fun glCompileShader(shader: Int) {
        context.compileShader(shaders[shader])
    }

    override fun glCreateProgram(): Int {
        return shaderPrograms.putNext(context.createProgram()!!)
    }

    override fun glCreateShader(type: Int): Int {
        return shaders.putNext(context.createShader(type)!!)
    }

    override fun glDeleteFramebuffers(framebuffers: IntArray) {
        for (framebuffer in framebuffers) {
            context.deleteFramebuffer(this.frameBuffers[framebuffer])
            this.frameBuffers -= framebuffer
        }
    }

    override fun glDeleteProgram(program: Int) {
        context.deleteProgram(shaderPrograms[program])
        // Remove all location cache entries for this shader program and all uniform location mappings
        // @formatter:off
        uniformLocationCache -= uniformLocationCache
            .filterKeys { (prog, _) -> prog == shaderPrograms[program] }
            .onEach { (_, loc) -> uniformLocations.findIdByValue(loc)?.let(uniformLocations::remove) }
            .keys
        // @formatter:on
        shaderPrograms -= program
    }

    override fun glDeleteRenderbuffers(renderbuffers: IntArray) {
        for (renderbuffer in renderbuffers) {
            context.deleteRenderbuffer(this.renderBuffers[renderbuffer])
            this.renderBuffers -= renderbuffer
        }
    }

    override fun glDeleteShader(shader: Int) {
        context.deleteShader(shaders[shader])
        shaders -= shader
    }

    override fun glDetachShader(program: Int, shader: Int) {
        context.detachShader(shaderPrograms[program], shaders[shader])
    }

    override fun glDisableVertexAttribArray(index: Int) {
        context.disableVertexAttribArray(index)
    }

    override fun glEnableVertexAttribArray(index: Int) {
        context.enableVertexAttribArray(index)
    }

    override fun glFramebufferRenderbuffer(
        target: Int, attachment: Int, renderbuffertarget: Int, renderbuffer: Int
    ) {
        context.framebufferRenderbuffer(target, attachment, renderbuffertarget, renderBuffers[renderbuffer])
    }

    override fun glFramebufferTexture2D(
        target: Int, attachment: Int, textarget: Int, texture: Int, level: Int
    ) {
        context.framebufferTexture2D(target, attachment, textarget, textures[texture], level)
    }

    override fun glGenerateMipmap(target: Int) {
        context.generateMipmap(target)
    }

    override fun glGenFramebuffers(framebuffers: IntArray) {
        for (index in framebuffers.indices) {
            framebuffers[index] = this.frameBuffers.putNext(context.createFramebuffer()!!)
        }
    }

    override fun glGenRenderbuffers(renderbuffers: IntArray) {
        for (index in renderbuffers.indices) {
            renderbuffers[index] = this.renderBuffers.putNext(context.createRenderbuffer()!!)
        }
    }

    override fun glGetActiveAttrib(
        program: Int, index: Int, info: GLESActiveInfo
    ) {
        val wglInfo = context.getActiveAttrib(shaderPrograms[program], index) ?: return
        info.type = wglInfo.type
        info.size = wglInfo.size
        info.name = wglInfo.name
    }

    override fun glGetActiveUniform(
        program: Int, index: Int, info: GLESActiveInfo
    ) {
        val wglInfo = context.getActiveUniform(shaderPrograms[program], index) ?: return
        info.type = wglInfo.type
        info.size = wglInfo.size
        info.name = wglInfo.name
    }

    override fun glGetAttachedShaders(
        program: Int, maxCount: Int, shaders: IntArray
    ): Int {
        val wglShaders = context.getAttachedShaders(shaderPrograms[program]) ?: return 0
        val count = min(wglShaders.size, maxCount)
        for (index in 0..<count) {
            shaders[index] = this.shaders.entries.first { (_, wgls) -> wgls == wglShaders[index] }.key
        }
        return count
    }

    override fun glGetAttribLocation(program: Int, name: String): Int {
        return context.getAttribLocation(shaderPrograms[program], name)
    }

    override fun glGetProgramInfoLog(program: Int): String? {
        return context.getProgramInfoLog(shaderPrograms[program])
    }

    override fun glGetShaderInfoLog(shader: Int): String? {
        return context.getShaderInfoLog(shaders[shader])
    }

    override fun glGetShaderPrecisionFormat(
        shadertype: Int, precisiontype: Int, format: GLESShaderPrecisionFormat
    ) {
        val wglFormat = context.getShaderPrecisionFormat(shadertype, precisiontype) ?: return
        format.precision = wglFormat.precision
        format.rangeMin = wglFormat.rangeMin
        format.rangeMax = wglFormat.rangeMax
    }

    override fun glGetShaderSource(shader: Int): String? {
        return context.getShaderSource(shaders[shader])
    }

    override fun glGetUniformLocation(program: Int, name: String): Int {
        val wglProgram = shaderPrograms[program]!!
        val cacheKey = Pair(wglProgram, name)
        var cachedLocation = uniformLocationCache[cacheKey]
        if (cachedLocation != null) {
            return uniformLocations.findIdByValue(cachedLocation)!!
        }
        cachedLocation = context.getUniformLocation(wglProgram, name)!!
        uniformLocationCache[cacheKey] = cachedLocation
        return uniformLocations.putNext(cachedLocation)
    }

    override fun glIsFramebuffer(framebuffer: Int): Boolean {
        return context.isFramebuffer(frameBuffers[framebuffer])
    }

    override fun glIsProgram(program: Int): Boolean {
        return context.isProgram(shaderPrograms[program])
    }

    override fun glIsRenderbuffer(renderbuffer: Int): Boolean {
        return context.isRenderbuffer(renderBuffers[renderbuffer])
    }

    override fun glIsShader(shader: Int): Boolean {
        return context.isShader(shaders[shader])
    }

    override fun glLinkProgram(program: Int) {
        context.linkProgram(shaderPrograms[program])
    }

    override fun glRenderbufferStorage(
        target: Int, internalformat: Int, width: Int, height: Int
    ) {
        context.renderbufferStorage(target, internalformat, width, height)
    }

    override fun glShaderSource(shader: Int, source: String) {
        context.shaderSource(shaders[shader], source)
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

    override fun glUniform1f(location: Int, v0: Float) {
        context.uniform1f(uniformLocations[location], v0)
    }

    override fun glUniform1fv(location: Int, value: FloatArray) {
        context.uniform1fv(uniformLocations[location], value.toTypedArray())
    }

    override fun glUniform1i(location: Int, v0: Int) {
        context.uniform1i(uniformLocations[location], v0)
    }

    override fun glUniform1iv(location: Int, value: IntArray) {
        context.uniform1iv(uniformLocations[location], value.toTypedArray())
    }

    override fun glUniform2f(location: Int, v0: Float, v1: Float) {
        context.uniform2f(uniformLocations[location], v0, v1)
    }

    override fun glUniform2fv(location: Int, value: FloatArray) {
        context.uniform2fv(uniformLocations[location], value.toTypedArray())
    }

    override fun glUniform2i(location: Int, v0: Int, v1: Int) {
        context.uniform2i(uniformLocations[location], v0, v1)
    }

    override fun glUniform2iv(location: Int, value: IntArray) {
        context.uniform2iv(uniformLocations[location], value.toTypedArray())
    }

    override fun glUniform3f(location: Int, v0: Float, v1: Float, v2: Float) {
        context.uniform3f(uniformLocations[location], v0, v1, v2)
    }

    override fun glUniform3fv(location: Int, value: FloatArray) {
        context.uniform3fv(uniformLocations[location], value.toTypedArray())
    }

    override fun glUniform3i(location: Int, v0: Int, v1: Int, v2: Int) {
        context.uniform3i(uniformLocations[location], v0, v1, v2)
    }

    override fun glUniform3iv(location: Int, value: IntArray) {
        context.uniform3iv(uniformLocations[location], value.toTypedArray())
    }

    override fun glUniform4f(
        location: Int, v0: Float, v1: Float, v2: Float, v3: Float
    ) {
        context.uniform4f(uniformLocations[location], v0, v1, v2, v3)
    }

    override fun glUniform4fv(location: Int, value: FloatArray) {
        context.uniform4fv(uniformLocations[location], value.toTypedArray())
    }

    override fun glUniform4i(location: Int, v0: Int, v1: Int, v2: Int, v3: Int) {
        context.uniform4i(uniformLocations[location], v0, v1, v2, v3)
    }

    override fun glUniform4iv(location: Int, value: IntArray) {
        context.uniform4iv(uniformLocations[location], value.toTypedArray())
    }

    override fun glUniformMatrix2fv(location: Int, transpose: Boolean, value: FloatArray) {
        context.uniformMatrix2fv(uniformLocations[location], transpose, value.toTypedArray())
    }

    override fun glUniformMatrix3fv(location: Int, transpose: Boolean, value: FloatArray) {
        context.uniformMatrix3fv(uniformLocations[location], transpose, value.toTypedArray())
    }

    override fun glUniformMatrix4fv(location: Int, transpose: Boolean, value: FloatArray) {
        context.uniformMatrix4fv(uniformLocations[location], transpose, value.toTypedArray())
    }

    override fun glUseProgram(program: Int) {
        context.useProgram(shaderPrograms[program])
    }

    override fun glValidateProgram(program: Int) {
        context.validateProgram(shaderPrograms[program])
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