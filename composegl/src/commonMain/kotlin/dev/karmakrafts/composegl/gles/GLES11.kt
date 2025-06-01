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
 * GLES 1.1 conformant API minus fixed point/fixed pipeline functions,
 * compatible with the WebGL standard.
 * See https://registry.khronos.org/OpenGL/specs/es/1.1/es_full_spec_1.1.pdf
 */
interface GLES11 {
    val GL_DEPTH_BUFFER_BIT: Int
    val GL_STENCIL_BUFFER_BIT: Int
    val GL_COLOR_BUFFER_BIT: Int
    val GL_FALSE: Int
    val GL_TRUE: Int
    val GL_POINTS: Int
    val GL_LINES: Int
    val GL_LINE_LOOP: Int
    val GL_LINE_STRIP: Int
    val GL_TRIANGLES: Int
    val GL_TRIANGLE_STRIP: Int
    val GL_TRIANGLE_FAN: Int
    val GL_NEVER: Int
    val GL_LESS: Int
    val GL_EQUAL: Int
    val GL_LEQUAL: Int
    val GL_GREATER: Int
    val GL_NOTEQUAL: Int
    val GL_GEQUAL: Int
    val GL_ALWAYS: Int
    val GL_ZERO: Int
    val GL_ONE: Int
    val GL_SRC_COLOR: Int
    val GL_ONE_MINUS_SRC_COLOR: Int
    val GL_SRC_ALPHA: Int
    val GL_ONE_MINUS_SRC_ALPHA: Int
    val GL_DST_ALPHA: Int
    val GL_ONE_MINUS_DST_ALPHA: Int
    val GL_DST_COLOR: Int
    val GL_ONE_MINUS_DST_COLOR: Int
    val GL_SRC_ALPHA_SATURATE: Int
    val GL_FRONT: Int
    val GL_BACK: Int
    val GL_FRONT_AND_BACK: Int
    val GL_TEXTURE_2D: Int
    val GL_CULL_FACE: Int
    val GL_BLEND: Int
    val GL_DITHER: Int
    val GL_STENCIL_TEST: Int
    val GL_DEPTH_TEST: Int
    val GL_SCISSOR_TEST: Int
    val GL_SAMPLE_ALPHA_TO_COVERAGE: Int
    val GL_SAMPLE_COVERAGE: Int
    val GL_NO_ERROR: Int
    val GL_INVALID_ENUM: Int
    val GL_INVALID_VALUE: Int
    val GL_INVALID_OPERATION: Int
    val GL_OUT_OF_MEMORY: Int
    val GL_CW: Int
    val GL_CCW: Int
    val GL_LINE_WIDTH: Int
    val GL_ALIASED_POINT_SIZE_RANGE: Int
    val GL_ALIASED_LINE_WIDTH_RANGE: Int
    val GL_CULL_FACE_MODE: Int
    val GL_FRONT_FACE: Int
    val GL_DEPTH_RANGE: Int
    val GL_DEPTH_WRITEMASK: Int
    val GL_DEPTH_CLEAR_VALUE: Int
    val GL_DEPTH_FUNC: Int
    val GL_STENCIL_CLEAR_VALUE: Int
    val GL_STENCIL_FUNC: Int
    val GL_STENCIL_VALUE_MASK: Int
    val GL_STENCIL_FAIL: Int
    val GL_STENCIL_PASS_DEPTH_FAIL: Int
    val GL_STENCIL_PASS_DEPTH_PASS: Int
    val GL_STENCIL_REF: Int
    val GL_STENCIL_WRITEMASK: Int
    val GL_VIEWPORT: Int
    val GL_SCISSOR_BOX: Int
    val GL_COLOR_CLEAR_VALUE: Int
    val GL_COLOR_WRITEMASK: Int
    val GL_MAX_TEXTURE_SIZE: Int
    val GL_MAX_VIEWPORT_DIMS: Int
    val GL_SUBPIXEL_BITS: Int
    val GL_RED_BITS: Int
    val GL_GREEN_BITS: Int
    val GL_BLUE_BITS: Int
    val GL_ALPHA_BITS: Int
    val GL_DEPTH_BITS: Int
    val GL_STENCIL_BITS: Int
    val GL_POLYGON_OFFSET_UNITS: Int
    val GL_POLYGON_OFFSET_FILL: Int
    val GL_POLYGON_OFFSET_FACTOR: Int
    val GL_TEXTURE_BINDING_2D: Int
    val GL_SAMPLE_BUFFERS: Int
    val GL_SAMPLES: Int
    val GL_SAMPLE_COVERAGE_VALUE: Int
    val GL_SAMPLE_COVERAGE_INVERT: Int
    val GL_COMPRESSED_TEXTURE_FORMATS: Int
    val GL_DONT_CARE: Int
    val GL_FASTEST: Int
    val GL_NICEST: Int
    val GL_GENERATE_MIPMAP_HINT: Int
    val GL_BYTE: Int
    val GL_UNSIGNED_BYTE: Int
    val GL_SHORT: Int
    val GL_UNSIGNED_SHORT: Int
    val GL_FLOAT: Int
    val GL_INVERT: Int
    val GL_TEXTURE: Int
    val GL_ALPHA: Int
    val GL_RGB: Int
    val GL_RGBA: Int
    val GL_LUMINANCE: Int
    val GL_LUMINANCE_ALPHA: Int
    val GL_UNPACK_ALIGNMENT: Int
    val GL_PACK_ALIGNMENT: Int
    val GL_UNSIGNED_SHORT_4_4_4_4: Int
    val GL_UNSIGNED_SHORT_5_5_5_1: Int
    val GL_UNSIGNED_SHORT_5_6_5: Int
    val GL_KEEP: Int
    val GL_REPLACE: Int
    val GL_INCR: Int
    val GL_DECR: Int
    val GL_VENDOR: Int
    val GL_RENDERER: Int
    val GL_VERSION: Int
    val GL_NEAREST: Int
    val GL_LINEAR: Int
    val GL_NEAREST_MIPMAP_NEAREST: Int
    val GL_LINEAR_MIPMAP_NEAREST: Int
    val GL_NEAREST_MIPMAP_LINEAR: Int
    val GL_LINEAR_MIPMAP_LINEAR: Int
    val GL_TEXTURE_MAG_FILTER: Int
    val GL_TEXTURE_MIN_FILTER: Int
    val GL_TEXTURE_WRAP_S: Int
    val GL_TEXTURE_WRAP_T: Int
    val GL_TEXTURE0: Int
    val GL_TEXTURE1: Int
    val GL_TEXTURE2: Int
    val GL_TEXTURE3: Int
    val GL_TEXTURE4: Int
    val GL_TEXTURE5: Int
    val GL_TEXTURE6: Int
    val GL_TEXTURE7: Int
    val GL_TEXTURE8: Int
    val GL_TEXTURE9: Int
    val GL_TEXTURE10: Int
    val GL_TEXTURE11: Int
    val GL_TEXTURE12: Int
    val GL_TEXTURE13: Int
    val GL_TEXTURE14: Int
    val GL_TEXTURE15: Int
    val GL_TEXTURE16: Int
    val GL_TEXTURE17: Int
    val GL_TEXTURE18: Int
    val GL_TEXTURE19: Int
    val GL_TEXTURE20: Int
    val GL_TEXTURE21: Int
    val GL_TEXTURE22: Int
    val GL_TEXTURE23: Int
    val GL_TEXTURE24: Int
    val GL_TEXTURE25: Int
    val GL_TEXTURE26: Int
    val GL_TEXTURE27: Int
    val GL_TEXTURE28: Int
    val GL_TEXTURE29: Int
    val GL_TEXTURE30: Int
    val GL_TEXTURE31: Int
    val GL_ACTIVE_TEXTURE: Int
    val GL_REPEAT: Int
    val GL_CLAMP_TO_EDGE: Int
    val GL_ARRAY_BUFFER: Int
    val GL_ELEMENT_ARRAY_BUFFER: Int
    val GL_ARRAY_BUFFER_BINDING: Int
    val GL_ELEMENT_ARRAY_BUFFER_BINDING: Int
    val GL_STATIC_DRAW: Int
    val GL_DYNAMIC_DRAW: Int
    val GL_BUFFER_SIZE: Int
    val GL_BUFFER_USAGE: Int

    // @formatter:off
    fun glClearColor(red: Float, green: Float, blue: Float, alpha: Float)
    fun glClearDepthf(d: Float)
    fun glDepthRangef(n: Float, f: Float)
    fun glLineWidth(width: Float)
    fun glPolygonOffset(factor: Float, units: Float)
    fun glTexParameterf(target: Int, pname: Int, param: Float)
    fun glActiveTexture(texture: Int)
    fun glBindBuffer(target: Int, buffer: Int)
    fun glBindTexture(target: Int, texture: Int)
    fun glBlendFunc(sfactor: Int, dfactor: Int)
    fun glBufferData(target: Int, data: ShortArray, usage: Int)
    fun glBufferData(target: Int, data: IntArray, usage: Int)
    fun glBufferData(target: Int, data: FloatArray, usage: Int)
    fun glBufferSubData(target: Int, offset: Long, data: ShortArray)
    fun glBufferSubData(target: Int, offset: Long, data: IntArray)
    fun glBufferSubData(target: Int, offset: Long, data: FloatArray)
    fun glClear(mask: Int)
    fun glClearStencil(s: Int)
    fun glColorMask(red: Boolean, green: Boolean, blue: Boolean, alpha: Boolean)
    fun glCompressedTexImage2D(target: Int, level: Int, internalformat: Int, width: Int, height: Int, border: Int, data: ByteArray)
    fun glCompressedTexSubImage2D(target: Int, level: Int, xoffset: Int, yoffset: Int, width: Int, height: Int, format: Int, data: ByteArray)
    fun glCopyTexImage2D(target: Int, level: Int, internalformat: Int, x: Int, y: Int, width: Int, height: Int, border: Int)
    fun glCopyTexSubImage2D(target: Int, level: Int, xoffset: Int, yoffset: Int, x: Int, y: Int, width: Int, height: Int)
    fun glCullFace(mode: Int)
    fun glDeleteBuffers(buffers: IntArray)
    fun glDeleteTextures(textures: IntArray)
    fun glDepthFunc(func: Int)
    fun glDepthMask(flag: Boolean)
    fun glDisable(cap: Int)
    fun glDrawArrays(mode: Int, first: Int, count: Int)
    fun glDrawElements(mode: Int, count: Int, type: Int, offset: Long)
    fun glEnable(cap: Int)
    fun glFinish()
    fun glFlush()
    fun glFrontFace(mode: Int)
    fun glGenBuffers(buffers: IntArray)
    fun glGenTextures(textures: IntArray)
    fun glGetError(): Int
    fun glHint(target: Int, mode: Int)
    fun glIsBuffer(buffer: Int): Boolean
    fun glIsEnabled(cap: Int): Boolean
    fun glIsTexture(texture: Int): Boolean
    fun glPixelStorei(pname: Int, param: Int)
    fun glReadPixels(x: Int, y: Int, width: Int, height: Int, format: Int, type: Int, pixels: ByteArray)
    fun glReadPixels(x: Int, y: Int, width: Int, height: Int, format: Int, type: Int, pixels: IntArray)
    fun glSampleCoverage(value: Float, invert: Boolean)
    fun glScissor(x: Int, y: Int, width: Int, height: Int)
    fun glStencilFunc(func: Int, ref: Int, mask: Int)
    fun glStencilMask(mask: Int)
    fun glStencilOp(fail: Int, zfail: Int, zpass: Int)
    fun glTexImage2D(target: Int, level: Int, internalformat: Int, width: Int, height: Int, border: Int, format: Int, type: Int, pixels: ByteArray)
    fun glTexImage2D(target: Int, level: Int, internalformat: Int, width: Int, height: Int, border: Int, format: Int, type: Int, pixels: IntArray)
    fun glTexParameteri(target: Int, pname: Int, param: Int)
    fun glTexSubImage2D(target: Int, level: Int, xoffset: Int, yoffset: Int, width: Int, height: Int, format: Int, type: Int, pixels: ByteArray)
    fun glTexSubImage2D(target: Int, level: Int, xoffset: Int, yoffset: Int, width: Int, height: Int, format: Int, type: Int, pixels: IntArray)
    fun glViewport(x: Int, y: Int, width: Int, height: Int)
    // @formatter:on

    fun Boolean.toGLBool(): Int = if (this) GL_TRUE else GL_FALSE
    fun Int.fromGLBool(): Boolean = this == GL_TRUE
}
