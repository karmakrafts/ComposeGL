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

import java.nio.ByteBuffer
import java.nio.FloatBuffer
import java.nio.IntBuffer
import java.nio.ShortBuffer
import android.opengl.GLES11 as AndroidGLES11

internal object PlatformGLES11 : GLES11 {
    override val GL_DEPTH_BUFFER_BIT: Int get() = AndroidGLES11.GL_DEPTH_BUFFER_BIT
    override val GL_STENCIL_BUFFER_BIT: Int get() = AndroidGLES11.GL_STENCIL_BUFFER_BIT
    override val GL_COLOR_BUFFER_BIT: Int get() = AndroidGLES11.GL_COLOR_BUFFER_BIT
    override val GL_FALSE: Int = AndroidGLES11.GL_FALSE
    override val GL_TRUE: Int = AndroidGLES11.GL_TRUE
    override val GL_POINTS: Int get() = AndroidGLES11.GL_POINTS
    override val GL_LINES: Int get() = AndroidGLES11.GL_LINES
    override val GL_LINE_LOOP: Int get() = AndroidGLES11.GL_LINE_LOOP
    override val GL_LINE_STRIP: Int get() = AndroidGLES11.GL_LINE_STRIP
    override val GL_TRIANGLES: Int get() = AndroidGLES11.GL_TRIANGLES
    override val GL_TRIANGLE_STRIP: Int get() = AndroidGLES11.GL_TRIANGLE_STRIP
    override val GL_TRIANGLE_FAN: Int get() = AndroidGLES11.GL_TRIANGLE_FAN
    override val GL_NEVER: Int get() = AndroidGLES11.GL_NEVER
    override val GL_LESS: Int get() = AndroidGLES11.GL_LESS
    override val GL_EQUAL: Int get() = AndroidGLES11.GL_EQUAL
    override val GL_LEQUAL: Int get() = AndroidGLES11.GL_LEQUAL
    override val GL_GREATER: Int get() = AndroidGLES11.GL_GREATER
    override val GL_NOTEQUAL: Int get() = AndroidGLES11.GL_NOTEQUAL
    override val GL_GEQUAL: Int get() = AndroidGLES11.GL_GEQUAL
    override val GL_ALWAYS: Int get() = AndroidGLES11.GL_ALWAYS
    override val GL_ZERO: Int get() = AndroidGLES11.GL_ZERO
    override val GL_ONE: Int get() = AndroidGLES11.GL_ONE
    override val GL_SRC_COLOR: Int get() = AndroidGLES11.GL_SRC_COLOR
    override val GL_ONE_MINUS_SRC_COLOR: Int get() = AndroidGLES11.GL_ONE_MINUS_SRC_COLOR
    override val GL_SRC_ALPHA: Int get() = AndroidGLES11.GL_SRC_ALPHA
    override val GL_ONE_MINUS_SRC_ALPHA: Int get() = AndroidGLES11.GL_ONE_MINUS_SRC_ALPHA
    override val GL_DST_ALPHA: Int get() = AndroidGLES11.GL_DST_ALPHA
    override val GL_ONE_MINUS_DST_ALPHA: Int get() = AndroidGLES11.GL_ONE_MINUS_DST_ALPHA
    override val GL_DST_COLOR: Int get() = AndroidGLES11.GL_DST_COLOR
    override val GL_ONE_MINUS_DST_COLOR: Int get() = AndroidGLES11.GL_ONE_MINUS_DST_COLOR
    override val GL_SRC_ALPHA_SATURATE: Int get() = AndroidGLES11.GL_SRC_ALPHA_SATURATE
    override val GL_FRONT: Int get() = AndroidGLES11.GL_FRONT
    override val GL_BACK: Int get() = AndroidGLES11.GL_BACK
    override val GL_FRONT_AND_BACK: Int get() = AndroidGLES11.GL_FRONT_AND_BACK
    override val GL_TEXTURE_2D: Int get() = AndroidGLES11.GL_TEXTURE_2D
    override val GL_CULL_FACE: Int get() = AndroidGLES11.GL_CULL_FACE
    override val GL_BLEND: Int get() = AndroidGLES11.GL_BLEND
    override val GL_DITHER: Int get() = AndroidGLES11.GL_DITHER
    override val GL_STENCIL_TEST: Int get() = AndroidGLES11.GL_STENCIL_TEST
    override val GL_DEPTH_TEST: Int get() = AndroidGLES11.GL_DEPTH_TEST
    override val GL_SCISSOR_TEST: Int get() = AndroidGLES11.GL_SCISSOR_TEST
    override val GL_SAMPLE_ALPHA_TO_COVERAGE: Int get() = AndroidGLES11.GL_SAMPLE_ALPHA_TO_COVERAGE
    override val GL_SAMPLE_COVERAGE: Int get() = AndroidGLES11.GL_SAMPLE_COVERAGE
    override val GL_NO_ERROR: Int get() = AndroidGLES11.GL_NO_ERROR
    override val GL_INVALID_ENUM: Int get() = AndroidGLES11.GL_INVALID_ENUM
    override val GL_INVALID_VALUE: Int get() = AndroidGLES11.GL_INVALID_VALUE
    override val GL_INVALID_OPERATION: Int get() = AndroidGLES11.GL_INVALID_OPERATION
    override val GL_OUT_OF_MEMORY: Int get() = AndroidGLES11.GL_OUT_OF_MEMORY
    override val GL_CW: Int get() = AndroidGLES11.GL_CW
    override val GL_CCW: Int get() = AndroidGLES11.GL_CCW
    override val GL_LINE_WIDTH: Int get() = AndroidGLES11.GL_LINE_WIDTH
    override val GL_ALIASED_POINT_SIZE_RANGE: Int get() = AndroidGLES11.GL_ALIASED_POINT_SIZE_RANGE
    override val GL_ALIASED_LINE_WIDTH_RANGE: Int get() = AndroidGLES11.GL_ALIASED_LINE_WIDTH_RANGE
    override val GL_CULL_FACE_MODE: Int get() = AndroidGLES11.GL_CULL_FACE_MODE
    override val GL_FRONT_FACE: Int get() = AndroidGLES11.GL_FRONT_FACE
    override val GL_DEPTH_RANGE: Int get() = AndroidGLES11.GL_DEPTH_RANGE
    override val GL_DEPTH_WRITEMASK: Int get() = AndroidGLES11.GL_DEPTH_WRITEMASK
    override val GL_DEPTH_CLEAR_VALUE: Int get() = AndroidGLES11.GL_DEPTH_CLEAR_VALUE
    override val GL_DEPTH_FUNC: Int get() = AndroidGLES11.GL_DEPTH_FUNC
    override val GL_STENCIL_CLEAR_VALUE: Int get() = AndroidGLES11.GL_STENCIL_CLEAR_VALUE
    override val GL_STENCIL_FUNC: Int get() = AndroidGLES11.GL_STENCIL_FUNC
    override val GL_STENCIL_VALUE_MASK: Int get() = AndroidGLES11.GL_STENCIL_VALUE_MASK
    override val GL_STENCIL_FAIL: Int get() = AndroidGLES11.GL_STENCIL_FAIL
    override val GL_STENCIL_PASS_DEPTH_FAIL: Int get() = AndroidGLES11.GL_STENCIL_PASS_DEPTH_FAIL
    override val GL_STENCIL_PASS_DEPTH_PASS: Int get() = AndroidGLES11.GL_STENCIL_PASS_DEPTH_PASS
    override val GL_STENCIL_REF: Int get() = AndroidGLES11.GL_STENCIL_REF
    override val GL_STENCIL_WRITEMASK: Int get() = AndroidGLES11.GL_STENCIL_WRITEMASK
    override val GL_VIEWPORT: Int get() = AndroidGLES11.GL_VIEWPORT
    override val GL_SCISSOR_BOX: Int get() = AndroidGLES11.GL_SCISSOR_BOX
    override val GL_COLOR_CLEAR_VALUE: Int get() = AndroidGLES11.GL_COLOR_CLEAR_VALUE
    override val GL_COLOR_WRITEMASK: Int get() = AndroidGLES11.GL_COLOR_WRITEMASK
    override val GL_MAX_TEXTURE_SIZE: Int get() = AndroidGLES11.GL_MAX_TEXTURE_SIZE
    override val GL_MAX_VIEWPORT_DIMS: Int get() = AndroidGLES11.GL_MAX_VIEWPORT_DIMS
    override val GL_SUBPIXEL_BITS: Int get() = AndroidGLES11.GL_SUBPIXEL_BITS
    override val GL_RED_BITS: Int get() = AndroidGLES11.GL_RED_BITS
    override val GL_GREEN_BITS: Int get() = AndroidGLES11.GL_GREEN_BITS
    override val GL_BLUE_BITS: Int get() = AndroidGLES11.GL_BLUE_BITS
    override val GL_ALPHA_BITS: Int get() = AndroidGLES11.GL_ALPHA_BITS
    override val GL_DEPTH_BITS: Int get() = AndroidGLES11.GL_DEPTH_BITS
    override val GL_STENCIL_BITS: Int get() = AndroidGLES11.GL_STENCIL_BITS
    override val GL_POLYGON_OFFSET_UNITS: Int get() = AndroidGLES11.GL_POLYGON_OFFSET_UNITS
    override val GL_POLYGON_OFFSET_FILL: Int get() = AndroidGLES11.GL_POLYGON_OFFSET_FILL
    override val GL_POLYGON_OFFSET_FACTOR: Int get() = AndroidGLES11.GL_POLYGON_OFFSET_FACTOR
    override val GL_TEXTURE_BINDING_2D: Int get() = AndroidGLES11.GL_TEXTURE_BINDING_2D
    override val GL_SAMPLE_BUFFERS: Int get() = AndroidGLES11.GL_SAMPLE_BUFFERS
    override val GL_SAMPLES: Int get() = AndroidGLES11.GL_SAMPLES
    override val GL_SAMPLE_COVERAGE_VALUE: Int get() = AndroidGLES11.GL_SAMPLE_COVERAGE_VALUE
    override val GL_SAMPLE_COVERAGE_INVERT: Int get() = AndroidGLES11.GL_SAMPLE_COVERAGE_INVERT
    override val GL_COMPRESSED_TEXTURE_FORMATS: Int get() = AndroidGLES11.GL_COMPRESSED_TEXTURE_FORMATS
    override val GL_DONT_CARE: Int get() = AndroidGLES11.GL_DONT_CARE
    override val GL_FASTEST: Int get() = AndroidGLES11.GL_FASTEST
    override val GL_NICEST: Int get() = AndroidGLES11.GL_NICEST
    override val GL_GENERATE_MIPMAP_HINT: Int get() = AndroidGLES11.GL_GENERATE_MIPMAP_HINT
    override val GL_BYTE: Int get() = AndroidGLES11.GL_BYTE
    override val GL_UNSIGNED_BYTE: Int get() = AndroidGLES11.GL_UNSIGNED_BYTE
    override val GL_SHORT: Int get() = AndroidGLES11.GL_SHORT
    override val GL_UNSIGNED_SHORT: Int get() = AndroidGLES11.GL_UNSIGNED_SHORT
    override val GL_FLOAT: Int get() = AndroidGLES11.GL_FLOAT
    override val GL_INVERT: Int get() = AndroidGLES11.GL_INVERT
    override val GL_TEXTURE: Int get() = AndroidGLES11.GL_TEXTURE
    override val GL_ALPHA: Int get() = AndroidGLES11.GL_ALPHA
    override val GL_RGB: Int get() = AndroidGLES11.GL_RGB
    override val GL_RGBA: Int get() = AndroidGLES11.GL_RGBA
    override val GL_LUMINANCE: Int get() = AndroidGLES11.GL_LUMINANCE
    override val GL_LUMINANCE_ALPHA: Int get() = AndroidGLES11.GL_LUMINANCE_ALPHA
    override val GL_UNPACK_ALIGNMENT: Int get() = AndroidGLES11.GL_UNPACK_ALIGNMENT
    override val GL_PACK_ALIGNMENT: Int get() = AndroidGLES11.GL_PACK_ALIGNMENT
    override val GL_UNSIGNED_SHORT_4_4_4_4: Int get() = AndroidGLES11.GL_UNSIGNED_SHORT_4_4_4_4
    override val GL_UNSIGNED_SHORT_5_5_5_1: Int get() = AndroidGLES11.GL_UNSIGNED_SHORT_5_5_5_1
    override val GL_UNSIGNED_SHORT_5_6_5: Int get() = AndroidGLES11.GL_UNSIGNED_SHORT_5_6_5
    override val GL_KEEP: Int get() = AndroidGLES11.GL_KEEP
    override val GL_REPLACE: Int get() = AndroidGLES11.GL_REPLACE
    override val GL_INCR: Int get() = AndroidGLES11.GL_INCR
    override val GL_DECR: Int get() = AndroidGLES11.GL_DECR
    override val GL_VENDOR: Int get() = AndroidGLES11.GL_VENDOR
    override val GL_RENDERER: Int get() = AndroidGLES11.GL_RENDERER
    override val GL_VERSION: Int get() = AndroidGLES11.GL_VERSION
    override val GL_NEAREST: Int get() = AndroidGLES11.GL_NEAREST
    override val GL_LINEAR: Int get() = AndroidGLES11.GL_LINEAR
    override val GL_NEAREST_MIPMAP_NEAREST: Int get() = AndroidGLES11.GL_NEAREST_MIPMAP_NEAREST
    override val GL_LINEAR_MIPMAP_NEAREST: Int get() = AndroidGLES11.GL_LINEAR_MIPMAP_NEAREST
    override val GL_NEAREST_MIPMAP_LINEAR: Int get() = AndroidGLES11.GL_NEAREST_MIPMAP_LINEAR
    override val GL_LINEAR_MIPMAP_LINEAR: Int get() = AndroidGLES11.GL_LINEAR_MIPMAP_LINEAR
    override val GL_TEXTURE_MAG_FILTER: Int get() = AndroidGLES11.GL_TEXTURE_MAG_FILTER
    override val GL_TEXTURE_MIN_FILTER: Int get() = AndroidGLES11.GL_TEXTURE_MIN_FILTER
    override val GL_TEXTURE_WRAP_S: Int get() = AndroidGLES11.GL_TEXTURE_WRAP_S
    override val GL_TEXTURE_WRAP_T: Int get() = AndroidGLES11.GL_TEXTURE_WRAP_T
    override val GL_TEXTURE0: Int get() = AndroidGLES11.GL_TEXTURE0
    override val GL_TEXTURE1: Int get() = AndroidGLES11.GL_TEXTURE1
    override val GL_TEXTURE2: Int get() = AndroidGLES11.GL_TEXTURE2
    override val GL_TEXTURE3: Int get() = AndroidGLES11.GL_TEXTURE3
    override val GL_TEXTURE4: Int get() = AndroidGLES11.GL_TEXTURE4
    override val GL_TEXTURE5: Int get() = AndroidGLES11.GL_TEXTURE5
    override val GL_TEXTURE6: Int get() = AndroidGLES11.GL_TEXTURE6
    override val GL_TEXTURE7: Int get() = AndroidGLES11.GL_TEXTURE7
    override val GL_TEXTURE8: Int get() = AndroidGLES11.GL_TEXTURE8
    override val GL_TEXTURE9: Int get() = AndroidGLES11.GL_TEXTURE9
    override val GL_TEXTURE10: Int get() = AndroidGLES11.GL_TEXTURE10
    override val GL_TEXTURE11: Int get() = AndroidGLES11.GL_TEXTURE11
    override val GL_TEXTURE12: Int get() = AndroidGLES11.GL_TEXTURE12
    override val GL_TEXTURE13: Int get() = AndroidGLES11.GL_TEXTURE13
    override val GL_TEXTURE14: Int get() = AndroidGLES11.GL_TEXTURE14
    override val GL_TEXTURE15: Int get() = AndroidGLES11.GL_TEXTURE15
    override val GL_TEXTURE16: Int get() = AndroidGLES11.GL_TEXTURE16
    override val GL_TEXTURE17: Int get() = AndroidGLES11.GL_TEXTURE17
    override val GL_TEXTURE18: Int get() = AndroidGLES11.GL_TEXTURE18
    override val GL_TEXTURE19: Int get() = AndroidGLES11.GL_TEXTURE19
    override val GL_TEXTURE20: Int get() = AndroidGLES11.GL_TEXTURE20
    override val GL_TEXTURE21: Int get() = AndroidGLES11.GL_TEXTURE21
    override val GL_TEXTURE22: Int get() = AndroidGLES11.GL_TEXTURE22
    override val GL_TEXTURE23: Int get() = AndroidGLES11.GL_TEXTURE23
    override val GL_TEXTURE24: Int get() = AndroidGLES11.GL_TEXTURE24
    override val GL_TEXTURE25: Int get() = AndroidGLES11.GL_TEXTURE25
    override val GL_TEXTURE26: Int get() = AndroidGLES11.GL_TEXTURE26
    override val GL_TEXTURE27: Int get() = AndroidGLES11.GL_TEXTURE27
    override val GL_TEXTURE28: Int get() = AndroidGLES11.GL_TEXTURE28
    override val GL_TEXTURE29: Int get() = AndroidGLES11.GL_TEXTURE29
    override val GL_TEXTURE30: Int get() = AndroidGLES11.GL_TEXTURE30
    override val GL_TEXTURE31: Int get() = AndroidGLES11.GL_TEXTURE31
    override val GL_ACTIVE_TEXTURE: Int get() = AndroidGLES11.GL_ACTIVE_TEXTURE
    override val GL_REPEAT: Int get() = AndroidGLES11.GL_REPEAT
    override val GL_CLAMP_TO_EDGE: Int get() = AndroidGLES11.GL_CLAMP_TO_EDGE
    override val GL_ARRAY_BUFFER: Int get() = AndroidGLES11.GL_ARRAY_BUFFER
    override val GL_ELEMENT_ARRAY_BUFFER: Int get() = AndroidGLES11.GL_ELEMENT_ARRAY_BUFFER
    override val GL_ARRAY_BUFFER_BINDING: Int get() = AndroidGLES11.GL_ARRAY_BUFFER_BINDING
    override val GL_ELEMENT_ARRAY_BUFFER_BINDING: Int get() = AndroidGLES11.GL_ELEMENT_ARRAY_BUFFER_BINDING
    override val GL_STATIC_DRAW: Int get() = AndroidGLES11.GL_STATIC_DRAW
    override val GL_DYNAMIC_DRAW: Int get() = AndroidGLES11.GL_DYNAMIC_DRAW
    override val GL_BUFFER_SIZE: Int get() = AndroidGLES11.GL_BUFFER_SIZE
    override val GL_BUFFER_USAGE: Int get() = AndroidGLES11.GL_BUFFER_USAGE

    override fun glClearColor(red: Float, green: Float, blue: Float, alpha: Float) {
        AndroidGLES11.glClearColor(red, green, blue, alpha)
    }

    override fun glClearDepthf(d: Float) {
        AndroidGLES11.glClearDepthf(d)
    }

    override fun glDepthRangef(n: Float, f: Float) {
        AndroidGLES11.glDepthRangef(n, f)
    }

    override fun glLineWidth(width: Float) {
        AndroidGLES11.glLineWidth(width)
    }

    override fun glPolygonOffset(factor: Float, units: Float) {
        AndroidGLES11.glPolygonOffset(factor, units)
    }

    override fun glTexParameterf(target: Int, pname: Int, param: Float) {
        AndroidGLES11.glTexParameterf(target, pname, param)
    }

    override fun glActiveTexture(texture: Int) {
        AndroidGLES11.glActiveTexture(texture)
    }

    override fun glBindBuffer(target: Int, buffer: GLESBuffer) {
        AndroidGLES11.glBindBuffer(target, buffer)
    }

    override fun glBindTexture(target: Int, texture: GLESTexture) {
        AndroidGLES11.glBindTexture(target, texture)
    }

    override fun glBlendFunc(sfactor: Int, dfactor: Int) {
        AndroidGLES11.glBlendFunc(sfactor, dfactor)
    }

    override fun glBufferData(target: Int, data: ShortArray, usage: Int) {
        AndroidGLES11.glBufferData(target, data.size, ShortBuffer.wrap(data), usage)
    }

    override fun glBufferData(target: Int, data: IntArray, usage: Int) {
        AndroidGLES11.glBufferData(target, data.size, IntBuffer.wrap(data), usage)
    }

    override fun glBufferData(target: Int, data: FloatArray, usage: Int) {
        AndroidGLES11.glBufferData(target, data.size, FloatBuffer.wrap(data), usage)
    }

    override fun glBufferSubData(target: Int, offset: Long, data: ShortArray) {
        AndroidGLES11.glBufferSubData(target, offset.toInt(), data.size, ShortBuffer.wrap(data))
    }

    override fun glBufferSubData(target: Int, offset: Long, data: IntArray) {
        AndroidGLES11.glBufferSubData(target, offset.toInt(), data.size, IntBuffer.wrap(data))
    }

    override fun glBufferSubData(target: Int, offset: Long, data: FloatArray) {
        AndroidGLES11.glBufferSubData(target, offset.toInt(), data.size, FloatBuffer.wrap(data))
    }

    override fun glClear(mask: Int) {
        AndroidGLES11.glClear(mask)
    }

    override fun glClearStencil(s: Int) {
        AndroidGLES11.glClearStencil(s)
    }

    override fun glColorMask(red: Boolean, green: Boolean, blue: Boolean, alpha: Boolean) {
        AndroidGLES11.glColorMask(red, green, blue, alpha)
    }

    override fun glCompressedTexImage2D(
        target: Int, level: Int, internalformat: Int, width: Int, height: Int, border: Int, data: ByteArray
    ) {
        AndroidGLES11.glCompressedTexImage2D(
            target, level, internalformat, width, height, border, data.size, ByteBuffer.wrap(data)
        )
    }

    override fun glCompressedTexSubImage2D(
        target: Int, level: Int, xoffset: Int, yoffset: Int, width: Int, height: Int, format: Int, data: ByteArray
    ) {
        AndroidGLES11.glCompressedTexSubImage2D(
            target, level, xoffset, yoffset, width, height, format, data.size, ByteBuffer.wrap(data)
        )
    }

    override fun glCopyTexImage2D(
        target: Int, level: Int, internalformat: Int, x: Int, y: Int, width: Int, height: Int, border: Int
    ) {
        AndroidGLES11.glCopyTexImage2D(target, level, internalformat, x, y, width, height, border)
    }

    override fun glCopyTexSubImage2D(
        target: Int, level: Int, xoffset: Int, yoffset: Int, x: Int, y: Int, width: Int, height: Int
    ) {
        AndroidGLES11.glCopyTexSubImage2D(target, level, xoffset, yoffset, x, y, width, height)
    }

    override fun glCullFace(mode: Int) {
        AndroidGLES11.glCullFace(mode)
    }

    override fun glGenBuffer(): GLESBuffer {
        val buffers = IntArray(1)
        AndroidGLES11.glGenBuffers(1, buffers, 0)
        return buffers.first()
    }

    override fun glDeleteBuffer(buffer: GLESBuffer) {
        AndroidGLES11.glDeleteBuffers(1, intArrayOf(buffer), 0)
    }

    override fun glGenTexture(): GLESTexture {
        val buffers = IntArray(1)
        AndroidGLES11.glGenTextures(1, buffers, 0)
        return buffers.first()
    }

    override fun glDeleteTexture(texture: GLESTexture) {
        AndroidGLES11.glDeleteTextures(1, intArrayOf(texture), 0)
    }

    override fun glDepthFunc(func: Int) {
        AndroidGLES11.glDepthFunc(func)
    }

    override fun glDepthMask(flag: Boolean) {
        AndroidGLES11.glDepthMask(flag)
    }

    override fun glDisable(cap: Int) {
        AndroidGLES11.glDisable(cap)
    }

    override fun glDrawArrays(mode: Int, first: Int, count: Int) {
        AndroidGLES11.glDrawArrays(mode, first, count)
    }

    override fun glDrawElements(mode: Int, count: Int, type: Int, offset: Long) {
        AndroidGLES11.glDrawElements(mode, count, type, offset.toInt())
    }

    override fun glEnable(cap: Int) {
        AndroidGLES11.glEnable(cap)
    }

    override fun glFinish() {
        AndroidGLES11.glFinish()
    }

    override fun glFlush() {
        AndroidGLES11.glFlush()
    }

    override fun glFrontFace(mode: Int) {
        AndroidGLES11.glFrontFace(mode)
    }

    override fun glGetError(): Int {
        return AndroidGLES11.glGetError()
    }

    override fun glHint(target: Int, mode: Int) {
        AndroidGLES11.glHint(target, mode)
    }

    override fun glIsBuffer(buffer: GLESBuffer): Boolean {
        return AndroidGLES11.glIsBuffer(buffer)
    }

    override fun glIsEnabled(cap: Int): Boolean {
        return AndroidGLES11.glIsEnabled(cap)
    }

    override fun glIsTexture(texture: Int): Boolean {
        return AndroidGLES11.glIsTexture(texture)
    }

    override fun glPixelStorei(pname: Int, param: Int) {
        AndroidGLES11.glPixelStorei(pname, param)
    }

    override fun glReadPixels(
        x: Int, y: Int, width: Int, height: Int, format: Int, type: Int, pixels: ByteArray
    ) {
        AndroidGLES11.glReadPixels(x, y, width, height, format, type, ByteBuffer.wrap(pixels))
    }

    override fun glReadPixels(
        x: Int, y: Int, width: Int, height: Int, format: Int, type: Int, pixels: IntArray
    ) {
        AndroidGLES11.glReadPixels(x, y, width, height, format, type, IntBuffer.wrap(pixels))
    }

    override fun glSampleCoverage(value: Float, invert: Boolean) {
        AndroidGLES11.glSampleCoverage(value, invert)
    }

    override fun glScissor(x: Int, y: Int, width: Int, height: Int) {
        AndroidGLES11.glScissor(x, y, width, height)
    }

    override fun glStencilFunc(func: Int, ref: Int, mask: Int) {
        AndroidGLES11.glStencilFunc(func, ref, mask)
    }

    override fun glStencilMask(mask: Int) {
        AndroidGLES11.glStencilMask(mask)
    }

    override fun glStencilOp(fail: Int, zfail: Int, zpass: Int) {
        AndroidGLES11.glStencilOp(fail, zfail, zpass)
    }

    override fun glTexImage2D(
        target: Int,
        level: Int,
        internalformat: Int,
        width: Int,
        height: Int,
        border: Int,
        format: Int,
        type: Int,
        pixels: ByteArray
    ) {
        AndroidGLES11.glTexImage2D(
            target, level, internalformat, width, height, border, format, type, ByteBuffer.wrap(pixels)
        )
    }

    override fun glTexImage2D(
        target: Int,
        level: Int,
        internalformat: Int,
        width: Int,
        height: Int,
        border: Int,
        format: Int,
        type: Int,
        pixels: IntArray
    ) {
        AndroidGLES11.glTexImage2D(
            target, level, internalformat, width, height, border, format, type, IntBuffer.wrap(pixels)
        )
    }

    override fun glTexParameteri(target: Int, pname: Int, param: Int) {
        AndroidGLES11.glTexParameteri(target, pname, param)
    }

    override fun glTexSubImage2D(
        target: Int,
        level: Int,
        xoffset: Int,
        yoffset: Int,
        width: Int,
        height: Int,
        format: Int,
        type: Int,
        pixels: ByteArray
    ) {
        AndroidGLES11.glTexSubImage2D(
            target, level, xoffset, yoffset, width, height, format, type, ByteBuffer.wrap(pixels)
        )
    }

    override fun glTexSubImage2D(
        target: Int,
        level: Int,
        xoffset: Int,
        yoffset: Int,
        width: Int,
        height: Int,
        format: Int,
        type: Int,
        pixels: IntArray
    ) {
        AndroidGLES11.glTexSubImage2D(
            target, level, xoffset, yoffset, width, height, format, type, IntBuffer.wrap(pixels)
        )
    }

    override fun glViewport(x: Int, y: Int, width: Int, height: Int) {
        AndroidGLES11.glViewport(x, y, width, height)
    }
}