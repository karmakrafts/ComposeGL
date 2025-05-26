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

package dev.karmakrafts.composegl

import dev.karmakrafts.composegl.util.toDoubleArray
import org.lwjgl.opengl.GL11
import org.lwjgl.opengl.GL12
import org.lwjgl.opengl.GL13
import org.lwjgl.opengl.GL14
import org.lwjgl.opengl.GL15
import org.lwjgl.system.MemoryStack

internal object PlatformGLES11 : GLES11 {
    override val GL_DEPTH_BUFFER_BIT: Int get() = GL11.GL_DEPTH_BUFFER_BIT
    override val GL_STENCIL_BUFFER_BIT: Int get() = GL11.GL_STENCIL_BUFFER_BIT
    override val GL_COLOR_BUFFER_BIT: Int get() = GL11.GL_COLOR_BUFFER_BIT
    override val GL_FALSE: Int get() = GL11.GL_FALSE
    override val GL_TRUE: Int get() = GL11.GL_TRUE
    override val GL_POINTS: Int get() = GL11.GL_POINTS
    override val GL_LINES: Int get() = GL11.GL_LINES
    override val GL_LINE_LOOP: Int get() = GL11.GL_LINE_LOOP
    override val GL_LINE_STRIP: Int get() = GL11.GL_LINE_STRIP
    override val GL_TRIANGLES: Int get() = GL11.GL_TRIANGLES
    override val GL_TRIANGLE_STRIP: Int get() = GL11.GL_TRIANGLE_STRIP
    override val GL_TRIANGLE_FAN: Int get() = GL11.GL_TRIANGLE_FAN
    override val GL_NEVER: Int get() = GL11.GL_NEVER
    override val GL_LESS: Int get() = GL11.GL_LESS
    override val GL_EQUAL: Int get() = GL11.GL_EQUAL
    override val GL_LEQUAL: Int get() = GL11.GL_LEQUAL
    override val GL_GREATER: Int get() = GL11.GL_GREATER
    override val GL_NOTEQUAL: Int get() = GL11.GL_NOTEQUAL
    override val GL_GEQUAL: Int get() = GL11.GL_GEQUAL
    override val GL_ALWAYS: Int get() = GL11.GL_ALWAYS
    override val GL_ZERO: Int get() = GL11.GL_ZERO
    override val GL_ONE: Int get() = GL11.GL_ONE
    override val GL_SRC_COLOR: Int get() = GL11.GL_SRC_COLOR
    override val GL_ONE_MINUS_SRC_COLOR: Int get() = GL11.GL_ONE_MINUS_SRC_COLOR
    override val GL_SRC_ALPHA: Int get() = GL11.GL_SRC_ALPHA
    override val GL_ONE_MINUS_SRC_ALPHA: Int get() = GL11.GL_ONE_MINUS_SRC_ALPHA
    override val GL_DST_ALPHA: Int get() = GL11.GL_DST_ALPHA
    override val GL_ONE_MINUS_DST_ALPHA: Int get() = GL11.GL_ONE_MINUS_DST_ALPHA
    override val GL_DST_COLOR: Int get() = GL11.GL_DST_COLOR
    override val GL_ONE_MINUS_DST_COLOR: Int get() = GL11.GL_ONE_MINUS_DST_COLOR
    override val GL_SRC_ALPHA_SATURATE: Int get() = GL11.GL_SRC_ALPHA_SATURATE
    override val GL_FRONT: Int get() = GL11.GL_FRONT
    override val GL_BACK: Int get() = GL11.GL_BACK
    override val GL_FRONT_AND_BACK: Int get() = GL11.GL_FRONT_AND_BACK
    override val GL_TEXTURE_2D: Int get() = GL11.GL_TEXTURE_2D
    override val GL_CULL_FACE: Int get() = GL11.GL_CULL_FACE
    override val GL_BLEND: Int get() = GL11.GL_BLEND
    override val GL_DITHER: Int get() = GL11.GL_DITHER
    override val GL_STENCIL_TEST: Int get() = GL11.GL_STENCIL_TEST
    override val GL_DEPTH_TEST: Int get() = GL11.GL_DEPTH_TEST
    override val GL_SCISSOR_TEST: Int get() = GL11.GL_SCISSOR_TEST
    override val GL_SAMPLE_ALPHA_TO_COVERAGE: Int get() = GL13.GL_SAMPLE_ALPHA_TO_COVERAGE
    override val GL_SAMPLE_COVERAGE: Int get() = GL13.GL_SAMPLE_COVERAGE
    override val GL_NO_ERROR: Int get() = GL11.GL_NO_ERROR
    override val GL_INVALID_ENUM: Int get() = GL11.GL_INVALID_ENUM
    override val GL_INVALID_VALUE: Int get() = GL11.GL_INVALID_VALUE
    override val GL_INVALID_OPERATION: Int get() = GL11.GL_INVALID_OPERATION
    override val GL_OUT_OF_MEMORY: Int get() = GL11.GL_OUT_OF_MEMORY
    override val GL_CW: Int get() = GL11.GL_CW
    override val GL_CCW: Int get() = GL11.GL_CCW
    override val GL_LINE_WIDTH: Int get() = GL11.GL_LINE_WIDTH
    override val GL_ALIASED_POINT_SIZE_RANGE: Int get() = GL12.GL_ALIASED_POINT_SIZE_RANGE
    override val GL_ALIASED_LINE_WIDTH_RANGE: Int get() = GL12.GL_ALIASED_LINE_WIDTH_RANGE
    override val GL_CULL_FACE_MODE: Int get() = GL11.GL_CULL_FACE_MODE
    override val GL_FRONT_FACE: Int get() = GL11.GL_FRONT_FACE
    override val GL_DEPTH_RANGE: Int get() = GL11.GL_DEPTH_RANGE
    override val GL_DEPTH_WRITEMASK: Int get() = GL11.GL_DEPTH_WRITEMASK
    override val GL_DEPTH_CLEAR_VALUE: Int get() = GL11.GL_DEPTH_CLEAR_VALUE
    override val GL_DEPTH_FUNC: Int get() = GL11.GL_DEPTH_FUNC
    override val GL_STENCIL_CLEAR_VALUE: Int get() = GL11.GL_STENCIL_CLEAR_VALUE
    override val GL_STENCIL_FUNC: Int get() = GL11.GL_STENCIL_FUNC
    override val GL_STENCIL_VALUE_MASK: Int get() = GL11.GL_STENCIL_VALUE_MASK
    override val GL_STENCIL_FAIL: Int get() = GL11.GL_STENCIL_FAIL
    override val GL_STENCIL_PASS_DEPTH_FAIL: Int get() = GL11.GL_STENCIL_PASS_DEPTH_FAIL
    override val GL_STENCIL_PASS_DEPTH_PASS: Int get() = GL11.GL_STENCIL_PASS_DEPTH_PASS
    override val GL_STENCIL_REF: Int get() = GL11.GL_STENCIL_REF
    override val GL_STENCIL_WRITEMASK: Int get() = GL11.GL_STENCIL_WRITEMASK
    override val GL_VIEWPORT: Int get() = GL11.GL_VIEWPORT
    override val GL_SCISSOR_BOX: Int get() = GL11.GL_SCISSOR_BOX
    override val GL_COLOR_CLEAR_VALUE: Int get() = GL11.GL_COLOR_CLEAR_VALUE
    override val GL_COLOR_WRITEMASK: Int get() = GL11.GL_COLOR_WRITEMASK
    override val GL_MAX_TEXTURE_SIZE: Int get() = GL11.GL_MAX_TEXTURE_SIZE
    override val GL_MAX_VIEWPORT_DIMS: Int get() = GL11.GL_MAX_VIEWPORT_DIMS
    override val GL_MAX_TEXTURE_UNITS: Int get() = GL13.GL_MAX_TEXTURE_UNITS
    override val GL_SUBPIXEL_BITS: Int get() = GL11.GL_SUBPIXEL_BITS
    override val GL_RED_BITS: Int get() = GL11.GL_RED_BITS
    override val GL_GREEN_BITS: Int get() = GL11.GL_GREEN_BITS
    override val GL_BLUE_BITS: Int get() = GL11.GL_BLUE_BITS
    override val GL_ALPHA_BITS: Int get() = GL11.GL_ALPHA_BITS
    override val GL_DEPTH_BITS: Int get() = GL11.GL_DEPTH_BITS
    override val GL_STENCIL_BITS: Int get() = GL11.GL_STENCIL_BITS
    override val GL_POLYGON_OFFSET_UNITS: Int get() = GL11.GL_POLYGON_OFFSET_UNITS
    override val GL_POLYGON_OFFSET_FILL: Int get() = GL11.GL_POLYGON_OFFSET_FILL
    override val GL_POLYGON_OFFSET_FACTOR: Int get() = GL11.GL_POLYGON_OFFSET_FACTOR
    override val GL_TEXTURE_BINDING_2D: Int get() = GL11.GL_TEXTURE_BINDING_2D
    override val GL_SAMPLE_BUFFERS: Int get() = GL13.GL_SAMPLE_BUFFERS
    override val GL_SAMPLES: Int get() = GL13.GL_SAMPLES
    override val GL_SAMPLE_COVERAGE_VALUE: Int get() = GL13.GL_SAMPLE_COVERAGE_VALUE
    override val GL_SAMPLE_COVERAGE_INVERT: Int get() = GL13.GL_SAMPLE_COVERAGE_INVERT
    override val GL_COMPRESSED_TEXTURE_FORMATS: Int get() = GL13.GL_COMPRESSED_TEXTURE_FORMATS
    override val GL_DONT_CARE: Int get() = GL11.GL_DONT_CARE
    override val GL_FASTEST: Int get() = GL11.GL_FASTEST
    override val GL_NICEST: Int get() = GL11.GL_NICEST
    override val GL_GENERATE_MIPMAP_HINT: Int get() = GL14.GL_GENERATE_MIPMAP_HINT
    override val GL_BYTE: Int get() = GL11.GL_BYTE
    override val GL_UNSIGNED_BYTE: Int get() = GL11.GL_UNSIGNED_BYTE
    override val GL_SHORT: Int get() = GL11.GL_SHORT
    override val GL_UNSIGNED_SHORT: Int get() = GL11.GL_UNSIGNED_SHORT
    override val GL_FLOAT: Int get() = GL11.GL_FLOAT
    override val GL_INVERT: Int get() = GL11.GL_INVERT
    override val GL_TEXTURE: Int get() = GL11.GL_TEXTURE
    override val GL_ALPHA: Int get() = GL11.GL_ALPHA
    override val GL_RGB: Int get() = GL11.GL_RGB
    override val GL_RGBA: Int get() = GL11.GL_RGBA
    override val GL_LUMINANCE: Int get() = GL11.GL_LUMINANCE
    override val GL_LUMINANCE_ALPHA: Int get() = GL11.GL_LUMINANCE_ALPHA
    override val GL_UNPACK_ALIGNMENT: Int get() = GL11.GL_UNPACK_ALIGNMENT
    override val GL_PACK_ALIGNMENT: Int get() = GL11.GL_PACK_ALIGNMENT
    override val GL_UNSIGNED_SHORT_4_4_4_4: Int get() = GL12.GL_UNSIGNED_SHORT_4_4_4_4
    override val GL_UNSIGNED_SHORT_5_5_5_1: Int get() = GL12.GL_UNSIGNED_SHORT_5_5_5_1
    override val GL_UNSIGNED_SHORT_5_6_5: Int get() = GL12.GL_UNSIGNED_SHORT_5_6_5
    override val GL_KEEP: Int get() = GL11.GL_KEEP
    override val GL_REPLACE: Int get() = GL11.GL_REPLACE
    override val GL_INCR: Int get() = GL11.GL_INCR
    override val GL_DECR: Int get() = GL11.GL_DECR
    override val GL_VENDOR: Int get() = GL11.GL_VENDOR
    override val GL_RENDERER: Int get() = GL11.GL_RENDERER
    override val GL_VERSION: Int get() = GL11.GL_VERSION
    override val GL_ADD: Int get() = GL11.GL_ADD
    override val GL_NEAREST: Int get() = GL11.GL_NEAREST
    override val GL_LINEAR: Int get() = GL11.GL_LINEAR
    override val GL_NEAREST_MIPMAP_NEAREST: Int get() = GL11.GL_NEAREST_MIPMAP_NEAREST
    override val GL_LINEAR_MIPMAP_NEAREST: Int get() = GL11.GL_LINEAR_MIPMAP_NEAREST
    override val GL_NEAREST_MIPMAP_LINEAR: Int get() = GL11.GL_NEAREST_MIPMAP_LINEAR
    override val GL_LINEAR_MIPMAP_LINEAR: Int get() = GL11.GL_LINEAR_MIPMAP_LINEAR
    override val GL_TEXTURE_MAG_FILTER: Int get() = GL11.GL_TEXTURE_MAG_FILTER
    override val GL_TEXTURE_MIN_FILTER: Int get() = GL11.GL_TEXTURE_MIN_FILTER
    override val GL_TEXTURE_WRAP_S: Int get() = GL11.GL_TEXTURE_WRAP_S
    override val GL_TEXTURE_WRAP_T: Int get() = GL11.GL_TEXTURE_WRAP_T
    override val GL_TEXTURE0: Int get() = GL13.GL_TEXTURE0
    override val GL_TEXTURE1: Int get() = GL13.GL_TEXTURE1
    override val GL_TEXTURE2: Int get() = GL13.GL_TEXTURE2
    override val GL_TEXTURE3: Int get() = GL13.GL_TEXTURE3
    override val GL_TEXTURE4: Int get() = GL13.GL_TEXTURE4
    override val GL_TEXTURE5: Int get() = GL13.GL_TEXTURE5
    override val GL_TEXTURE6: Int get() = GL13.GL_TEXTURE6
    override val GL_TEXTURE7: Int get() = GL13.GL_TEXTURE7
    override val GL_TEXTURE8: Int get() = GL13.GL_TEXTURE8
    override val GL_TEXTURE9: Int get() = GL13.GL_TEXTURE9
    override val GL_TEXTURE10: Int get() = GL13.GL_TEXTURE10
    override val GL_TEXTURE11: Int get() = GL13.GL_TEXTURE11
    override val GL_TEXTURE12: Int get() = GL13.GL_TEXTURE12
    override val GL_TEXTURE13: Int get() = GL13.GL_TEXTURE13
    override val GL_TEXTURE14: Int get() = GL13.GL_TEXTURE14
    override val GL_TEXTURE15: Int get() = GL13.GL_TEXTURE15
    override val GL_TEXTURE16: Int get() = GL13.GL_TEXTURE16
    override val GL_TEXTURE17: Int get() = GL13.GL_TEXTURE17
    override val GL_TEXTURE18: Int get() = GL13.GL_TEXTURE18
    override val GL_TEXTURE19: Int get() = GL13.GL_TEXTURE19
    override val GL_TEXTURE20: Int get() = GL13.GL_TEXTURE20
    override val GL_TEXTURE21: Int get() = GL13.GL_TEXTURE21
    override val GL_TEXTURE22: Int get() = GL13.GL_TEXTURE22
    override val GL_TEXTURE23: Int get() = GL13.GL_TEXTURE23
    override val GL_TEXTURE24: Int get() = GL13.GL_TEXTURE24
    override val GL_TEXTURE25: Int get() = GL13.GL_TEXTURE25
    override val GL_TEXTURE26: Int get() = GL13.GL_TEXTURE26
    override val GL_TEXTURE27: Int get() = GL13.GL_TEXTURE27
    override val GL_TEXTURE28: Int get() = GL13.GL_TEXTURE28
    override val GL_TEXTURE29: Int get() = GL13.GL_TEXTURE29
    override val GL_TEXTURE30: Int get() = GL13.GL_TEXTURE30
    override val GL_TEXTURE31: Int get() = GL13.GL_TEXTURE31
    override val GL_ACTIVE_TEXTURE: Int get() = GL13.GL_ACTIVE_TEXTURE
    override val GL_REPEAT: Int get() = GL11.GL_REPEAT
    override val GL_CLAMP_TO_EDGE: Int get() = GL12.GL_CLAMP_TO_EDGE
    override val GL_ARRAY_BUFFER: Int get() = GL15.GL_ARRAY_BUFFER
    override val GL_ELEMENT_ARRAY_BUFFER: Int get() = GL15.GL_ELEMENT_ARRAY_BUFFER
    override val GL_ARRAY_BUFFER_BINDING: Int get() = GL15.GL_ARRAY_BUFFER_BINDING
    override val GL_ELEMENT_ARRAY_BUFFER_BINDING: Int get() = GL15.GL_ELEMENT_ARRAY_BUFFER_BINDING
    override val GL_STATIC_DRAW: Int get() = GL15.GL_STATIC_DRAW
    override val GL_DYNAMIC_DRAW: Int get() = GL15.GL_DYNAMIC_DRAW
    override val GL_BUFFER_SIZE: Int get() = GL15.GL_BUFFER_SIZE
    override val GL_BUFFER_USAGE: Int get() = GL15.GL_BUFFER_USAGE
    override val GL_SUBTRACT: Int get() = GL13.GL_SUBTRACT

    override fun glAlphaFunc(func: Int, ref: Float) {
        GL11.glAlphaFunc(func, ref)
    }

    override fun glClearColor(red: Float, green: Float, blue: Float, alpha: Float) {
        GL11.glClearColor(red, green, blue, alpha)
    }

    override fun glClearDepthf(d: Float) {
        GL11.glClearDepth(d.toDouble())
    }

    override fun glClipPlanef(p: Int, eqn: FloatArray) {
        GL11.glClipPlane(p, eqn.toDoubleArray())
    }

    override fun glColor4f(red: Float, green: Float, blue: Float, alpha: Float) {
        GL11.glColor4f(red, green, blue, alpha)
    }

    override fun glDepthRangef(n: Float, f: Float) {
        GL11.glDepthRange(n.toDouble(), f.toDouble())
    }

    override fun glFogf(pname: Int, param: Float) {
        GL11.glFogf(pname, param)
    }

    override fun glFogfv(pname: Int, params: FloatArray) {
        GL11.glFogfv(pname, params)
    }

    override fun glFrustumf(
        l: Float, r: Float, b: Float, t: Float, n: Float, f: Float
    ) {
        GL11.glFrustum(l.toDouble(), r.toDouble(), b.toDouble(), t.toDouble(), n.toDouble(), f.toDouble())
    }

    override fun glGetClipPlanef(plane: Int, equation: FloatArray) {
        GL11.glGetClipPlane(plane, equation.toDoubleArray())
    }

    override fun glGetFloatv(pname: Int, data: FloatArray) {
        GL11.glGetFloatv(pname, data)
    }

    override fun glGetLightfv(light: Int, pname: Int, params: FloatArray) {
        GL11.glGetLightfv(light, pname, params)
    }

    override fun glGetMaterialfv(face: Int, pname: Int, params: FloatArray) {
        GL11.glGetMaterialfv(face, pname, params)
    }

    override fun glGetTexEnvfv(target: Int, pname: Int, params: FloatArray) {
        GL11.glGetTexEnvfv(target, pname, params)
    }

    override fun glGetTexParameterfv(target: Int, pname: Int, params: FloatArray) {
        GL11.glGetTexParameterfv(target, pname, params)
    }

    override fun glLightModelf(pname: Int, param: Float) {
        GL11.glLightModelf(pname, param)
    }

    override fun glLightModelfv(pname: Int, params: FloatArray) {
        GL11.glLightModelfv(pname, params)
    }

    override fun glLightf(light: Int, pname: Int, param: Float) {
        GL11.glLightf(light, pname, param)
    }

    override fun glLightfv(light: Int, pname: Int, params: FloatArray) {
        GL11.glLightfv(light, pname, params)
    }

    override fun glLineWidth(width: Float) {
        GL11.glLineWidth(width)
    }

    override fun glLoadMatrixf(m: FloatArray) {
        GL11.glLoadMatrixf(m)
    }

    override fun glMaterialf(face: Int, pname: Int, param: Float) {
        GL11.glMaterialf(face, pname, param)
    }

    override fun glMaterialfv(face: Int, pname: Int, params: FloatArray) {
        GL11.glMaterialfv(face, pname, params)
    }

    override fun glMultMatrixf(m: FloatArray) {
        GL11.glMultMatrixf(m)
    }

    override fun glMultiTexCoord4f(
        target: Int, s: Float, t: Float, r: Float, q: Float
    ) {
        GL13.glMultiTexCoord4f(target, s, t, r, q)
    }

    override fun glNormal3f(nx: Float, ny: Float, nz: Float) {
        GL11.glNormal3f(nx, ny, nz)
    }

    override fun glOrthof(
        l: Float, r: Float, b: Float, t: Float, n: Float, f: Float
    ) {
        GL11.glOrtho(l.toDouble(), r.toDouble(), b.toDouble(), t.toDouble(), n.toDouble(), f.toDouble())
    }

    override fun glPointParameterf(pname: Int, param: Float) {
        GL14.glPointParameterf(pname, param)
    }

    override fun glPointParameterfv(pname: Int, params: FloatArray) {
        GL14.glPointParameterfv(pname, params)
    }

    override fun glPointSize(size: Float) {
        GL11.glPointSize(size)
    }

    override fun glPolygonOffset(factor: Float, units: Float) {
        GL11.glPolygonOffset(factor, units)
    }

    override fun glRotatef(angle: Float, x: Float, y: Float, z: Float) {
        GL11.glRotatef(angle, x, y, z)
    }

    override fun glScalef(x: Float, y: Float, z: Float) {
        GL11.glScalef(x, y, z)
    }

    override fun glTexEnvf(target: Int, pname: Int, param: Float) {
        GL11.glTexEnvf(target, pname, param)
    }

    override fun glTexEnvfv(target: Int, pname: Int, params: FloatArray) {
        GL11.glTexEnvfv(target, pname, params)
    }

    override fun glTexParameterf(target: Int, pname: Int, param: Float) {
        GL11.glTexParameterf(target, pname, param)
    }

    override fun glTexParameterfv(target: Int, pname: Int, params: FloatArray) {
        GL11.glTexParameterfv(target, pname, params)
    }

    override fun glTranslatef(x: Float, y: Float, z: Float) {
        GL11.glTranslatef(x, y, z)
    }

    override fun glActiveTexture(texture: Int) {
        GL13.glActiveTexture(texture)
    }

    override fun glBindBuffer(target: Int, buffer: Int) {
        GL15.glBindBuffer(target, buffer)
    }

    override fun glBindTexture(target: Int, texture: Int) {
        GL11.glBindTexture(target, texture)
    }

    override fun glBlendFunc(sfactor: Int, dfactor: Int) {
        GL11.glBlendFunc(sfactor, dfactor)
    }

    override fun glBufferData(target: Int, data: ShortArray, usage: Int) {
        GL15.glBufferData(target, data, usage)
    }

    override fun glBufferData(target: Int, data: IntArray, usage: Int) {
        GL15.glBufferData(target, data, usage)
    }

    override fun glBufferData(target: Int, data: FloatArray, usage: Int) {
        GL15.glBufferData(target, data, usage)
    }

    override fun glBufferSubData(target: Int, offset: Long, data: ShortArray) {
        GL15.glBufferSubData(target, offset, data)
    }

    override fun glBufferSubData(target: Int, offset: Long, data: IntArray) {
        GL15.glBufferSubData(target, offset, data)
    }

    override fun glBufferSubData(target: Int, offset: Long, data: FloatArray) {
        GL15.glBufferSubData(target, offset, data)
    }

    override fun glClear(mask: Int) {
        GL11.glClear(mask)
    }

    override fun glClearStencil(s: Int) {
        GL11.glClearStencil(s)
    }

    override fun glClientActiveTexture(texture: Int) {
        GL13.glClientActiveTexture(texture)
    }

    override fun glColor4ub(red: Byte, green: Byte, blue: Byte, alpha: Byte) {
        GL11.glColor4ub(red, green, blue, alpha)
    }

    override fun glColorMask(red: Boolean, green: Boolean, blue: Boolean, alpha: Boolean) {
        GL11.glColorMask(red, green, blue, alpha)
    }

    override fun glColorPointer(size: Int, type: Int, stride: Int, pointer: Long) {
        GL11.glColorPointer(size, type, stride, pointer)
    }

    override fun glCompressedTexImage2D(
        target: Int, level: Int, internalformat: Int, width: Int, height: Int, border: Int, data: ByteArray
    ) {
        val stack = MemoryStack.stackGet()
        val previousSp = stack.pointer
        val buffer = stack.bytes(*data).flip()
        GL13.glCompressedTexImage2D(target, level, internalformat, width, height, border, buffer)
        stack.pointer = previousSp
    }

    override fun glCompressedTexSubImage2D(
        target: Int, level: Int, xoffset: Int, yoffset: Int, width: Int, height: Int, format: Int, data: ByteArray
    ) {
        val stack = MemoryStack.stackGet()
        val previousSp = stack.pointer
        val buffer = stack.bytes(*data).flip()
        GL13.glCompressedTexSubImage2D(target, level, xoffset, yoffset, width, height, format, buffer)
        stack.pointer = previousSp
    }

    override fun glCopyTexImage2D(
        target: Int, level: Int, internalformat: Int, x: Int, y: Int, width: Int, height: Int, border: Int
    ) {
        GL11.glCopyTexImage2D(target, level, internalformat, x, y, width, height, border)
    }

    override fun glCopyTexSubImage2D(
        target: Int, level: Int, xoffset: Int, yoffset: Int, x: Int, y: Int, width: Int, height: Int
    ) {
        GL11.glCopyTexSubImage2D(target, level, xoffset, yoffset, x, y, width, height)
    }

    override fun glCullFace(mode: Int) {
        GL11.glCullFace(mode)
    }

    override fun glGenBuffers(buffers: IntArray) {
        GL15.glGenBuffers(buffers)
    }

    override fun glDeleteBuffers(buffers: IntArray) {
        GL15.glDeleteBuffers(buffers)
    }

    override fun glGenTextures(textures: IntArray) {
        GL15.glGenTextures(textures)
    }

    override fun glDeleteTextures(textures: IntArray) {
        GL11.glDeleteTextures(textures)
    }

    override fun glDepthFunc(func: Int) {
        GL11.glDepthFunc(func)
    }

    override fun glDepthMask(flag: Boolean) {
        GL11.glDepthMask(flag)
    }

    override fun glDisable(cap: Int) {
        GL11.glDisable(cap)
    }

    override fun glDisableClientState(array: Int) {
        GL11.glDisableClientState(array)
    }

    override fun glDrawArrays(mode: Int, first: Int, count: Int) {
        GL11.glDrawArrays(mode, first, count)
    }

    override fun glDrawElements(mode: Int, count: Int, type: Int, indices: Long) {
        GL11.glDrawElements(mode, count, type, indices)
    }

    override fun glEnable(cap: Int) {
        GL11.glEnable(cap)
    }

    override fun glEnableClientState(array: Int) {
        GL11.glEnableClientState(array)
    }

    override fun glFinish() {
        GL11.glFinish()
    }

    override fun glFlush() {
        GL11.glFlush()
    }

    override fun glFrontFace(mode: Int) {
        GL11.glFrontFace(mode)
    }

    override fun glGetBooleanv(pname: Int, data: BooleanArray) {
        val stack = MemoryStack.stackGet()
        val previousSp = stack.pointer
        val buffer = stack.malloc(data.size)
        GL11.glGetBooleanv(pname, buffer)
        val result = buffer.array()
        stack.pointer = previousSp
        for (i in result.indices) {
            data[i] = result[i] == GL11.GL_TRUE.toByte()
        }
    }

    override fun glGetBufferParameteriv(target: Int, pname: Int, params: IntArray) {
        GL15.glGetBufferParameteriv(target, pname, params)
    }

    override fun glGetError(): Int {
        return GL11.glGetError()
    }

    override fun glGetIntegerv(pname: Int, data: IntArray) {
        GL11.glGetIntegerv(pname, data)
    }

    override fun glGetString(name: Int): String? {
        return GL11.glGetString(name)
    }

    override fun glGetTexEnviv(target: Int, pname: Int, params: IntArray) {
        TODO("Not yet implemented")
    }

    override fun glGetTexParameteriv(target: Int, pname: Int, params: IntArray) {
        TODO("Not yet implemented")
    }

    override fun glHint(target: Int, mode: Int) {
        TODO("Not yet implemented")
    }

    override fun glIsBuffer(buffer: Int): Int {
        TODO("Not yet implemented")
    }

    override fun glIsEnabled(cap: Int): Int {
        TODO("Not yet implemented")
    }

    override fun glIsTexture(texture: Int): Int {
        TODO("Not yet implemented")
    }

    override fun glLoadIdentity() {
        TODO("Not yet implemented")
    }

    override fun glLogicOp(opcode: Int) {
        TODO("Not yet implemented")
    }

    override fun glMatrixMode(mode: Int) {
        TODO("Not yet implemented")
    }

    override fun glNormalPointer(type: Int, stride: Int, pointer: Long) {
        TODO("Not yet implemented")
    }

    override fun glPixelStorei(pname: Int, param: Int) {
        TODO("Not yet implemented")
    }

    override fun glReadPixels(
        x: Int, y: Int, width: Int, height: Int, format: Int, type: Int, pixels: ByteArray
    ) {
        TODO("Not yet implemented")
    }

    override fun glReadPixels(
        x: Int, y: Int, width: Int, height: Int, format: Int, type: Int, pixels: IntArray
    ) {
        TODO("Not yet implemented")
    }

    override fun glSampleCoverage(value: Float, invert: Int) {
        TODO("Not yet implemented")
    }

    override fun glScissor(x: Int, y: Int, width: Int, height: Int) {
        TODO("Not yet implemented")
    }

    override fun glShadeModel(mode: Int) {
        TODO("Not yet implemented")
    }

    override fun glStencilFunc(func: Int, ref: Int, mask: Int) {
        TODO("Not yet implemented")
    }

    override fun glStencilMask(mask: Int) {
        TODO("Not yet implemented")
    }

    override fun glStencilOp(fail: Int, zfail: Int, zpass: Int) {
        TODO("Not yet implemented")
    }

    override fun glTexCoordPointer(size: Int, type: Int, stride: Int, pointer: Long) {
        TODO("Not yet implemented")
    }

    override fun glTexEnvi(target: Int, pname: Int, param: Int) {
        TODO("Not yet implemented")
    }

    override fun glTexEnviv(target: Int, pname: Int, params: IntArray) {
        TODO("Not yet implemented")
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
        TODO("Not yet implemented")
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
        TODO("Not yet implemented")
    }

    override fun glTexParameteri(target: Int, pname: Int, param: Int) {
        TODO("Not yet implemented")
    }

    override fun glTexParameteriv(target: Int, pname: Int, params: IntArray) {
        TODO("Not yet implemented")
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
        TODO("Not yet implemented")
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
        TODO("Not yet implemented")
    }

    override fun glVertexPointer(size: Int, type: Int, stride: Int, pointer: Long) {
        TODO("Not yet implemented")
    }

    override fun glViewport(x: Int, y: Int, width: Int, height: Int) {
        TODO("Not yet implemented")
    }
}
