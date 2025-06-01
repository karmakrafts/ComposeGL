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
import dev.karmakrafts.composegl.util.copyTo
import dev.karmakrafts.composegl.util.toFloat32Array
import dev.karmakrafts.composegl.util.toInt16Array
import dev.karmakrafts.composegl.util.toInt32Array
import dev.karmakrafts.composegl.util.toInt8Array
import org.khronos.webgl.Int32Array
import org.khronos.webgl.Int8Array
import org.khronos.webgl.WebGLBuffer
import org.khronos.webgl.WebGLRenderingContext
import org.khronos.webgl.WebGLTexture

internal open class PlatformGLES11(protected val context: WebGLRenderingContext) : GLES11 {
    override val GL_DEPTH_BUFFER_BIT: Int get() = WebGLRenderingContext.DEPTH_BUFFER_BIT
    override val GL_STENCIL_BUFFER_BIT: Int get() = WebGLRenderingContext.STENCIL_BUFFER_BIT
    override val GL_COLOR_BUFFER_BIT: Int get() = WebGLRenderingContext.COLOR_BUFFER_BIT
    override val GL_FALSE: Int = 0
    override val GL_TRUE: Int = 1
    override val GL_POINTS: Int get() = WebGLRenderingContext.POINTS
    override val GL_LINES: Int get() = WebGLRenderingContext.LINES
    override val GL_LINE_LOOP: Int get() = WebGLRenderingContext.LINE_LOOP
    override val GL_LINE_STRIP: Int get() = WebGLRenderingContext.LINE_STRIP
    override val GL_TRIANGLES: Int get() = WebGLRenderingContext.TRIANGLES
    override val GL_TRIANGLE_STRIP: Int get() = WebGLRenderingContext.TRIANGLE_STRIP
    override val GL_TRIANGLE_FAN: Int get() = WebGLRenderingContext.TRIANGLE_FAN
    override val GL_NEVER: Int get() = WebGLRenderingContext.NEVER
    override val GL_LESS: Int get() = WebGLRenderingContext.LESS
    override val GL_EQUAL: Int get() = WebGLRenderingContext.EQUAL
    override val GL_LEQUAL: Int get() = WebGLRenderingContext.LEQUAL
    override val GL_GREATER: Int get() = WebGLRenderingContext.GREATER
    override val GL_NOTEQUAL: Int get() = WebGLRenderingContext.NOTEQUAL
    override val GL_GEQUAL: Int get() = WebGLRenderingContext.GEQUAL
    override val GL_ALWAYS: Int get() = WebGLRenderingContext.ALWAYS
    override val GL_ZERO: Int get() = WebGLRenderingContext.ZERO
    override val GL_ONE: Int get() = WebGLRenderingContext.ONE
    override val GL_SRC_COLOR: Int get() = WebGLRenderingContext.SRC_COLOR
    override val GL_ONE_MINUS_SRC_COLOR: Int get() = WebGLRenderingContext.ONE_MINUS_SRC_COLOR
    override val GL_SRC_ALPHA: Int get() = WebGLRenderingContext.SRC_ALPHA
    override val GL_ONE_MINUS_SRC_ALPHA: Int get() = WebGLRenderingContext.ONE_MINUS_SRC_ALPHA
    override val GL_DST_ALPHA: Int get() = WebGLRenderingContext.DST_ALPHA
    override val GL_ONE_MINUS_DST_ALPHA: Int get() = WebGLRenderingContext.ONE_MINUS_DST_ALPHA
    override val GL_DST_COLOR: Int get() = WebGLRenderingContext.DST_COLOR
    override val GL_ONE_MINUS_DST_COLOR: Int get() = WebGLRenderingContext.ONE_MINUS_DST_COLOR
    override val GL_SRC_ALPHA_SATURATE: Int get() = WebGLRenderingContext.SRC_ALPHA_SATURATE
    override val GL_FRONT: Int get() = WebGLRenderingContext.FRONT
    override val GL_BACK: Int get() = WebGLRenderingContext.BACK
    override val GL_FRONT_AND_BACK: Int get() = WebGLRenderingContext.FRONT_AND_BACK
    override val GL_TEXTURE_2D: Int get() = WebGLRenderingContext.TEXTURE_2D
    override val GL_CULL_FACE: Int get() = WebGLRenderingContext.CULL_FACE
    override val GL_BLEND: Int get() = WebGLRenderingContext.BLEND
    override val GL_DITHER: Int get() = WebGLRenderingContext.DITHER
    override val GL_STENCIL_TEST: Int get() = WebGLRenderingContext.STENCIL_TEST
    override val GL_DEPTH_TEST: Int get() = WebGLRenderingContext.DEPTH_TEST
    override val GL_SCISSOR_TEST: Int get() = WebGLRenderingContext.SCISSOR_TEST
    override val GL_SAMPLE_ALPHA_TO_COVERAGE: Int get() = WebGLRenderingContext.SAMPLE_ALPHA_TO_COVERAGE
    override val GL_SAMPLE_COVERAGE: Int get() = WebGLRenderingContext.SAMPLE_COVERAGE
    override val GL_NO_ERROR: Int get() = WebGLRenderingContext.NO_ERROR
    override val GL_INVALID_ENUM: Int get() = WebGLRenderingContext.INVALID_ENUM
    override val GL_INVALID_VALUE: Int get() = WebGLRenderingContext.INVALID_VALUE
    override val GL_INVALID_OPERATION: Int get() = WebGLRenderingContext.INVALID_OPERATION
    override val GL_OUT_OF_MEMORY: Int get() = WebGLRenderingContext.OUT_OF_MEMORY
    override val GL_CW: Int get() = WebGLRenderingContext.CW
    override val GL_CCW: Int get() = WebGLRenderingContext.CCW
    override val GL_LINE_WIDTH: Int get() = WebGLRenderingContext.LINE_WIDTH
    override val GL_ALIASED_POINT_SIZE_RANGE: Int get() = WebGLRenderingContext.ALIASED_POINT_SIZE_RANGE
    override val GL_ALIASED_LINE_WIDTH_RANGE: Int get() = WebGLRenderingContext.ALIASED_LINE_WIDTH_RANGE
    override val GL_CULL_FACE_MODE: Int get() = WebGLRenderingContext.CULL_FACE_MODE
    override val GL_FRONT_FACE: Int get() = WebGLRenderingContext.FRONT_FACE
    override val GL_DEPTH_RANGE: Int get() = WebGLRenderingContext.DEPTH_RANGE
    override val GL_DEPTH_WRITEMASK: Int get() = WebGLRenderingContext.DEPTH_WRITEMASK
    override val GL_DEPTH_CLEAR_VALUE: Int get() = WebGLRenderingContext.DEPTH_CLEAR_VALUE
    override val GL_DEPTH_FUNC: Int get() = WebGLRenderingContext.DEPTH_FUNC
    override val GL_STENCIL_CLEAR_VALUE: Int get() = WebGLRenderingContext.STENCIL_CLEAR_VALUE
    override val GL_STENCIL_FUNC: Int get() = WebGLRenderingContext.STENCIL_FUNC
    override val GL_STENCIL_VALUE_MASK: Int get() = WebGLRenderingContext.STENCIL_VALUE_MASK
    override val GL_STENCIL_FAIL: Int get() = WebGLRenderingContext.STENCIL_FAIL
    override val GL_STENCIL_PASS_DEPTH_FAIL: Int get() = WebGLRenderingContext.STENCIL_PASS_DEPTH_FAIL
    override val GL_STENCIL_PASS_DEPTH_PASS: Int get() = WebGLRenderingContext.STENCIL_PASS_DEPTH_PASS
    override val GL_STENCIL_REF: Int get() = WebGLRenderingContext.STENCIL_REF
    override val GL_STENCIL_WRITEMASK: Int get() = WebGLRenderingContext.STENCIL_WRITEMASK
    override val GL_VIEWPORT: Int get() = WebGLRenderingContext.VIEWPORT
    override val GL_SCISSOR_BOX: Int get() = WebGLRenderingContext.SCISSOR_BOX
    override val GL_COLOR_CLEAR_VALUE: Int get() = WebGLRenderingContext.COLOR_CLEAR_VALUE
    override val GL_COLOR_WRITEMASK: Int get() = WebGLRenderingContext.COLOR_WRITEMASK
    override val GL_MAX_TEXTURE_SIZE: Int get() = WebGLRenderingContext.MAX_TEXTURE_SIZE
    override val GL_MAX_VIEWPORT_DIMS: Int get() = WebGLRenderingContext.MAX_VIEWPORT_DIMS
    override val GL_SUBPIXEL_BITS: Int get() = WebGLRenderingContext.SUBPIXEL_BITS
    override val GL_RED_BITS: Int get() = WebGLRenderingContext.RED_BITS
    override val GL_GREEN_BITS: Int get() = WebGLRenderingContext.GREEN_BITS
    override val GL_BLUE_BITS: Int get() = WebGLRenderingContext.BLUE_BITS
    override val GL_ALPHA_BITS: Int get() = WebGLRenderingContext.ALPHA_BITS
    override val GL_DEPTH_BITS: Int get() = WebGLRenderingContext.DEPTH_BITS
    override val GL_STENCIL_BITS: Int get() = WebGLRenderingContext.STENCIL_BITS
    override val GL_POLYGON_OFFSET_UNITS: Int get() = WebGLRenderingContext.POLYGON_OFFSET_UNITS
    override val GL_POLYGON_OFFSET_FILL: Int get() = WebGLRenderingContext.POLYGON_OFFSET_FILL
    override val GL_POLYGON_OFFSET_FACTOR: Int get() = WebGLRenderingContext.POLYGON_OFFSET_FACTOR
    override val GL_TEXTURE_BINDING_2D: Int get() = WebGLRenderingContext.TEXTURE_BINDING_2D
    override val GL_SAMPLE_BUFFERS: Int get() = WebGLRenderingContext.SAMPLE_BUFFERS
    override val GL_SAMPLES: Int get() = WebGLRenderingContext.SAMPLES
    override val GL_SAMPLE_COVERAGE_VALUE: Int get() = WebGLRenderingContext.SAMPLE_COVERAGE_VALUE
    override val GL_SAMPLE_COVERAGE_INVERT: Int get() = WebGLRenderingContext.SAMPLE_COVERAGE_INVERT
    override val GL_COMPRESSED_TEXTURE_FORMATS: Int get() = WebGLRenderingContext.COMPRESSED_TEXTURE_FORMATS
    override val GL_DONT_CARE: Int get() = WebGLRenderingContext.DONT_CARE
    override val GL_FASTEST: Int get() = WebGLRenderingContext.FASTEST
    override val GL_NICEST: Int get() = WebGLRenderingContext.NICEST
    override val GL_GENERATE_MIPMAP_HINT: Int get() = WebGLRenderingContext.GENERATE_MIPMAP_HINT
    override val GL_BYTE: Int get() = WebGLRenderingContext.BYTE
    override val GL_UNSIGNED_BYTE: Int get() = WebGLRenderingContext.UNSIGNED_BYTE
    override val GL_SHORT: Int get() = WebGLRenderingContext.SHORT
    override val GL_UNSIGNED_SHORT: Int get() = WebGLRenderingContext.UNSIGNED_SHORT
    override val GL_FLOAT: Int get() = WebGLRenderingContext.FLOAT
    override val GL_INVERT: Int get() = WebGLRenderingContext.INVERT
    override val GL_TEXTURE: Int get() = WebGLRenderingContext.TEXTURE
    override val GL_ALPHA: Int get() = WebGLRenderingContext.ALPHA
    override val GL_RGB: Int get() = WebGLRenderingContext.RGB
    override val GL_RGBA: Int get() = WebGLRenderingContext.RGBA
    override val GL_LUMINANCE: Int get() = WebGLRenderingContext.LUMINANCE
    override val GL_LUMINANCE_ALPHA: Int get() = WebGLRenderingContext.LUMINANCE_ALPHA
    override val GL_UNPACK_ALIGNMENT: Int get() = WebGLRenderingContext.UNPACK_ALIGNMENT
    override val GL_PACK_ALIGNMENT: Int get() = WebGLRenderingContext.PACK_ALIGNMENT
    override val GL_UNSIGNED_SHORT_4_4_4_4: Int get() = WebGLRenderingContext.UNSIGNED_SHORT_4_4_4_4
    override val GL_UNSIGNED_SHORT_5_5_5_1: Int get() = WebGLRenderingContext.UNSIGNED_SHORT_5_5_5_1
    override val GL_UNSIGNED_SHORT_5_6_5: Int get() = WebGLRenderingContext.UNSIGNED_SHORT_5_6_5
    override val GL_KEEP: Int get() = WebGLRenderingContext.KEEP
    override val GL_REPLACE: Int get() = WebGLRenderingContext.REPLACE
    override val GL_INCR: Int get() = WebGLRenderingContext.INCR
    override val GL_DECR: Int get() = WebGLRenderingContext.DECR
    override val GL_VENDOR: Int get() = WebGLRenderingContext.VENDOR
    override val GL_RENDERER: Int get() = WebGLRenderingContext.RENDERER
    override val GL_VERSION: Int get() = WebGLRenderingContext.VERSION
    override val GL_NEAREST: Int get() = WebGLRenderingContext.NEAREST
    override val GL_LINEAR: Int get() = WebGLRenderingContext.LINEAR
    override val GL_NEAREST_MIPMAP_NEAREST: Int get() = WebGLRenderingContext.NEAREST_MIPMAP_NEAREST
    override val GL_LINEAR_MIPMAP_NEAREST: Int get() = WebGLRenderingContext.LINEAR_MIPMAP_NEAREST
    override val GL_NEAREST_MIPMAP_LINEAR: Int get() = WebGLRenderingContext.NEAREST_MIPMAP_LINEAR
    override val GL_LINEAR_MIPMAP_LINEAR: Int get() = WebGLRenderingContext.LINEAR_MIPMAP_LINEAR
    override val GL_TEXTURE_MAG_FILTER: Int get() = WebGLRenderingContext.TEXTURE_MAG_FILTER
    override val GL_TEXTURE_MIN_FILTER: Int get() = WebGLRenderingContext.TEXTURE_MIN_FILTER
    override val GL_TEXTURE_WRAP_S: Int get() = WebGLRenderingContext.TEXTURE_WRAP_S
    override val GL_TEXTURE_WRAP_T: Int get() = WebGLRenderingContext.TEXTURE_WRAP_T
    override val GL_TEXTURE0: Int get() = WebGLRenderingContext.TEXTURE0
    override val GL_TEXTURE1: Int get() = WebGLRenderingContext.TEXTURE1
    override val GL_TEXTURE2: Int get() = WebGLRenderingContext.TEXTURE2
    override val GL_TEXTURE3: Int get() = WebGLRenderingContext.TEXTURE3
    override val GL_TEXTURE4: Int get() = WebGLRenderingContext.TEXTURE4
    override val GL_TEXTURE5: Int get() = WebGLRenderingContext.TEXTURE5
    override val GL_TEXTURE6: Int get() = WebGLRenderingContext.TEXTURE6
    override val GL_TEXTURE7: Int get() = WebGLRenderingContext.TEXTURE7
    override val GL_TEXTURE8: Int get() = WebGLRenderingContext.TEXTURE8
    override val GL_TEXTURE9: Int get() = WebGLRenderingContext.TEXTURE9
    override val GL_TEXTURE10: Int get() = WebGLRenderingContext.TEXTURE10
    override val GL_TEXTURE11: Int get() = WebGLRenderingContext.TEXTURE11
    override val GL_TEXTURE12: Int get() = WebGLRenderingContext.TEXTURE12
    override val GL_TEXTURE13: Int get() = WebGLRenderingContext.TEXTURE13
    override val GL_TEXTURE14: Int get() = WebGLRenderingContext.TEXTURE14
    override val GL_TEXTURE15: Int get() = WebGLRenderingContext.TEXTURE15
    override val GL_TEXTURE16: Int get() = WebGLRenderingContext.TEXTURE16
    override val GL_TEXTURE17: Int get() = WebGLRenderingContext.TEXTURE17
    override val GL_TEXTURE18: Int get() = WebGLRenderingContext.TEXTURE18
    override val GL_TEXTURE19: Int get() = WebGLRenderingContext.TEXTURE19
    override val GL_TEXTURE20: Int get() = WebGLRenderingContext.TEXTURE20
    override val GL_TEXTURE21: Int get() = WebGLRenderingContext.TEXTURE21
    override val GL_TEXTURE22: Int get() = WebGLRenderingContext.TEXTURE22
    override val GL_TEXTURE23: Int get() = WebGLRenderingContext.TEXTURE23
    override val GL_TEXTURE24: Int get() = WebGLRenderingContext.TEXTURE24
    override val GL_TEXTURE25: Int get() = WebGLRenderingContext.TEXTURE25
    override val GL_TEXTURE26: Int get() = WebGLRenderingContext.TEXTURE26
    override val GL_TEXTURE27: Int get() = WebGLRenderingContext.TEXTURE27
    override val GL_TEXTURE28: Int get() = WebGLRenderingContext.TEXTURE28
    override val GL_TEXTURE29: Int get() = WebGLRenderingContext.TEXTURE29
    override val GL_TEXTURE30: Int get() = WebGLRenderingContext.TEXTURE30
    override val GL_TEXTURE31: Int get() = WebGLRenderingContext.TEXTURE31
    override val GL_ACTIVE_TEXTURE: Int get() = WebGLRenderingContext.ACTIVE_TEXTURE
    override val GL_REPEAT: Int get() = WebGLRenderingContext.REPEAT
    override val GL_CLAMP_TO_EDGE: Int get() = WebGLRenderingContext.CLAMP_TO_EDGE
    override val GL_ARRAY_BUFFER: Int get() = WebGLRenderingContext.ARRAY_BUFFER
    override val GL_ELEMENT_ARRAY_BUFFER: Int get() = WebGLRenderingContext.ELEMENT_ARRAY_BUFFER
    override val GL_ARRAY_BUFFER_BINDING: Int get() = WebGLRenderingContext.ARRAY_BUFFER_BINDING
    override val GL_ELEMENT_ARRAY_BUFFER_BINDING: Int get() = WebGLRenderingContext.ELEMENT_ARRAY_BUFFER_BINDING
    override val GL_STATIC_DRAW: Int get() = WebGLRenderingContext.STATIC_DRAW
    override val GL_DYNAMIC_DRAW: Int get() = WebGLRenderingContext.DYNAMIC_DRAW
    override val GL_BUFFER_SIZE: Int get() = WebGLRenderingContext.BUFFER_SIZE
    override val GL_BUFFER_USAGE: Int get() = WebGLRenderingContext.BUFFER_USAGE

    protected val textures: HandleMap<WebGLTexture> = HandleMap()
    protected val buffers: HandleMap<WebGLBuffer> = HandleMap()

    override fun glClearColor(red: Float, green: Float, blue: Float, alpha: Float) {
        context.clearColor(red, green, blue, alpha)
    }

    override fun glClearDepthf(d: Float) {
        context.clearDepth(d)
    }

    override fun glDepthRangef(n: Float, f: Float) {
        context.depthRange(n, f)
    }

    override fun glLineWidth(width: Float) {
        context.lineWidth(width)
    }

    override fun glPolygonOffset(factor: Float, units: Float) {
        context.polygonOffset(factor, units)
    }

    override fun glTexParameterf(target: Int, pname: Int, param: Float) {
        context.texParameterf(target, pname, param)
    }

    override fun glActiveTexture(texture: Int) {
        context.activeTexture(texture)
    }

    override fun glBindBuffer(target: Int, buffer: Int) {
        context.bindBuffer(target, buffers[buffer])
    }

    override fun glBindTexture(target: Int, texture: Int) {
        context.bindTexture(target, textures[texture])
    }

    override fun glBlendFunc(sfactor: Int, dfactor: Int) {
        context.blendFunc(sfactor, dfactor)
    }

    override fun glBufferData(target: Int, data: ShortArray, usage: Int) {
        context.bufferData(target, data.toInt16Array(), usage)
    }

    override fun glBufferData(target: Int, data: IntArray, usage: Int) {
        context.bufferData(target, data.toInt32Array(), usage)
    }

    override fun glBufferData(target: Int, data: FloatArray, usage: Int) {
        context.bufferData(target, data.toFloat32Array(), usage)
    }

    override fun glBufferSubData(target: Int, offset: Long, data: ShortArray) {
        context.bufferSubData(target, offset.toInt(), data.toInt16Array())
    }

    override fun glBufferSubData(target: Int, offset: Long, data: IntArray) {
        context.bufferSubData(target, offset.toInt(), data.toInt32Array())
    }

    override fun glBufferSubData(target: Int, offset: Long, data: FloatArray) {
        context.bufferSubData(target, offset.toInt(), data.toFloat32Array())
    }

    override fun glClear(mask: Int) {
        context.clear(mask)
    }

    override fun glClearStencil(s: Int) {
        context.clearStencil(s)
    }

    override fun glColorMask(red: Boolean, green: Boolean, blue: Boolean, alpha: Boolean) {
        context.colorMask(red, green, blue, alpha)
    }

    override fun glCompressedTexImage2D(
        target: Int, level: Int, internalformat: Int, width: Int, height: Int, border: Int, data: ByteArray
    ) {
        context.compressedTexImage2D(
            target, level, internalformat, width, height, border, data.toInt8Array()
        )
    }

    override fun glCompressedTexSubImage2D(
        target: Int, level: Int, xoffset: Int, yoffset: Int, width: Int, height: Int, format: Int, data: ByteArray
    ) {
        context.compressedTexSubImage2D(
            target, level, xoffset, yoffset, width, height, format, data.toInt8Array()
        )
    }

    override fun glCopyTexImage2D(
        target: Int, level: Int, internalformat: Int, x: Int, y: Int, width: Int, height: Int, border: Int
    ) {
        context.copyTexImage2D(
            target, level, internalformat, x, y, width, height, border
        )
    }

    override fun glCopyTexSubImage2D(
        target: Int, level: Int, xoffset: Int, yoffset: Int, x: Int, y: Int, width: Int, height: Int
    ) {
        context.copyTexSubImage2D(
            target, level, xoffset, yoffset, x, y, width, height
        )
    }

    override fun glCullFace(mode: Int) {
        context.cullFace(mode)
    }

    override fun glDeleteBuffers(buffers: IntArray) {
        for (id in buffers) {
            context.deleteBuffer(this.buffers[id])
            this.buffers -= id
        }
    }

    override fun glDeleteTextures(textures: IntArray) {
        for (id in textures) {
            context.deleteTexture(this.textures[id])
            this.textures -= id
        }
    }

    override fun glDepthFunc(func: Int) {
        context.depthFunc(func)
    }

    override fun glDepthMask(flag: Boolean) {
        context.depthMask(flag)
    }

    override fun glDisable(cap: Int) {
        context.disable(cap)
    }

    override fun glDrawArrays(mode: Int, first: Int, count: Int) {
        context.drawArrays(mode, first, count)
    }

    override fun glDrawElements(mode: Int, count: Int, type: Int, offset: Long) {
        context.drawElements(mode, count, type, offset.toInt())
    }

    override fun glEnable(cap: Int) {
        context.enable(cap)
    }

    override fun glFinish() {
        context.finish()
    }

    override fun glFlush() {
        context.flush()
    }

    override fun glFrontFace(mode: Int) {
        context.frontFace(mode)
    }

    override fun glGenBuffers(buffers: IntArray) {
        for (index in buffers.indices) {
            buffers[index] = this.buffers.putNext(context.createBuffer()!!)
        }
    }

    override fun glGenTextures(textures: IntArray) {
        for (index in textures.indices) {
            textures[index] = this.textures.putNext(context.createTexture()!!)
        }
    }

    override fun glGetError(): Int {
        return context.getError()
    }

    override fun glHint(target: Int, mode: Int) {
        context.hint(target, mode)
    }

    override fun glIsBuffer(buffer: Int): Boolean {
        return context.isBuffer(buffers[buffer])
    }

    override fun glIsEnabled(cap: Int): Boolean {
        return context.isEnabled(cap)
    }

    override fun glIsTexture(texture: Int): Boolean {
        return context.isTexture(textures[texture])
    }

    override fun glPixelStorei(pname: Int, param: Int) {
        context.pixelStorei(pname, param)
    }

    override fun glReadPixels(
        x: Int, y: Int, width: Int, height: Int, format: Int, type: Int, pixels: ByteArray
    ) {
        val buffer = Int8Array(pixels.size)
        context.readPixels(x, y, width, height, format, type, buffer)
        buffer.copyTo(pixels)
    }

    override fun glReadPixels(
        x: Int, y: Int, width: Int, height: Int, format: Int, type: Int, pixels: IntArray
    ) {
        val buffer = Int32Array(pixels.size)
        context.readPixels(x, y, width, height, format, type, buffer)
        buffer.copyTo(pixels)
    }

    override fun glSampleCoverage(value: Float, invert: Boolean) {
        context.sampleCoverage(value, invert)
    }

    override fun glScissor(x: Int, y: Int, width: Int, height: Int) {
        context.scissor(x, y, width, height)
    }

    override fun glStencilFunc(func: Int, ref: Int, mask: Int) {
        context.stencilFunc(func, ref, mask)
    }

    override fun glStencilMask(mask: Int) {
        context.stencilMask(mask)
    }

    override fun glStencilOp(fail: Int, zfail: Int, zpass: Int) {
        context.stencilOp(fail, zfail, zpass)
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
        context.texImage2D(
            target, level, internalformat, width, height, border, format, type, pixels.toInt8Array()
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
        context.texImage2D(
            target, level, internalformat, width, height, border, format, type, pixels.toInt32Array()
        )
    }

    override fun glTexParameteri(target: Int, pname: Int, param: Int) {
        context.texParameteri(target, pname, param)
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
        context.texSubImage2D(
            target, level, xoffset, yoffset, width, height, format, type, pixels.toInt8Array()
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
        context.texSubImage2D(
            target, level, xoffset, yoffset, width, height, format, type, pixels.toInt32Array()
        )
    }

    override fun glViewport(x: Int, y: Int, width: Int, height: Int) {
        context.viewport(x, y, width, height)
    }
}