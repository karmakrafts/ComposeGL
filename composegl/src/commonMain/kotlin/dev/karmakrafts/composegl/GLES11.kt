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
    val GL_CLIP_PLANE0: Int
    val GL_CLIP_PLANE1: Int
    val GL_CLIP_PLANE2: Int
    val GL_CLIP_PLANE3: Int
    val GL_CLIP_PLANE4: Int
    val GL_CLIP_PLANE5: Int
    val GL_FRONT: Int
    val GL_BACK: Int
    val GL_FRONT_AND_BACK: Int
    val GL_FOG: Int
    val GL_LIGHTING: Int
    val GL_TEXTURE_2D: Int
    val GL_CULL_FACE: Int
    val GL_ALPHA_TEST: Int
    val GL_BLEND: Int
    val GL_COLOR_LOGIC_OP: Int
    val GL_DITHER: Int
    val GL_STENCIL_TEST: Int
    val GL_DEPTH_TEST: Int
    val GL_POINT_SMOOTH: Int
    val GL_LINE_SMOOTH: Int
    val GL_SCISSOR_TEST: Int
    val GL_COLOR_MATERIAL: Int
    val GL_NORMALIZE: Int
    val GL_RESCALE_NORMAL: Int
    val GL_VERTEX_ARRAY: Int
    val GL_NORMAL_ARRAY: Int
    val GL_COLOR_ARRAY: Int
    val GL_TEXTURE_COORD_ARRAY: Int
    val GL_MULTISAMPLE: Int
    val GL_SAMPLE_ALPHA_TO_COVERAGE: Int
    val GL_SAMPLE_ALPHA_TO_ONE: Int
    val GL_SAMPLE_COVERAGE: Int
    val GL_NO_ERROR: Int
    val GL_INVALID_ENUM: Int
    val GL_INVALID_VALUE: Int
    val GL_INVALID_OPERATION: Int
    val GL_STACK_OVERFLOW: Int
    val GL_STACK_UNDERFLOW: Int
    val GL_OUT_OF_MEMORY: Int
    val GL_EXP: Int
    val GL_EXP2: Int
    val GL_FOG_DENSITY: Int
    val GL_FOG_START: Int
    val GL_FOG_END: Int
    val GL_FOG_MODE: Int
    val GL_FOG_COLOR: Int
    val GL_CW: Int
    val GL_CCW: Int
    val GL_CURRENT_COLOR: Int
    val GL_CURRENT_NORMAL: Int
    val GL_CURRENT_TEXTURE_COORDS: Int
    val GL_POINT_SIZE: Int
    val GL_POINT_SIZE_MIN: Int
    val GL_POINT_SIZE_MAX: Int
    val GL_POINT_FADE_THRESHOLD_SIZE: Int
    val GL_POINT_DISTANCE_ATTENUATION: Int
    val GL_SMOOTH_POINT_SIZE_RANGE: Int
    val GL_LINE_WIDTH: Int
    val GL_SMOOTH_LINE_WIDTH_RANGE: Int
    val GL_ALIASED_POINT_SIZE_RANGE: Int
    val GL_ALIASED_LINE_WIDTH_RANGE: Int
    val GL_CULL_FACE_MODE: Int
    val GL_FRONT_FACE: Int
    val GL_SHADE_MODEL: Int
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
    val GL_MATRIX_MODE: Int
    val GL_VIEWPORT: Int
    val GL_MODELVIEW_STACK_DEPTH: Int
    val GL_PROJECTION_STACK_DEPTH: Int
    val GL_TEXTURE_STACK_DEPTH: Int
    val GL_MODELVIEW_MATRIX: Int
    val GL_PROJECTION_MATRIX: Int
    val GL_TEXTURE_MATRIX: Int
    val GL_ALPHA_TEST_FUNC: Int
    val GL_ALPHA_TEST_REF: Int
    val GL_BLEND_DST: Int
    val GL_BLEND_SRC: Int
    val GL_LOGIC_OP_MODE: Int
    val GL_SCISSOR_BOX: Int
    val GL_COLOR_CLEAR_VALUE: Int
    val GL_COLOR_WRITEMASK: Int
    val GL_MAX_LIGHTS: Int
    val GL_MAX_CLIP_PLANES: Int
    val GL_MAX_TEXTURE_SIZE: Int
    val GL_MAX_MODELVIEW_STACK_DEPTH: Int
    val GL_MAX_PROJECTION_STACK_DEPTH: Int
    val GL_MAX_TEXTURE_STACK_DEPTH: Int
    val GL_MAX_VIEWPORT_DIMS: Int
    val GL_MAX_TEXTURE_UNITS: Int
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
    val GL_VERTEX_ARRAY_SIZE: Int
    val GL_VERTEX_ARRAY_TYPE: Int
    val GL_VERTEX_ARRAY_STRIDE: Int
    val GL_NORMAL_ARRAY_TYPE: Int
    val GL_NORMAL_ARRAY_STRIDE: Int
    val GL_COLOR_ARRAY_SIZE: Int
    val GL_COLOR_ARRAY_TYPE: Int
    val GL_COLOR_ARRAY_STRIDE: Int
    val GL_TEXTURE_COORD_ARRAY_SIZE: Int
    val GL_TEXTURE_COORD_ARRAY_TYPE: Int
    val GL_TEXTURE_COORD_ARRAY_STRIDE: Int
    val GL_VERTEX_ARRAY_POINTER: Int
    val GL_NORMAL_ARRAY_POINTER: Int
    val GL_COLOR_ARRAY_POINTER: Int
    val GL_TEXTURE_COORD_ARRAY_POINTER: Int
    val GL_SAMPLE_BUFFERS: Int
    val GL_SAMPLES: Int
    val GL_SAMPLE_COVERAGE_VALUE: Int
    val GL_SAMPLE_COVERAGE_INVERT: Int
    val GL_NUM_COMPRESSED_TEXTURE_FORMATS: Int
    val GL_COMPRESSED_TEXTURE_FORMATS: Int
    val GL_DONT_CARE: Int
    val GL_FASTEST: Int
    val GL_NICEST: Int
    val GL_PERSPECTIVE_CORRECTION_HINT: Int
    val GL_POINT_SMOOTH_HINT: Int
    val GL_LINE_SMOOTH_HINT: Int
    val GL_FOG_HINT: Int
    val GL_GENERATE_MIPMAP_HINT: Int
    val GL_LIGHT_MODEL_AMBIENT: Int
    val GL_LIGHT_MODEL_TWO_SIDE: Int
    val GL_AMBIENT: Int
    val GL_DIFFUSE: Int
    val GL_SPECULAR: Int
    val GL_POSITION: Int
    val GL_SPOT_DIRECTION: Int
    val GL_SPOT_EXPONENT: Int
    val GL_SPOT_CUTOFF: Int
    val GL_CONSTANT_ATTENUATION: Int
    val GL_LINEAR_ATTENUATION: Int
    val GL_QUADRATIC_ATTENUATION: Int
    val GL_BYTE: Int
    val GL_UNSIGNED_BYTE: Int
    val GL_SHORT: Int
    val GL_UNSIGNED_SHORT: Int
    val GL_FLOAT: Int
    val GL_FIXED: Int
    val GL_CLEAR: Int
    val GL_AND: Int
    val GL_AND_REVERSE: Int
    val GL_COPY: Int
    val GL_AND_INVERTED: Int
    val GL_NOOP: Int
    val GL_XOR: Int
    val GL_OR: Int
    val GL_NOR: Int
    val GL_EQUIV: Int
    val GL_INVERT: Int
    val GL_OR_REVERSE: Int
    val GL_COPY_INVERTED: Int
    val GL_OR_INVERTED: Int
    val GL_NAND: Int
    val GL_SET: Int
    val GL_EMISSION: Int
    val GL_SHININESS: Int
    val GL_AMBIENT_AND_DIFFUSE: Int
    val GL_MODELVIEW: Int
    val GL_PROJECTION: Int
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
    val GL_FLAT: Int
    val GL_SMOOTH: Int
    val GL_KEEP: Int
    val GL_REPLACE: Int
    val GL_INCR: Int
    val GL_DECR: Int
    val GL_VENDOR: Int
    val GL_RENDERER: Int
    val GL_VERSION: Int
    val GL_EXTENSIONS: Int
    val GL_MODULATE: Int
    val GL_DECAL: Int
    val GL_ADD: Int
    val GL_TEXTURE_ENV_MODE: Int
    val GL_TEXTURE_ENV_COLOR: Int
    val GL_TEXTURE_ENV: Int
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
    val GL_GENERATE_MIPMAP: Int
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
    val GL_CLIENT_ACTIVE_TEXTURE: Int
    val GL_REPEAT: Int
    val GL_CLAMP_TO_EDGE: Int
    val GL_LIGHT0: Int
    val GL_LIGHT1: Int
    val GL_LIGHT2: Int
    val GL_LIGHT3: Int
    val GL_LIGHT4: Int
    val GL_LIGHT5: Int
    val GL_LIGHT6: Int
    val GL_LIGHT7: Int
    val GL_ARRAY_BUFFER: Int
    val GL_ELEMENT_ARRAY_BUFFER: Int
    val GL_ARRAY_BUFFER_BINDING: Int
    val GL_ELEMENT_ARRAY_BUFFER_BINDING: Int
    val GL_VERTEX_ARRAY_BUFFER_BINDING: Int
    val GL_NORMAL_ARRAY_BUFFER_BINDING: Int
    val GL_COLOR_ARRAY_BUFFER_BINDING: Int
    val GL_TEXTURE_COORD_ARRAY_BUFFER_BINDING: Int
    val GL_STATIC_DRAW: Int
    val GL_DYNAMIC_DRAW: Int
    val GL_BUFFER_SIZE: Int
    val GL_BUFFER_USAGE: Int
    val GL_SUBTRACT: Int
    val GL_COMBINE: Int
    val GL_COMBINE_RGB: Int
    val GL_COMBINE_ALPHA: Int
    val GL_RGB_SCALE: Int
    val GL_ADD_SIGNED: Int
    val GL_INTERPOLATE: Int
    val GL_CONSTANT: Int
    val GL_PRIMARY_COLOR: Int
    val GL_PREVIOUS: Int
    val GL_OPERAND0_RGB: Int
    val GL_OPERAND1_RGB: Int
    val GL_OPERAND2_RGB: Int
    val GL_OPERAND0_ALPHA: Int
    val GL_OPERAND1_ALPHA: Int
    val GL_OPERAND2_ALPHA: Int
    val GL_ALPHA_SCALE: Int
    val GL_SRC0_RGB: Int
    val GL_SRC1_RGB: Int
    val GL_SRC2_RGB: Int
    val GL_SRC0_ALPHA: Int
    val GL_SRC1_ALPHA: Int
    val GL_SRC2_ALPHA: Int
    val GL_DOT3_RGB: Int
    val GL_DOT3_RGBA: Int

    // @formatter:off
    fun glAlphaFunc(func: Int, ref: Float)
    fun glClearColor(red: Float, green: Float, blue: Float, alpha: Float)
    fun glClearDepthf(d: Float)
    fun glClipPlanef(p: Int, eqn: FloatArray)
    fun glColor4f(red: Float, green: Float, blue: Float, alpha: Float)
    fun glDepthRangef(n: Float, f: Float)
    fun glFogf(pname: Int, param: Float)
    fun glFogfv(pname: Int, params: FloatArray)
    fun glFrustumf(l: Float, r: Float, b: Float, t: Float, n: Float, f: Float)
    fun glGetClipPlanef(plane: Int, equation: FloatArray)
    fun glGetFloatv(pname: Int, data: FloatArray)
    fun glGetLightfv(light: Int, pname: Int, params: FloatArray)
    fun glGetMaterialfv(face: Int, pname: Int, params: FloatArray)
    fun glGetTexEnvfv(target: Int, pname: Int, params: FloatArray)
    fun glGetTexParameterfv(target: Int, pname: Int, params: FloatArray)
    fun glLightModelf(pname: Int, param: Float)
    fun glLightModelfv(pname: Int, params: FloatArray)
    fun glLightf(light: Int, pname: Int, param: Float)
    fun glLightfv(light: Int, pname: Int, params: FloatArray)
    fun glLineWidth(width: Float)
    fun glLoadMatrixf(m: FloatArray)
    fun glMaterialf(face: Int, pname: Int, param: Float)
    fun glMaterialfv(face: Int, pname: Int, params: FloatArray)
    fun glMultMatrixf(m: FloatArray)
    fun glMultiTexCoord4f(target: Int, s: Float, t: Float, r: Float, q: Float)
    fun glNormal3f(nx: Float, ny: Float, nz: Float)
    fun glOrthof(l: Float, r: Float, b: Float, t: Float, n: Float, f: Float)
    fun glPointParameterf(pname: Int, param: Float)
    fun glPointParameterfv(pname: Int, params: FloatArray)
    fun glPointSize(size: Float)
    fun glPolygonOffset(factor: Float, units: Float)
    fun glRotatef(angle: Float, x: Float, y: Float, z: Float)
    fun glScalef(x: Float, y: Float, z: Float)
    fun glTexEnvf(target: Int, pname: Int, param: Float)
    fun glTexEnvfv(target: Int, pname: Int, params: FloatArray)
    fun glTexParameterf(target: Int, pname: Int, param: Float)
    fun glTexParameterfv(target: Int, pname: Int, params: FloatArray)
    fun glTranslatef(x: Float, y: Float, z: Float)
    fun glActiveTexture(texture: Int)
    fun glAlphaFuncx(func: Int, ref: Int)
    fun glBindBuffer(target: Int, buffer: Int)
    fun glBindTexture(target: Int, texture: Int)
    fun glBlendFunc(sfactor: Int, dfactor: Int)
    fun glBufferData(target: Int, size: Long, data: ByteArray, usage: Int)
    fun glBufferData(target: Int, size: Long, data: ShortArray, usage: Int)
    fun glBufferData(target: Int, size: Long, data: IntArray, usage: Int)
    fun glBufferData(target: Int, size: Long, data: FloatArray, usage: Int)
    fun glBufferSubData(target: Int, offset: Long, size: Long, data: ByteArray)
    fun glBufferSubData(target: Int, offset: Long, size: Long, data: ShortArray)
    fun glBufferSubData(target: Int, offset: Long, size: Long, data: IntArray)
    fun glBufferSubData(target: Int, offset: Long, size: Long, data: FloatArray)
    fun glClear(mask: Int)
    fun glClearColorx(red: Int, green: Int, blue: Int, alpha: Int)
    fun glClearDepthx(depth: Int)
    fun glClearStencil(s: Int)
    fun glClientActiveTexture(texture: Int)
    fun glClipPlanex(plane: Int, equation: IntArray)
    fun glColor4ub(red: Byte, green: Byte, blue: Byte, alpha: Byte)
    fun glColor4x(red: Int, green: Int, blue: Int, alpha: Int)
    fun glColorMask(red: Int, green: Int, blue: Int, alpha: Int)
    fun glColorPointer(size: Int, type: Int, stride: Int, pointer: Long)
    fun glCompressedTexImage2D(target: Int, level: Int, internalformat: Int, width: Int, height: Int, border: Int, imageSize: Int, data: ByteArray)
    fun glCompressedTexSubImage2D(target: Int, level: Int, xoffset: Int, yoffset: Int, width: Int, height: Int, format: Int, imageSize: Int, data: ByteArray)
    fun glCopyTexImage2D(target: Int, level: Int, internalformat: Int, x: Int, y: Int, width: Int, height: Int, border: Int)
    fun glCopyTexSubImage2D(target: Int, level: Int, xoffset: Int, yoffset: Int, x: Int, y: Int, width: Int, height: Int)
    fun glCullFace(mode: Int)
    fun glDeleteBuffers(n: Int, buffers: IntArray)
    fun glDeleteTextures(n: Int, textures: IntArray)
    fun glDepthFunc(func: Int)
    fun glDepthMask(flag: Int)
    fun glDepthRangex(n: Int, f: Int)
    fun glDisable(cap: Int)
    fun glDisableClientState(array: Int)
    fun glDrawArrays(mode: Int, first: Int, count: Int)
    fun glDrawElements(mode: Int, count: Int, type: Int, indices: Long)
    fun glEnable(cap: Int)
    fun glEnableClientState(array: Int)
    fun glFinish()
    fun glFlush()
    fun glFogx(pname: Int, param: Int)
    fun glFogxv(pname: Int, param: IntArray)
    fun glFrontFace(mode: Int)
    fun glFrustumx(l: Int, r: Int, b: Int, t: Int, n: Int, f: Int)
    fun glGetBooleanv(pname: Int, data: IntArray)
    fun glGetBufferParameteriv(target: Int, pname: Int, params: IntArray)
    fun glGetClipPlanex(plane: Int, equation: IntArray)
    fun glGenBuffers(n: Int, buffers: IntArray)
    fun glGenTextures(n: Int, textures: IntArray)
    fun glGetError(): Int
    fun glGetFixedv(pname: Int, params: IntArray)
    fun glGetIntegerv(pname: Int, data: IntArray)
    fun glGetLightxv(light: Int, pname: Int, params: IntArray)
    fun glGetMaterialxv(face: Int, pname: Int, params: IntArray)
    // fun glGetPointerv(pname: Int, params: Long) TODO: implement this
    fun glGetString(name: Int): String
    fun glGetTexEnviv(target: Int, pname: Int, params: IntArray)
    fun glGetTexEnvxv(target: Int, pname: Int, params: IntArray)
    fun glGetTexParameteriv(target: Int, pname: Int, params: IntArray)
    fun glGetTexParameterxv(target: Int, pname: Int, params: IntArray)
    fun glHint(target: Int, mode: Int)
    fun glIsBuffer(buffer: Int): Int
    fun glIsEnabled(cap: Int): Int
    fun glIsTexture(texture: Int): Int
    fun glLightModelx(pname: Int, param: Int)
    fun glLightModelxv(pname: Int, param: IntArray)
    fun glLightx(light: Int, pname: Int, param: Int)
    fun glLightxv(light: Int, pname: Int, params: IntArray)
    fun glLineWidthx(width: Int)
    fun glLoadIdentity()
    fun glLoadMatrixx(m: IntArray)
    fun glLogicOp(opcode: Int)
    fun glMaterialx(face: Int, pname: Int, param: Int)
    fun glMaterialxv(face: Int, pname: Int, param: IntArray)
    fun glMatrixMode(mode: Int)
    fun glMultMatrixx(m: IntArray)
    fun glMultiTexCoord4x(texture: Int, s: Int, t: Int, r: Int, q: Int)
    fun glNormal3x(nx: Int, ny: Int, nz: Int)
    fun glNormalPointer(type: Int, stride: Int, pointer: Long)
    fun glOrthox(l: Int, r: Int, b: Int, t: Int, n: Int, f: Int)
    fun glPixelStorei(pname: Int, param: Int)
    fun glPointParameterx(pname: Int, param: Int)
    fun glPointParameterxv(pname: Int, params: IntArray)
    fun glPointSizex(size: Int)
    fun glPolygonOffsetx(factor: Int, units: Int)
    fun glPopMatrix()
    fun glPushMatrix()
    fun glReadPixels(x: Int, y: Int, width: Int, height: Int, format: Int, type: Int, pixels: ByteArray)
    fun glReadPixels(x: Int, y: Int, width: Int, height: Int, format: Int, type: Int, pixels: IntArray)
    fun glRotatex(angle: Int, x: Int, y: Int, z: Int)
    fun glSampleCoverage(value: Float, invert: Int)
    fun glSampleCoveragex(value: Int, invert: Int)
    fun glScalex(x: Int, y: Int, z: Int)
    fun glScissor(x: Int, y: Int, width: Int, height: Int)
    fun glShadeModel(mode: Int)
    fun glStencilFunc(func: Int, ref: Int, mask: Int)
    fun glStencilMask(mask: Int)
    fun glStencilOp(fail: Int, zfail: Int, zpass: Int)
    fun glTexCoordPointer(size: Int, type: Int, stride: Int, pointer: Long)
    fun glTexEnvi(target: Int, pname: Int, param: Int)
    fun glTexEnvx(target: Int, pname: Int, param: Int)
    fun glTexEnviv(target: Int, pname: Int, params: IntArray)
    fun glTexEnvxv(target: Int, pname: Int, params: IntArray)
    fun glTexImage2D(target: Int, level: Int, internalformat: Int, width: Int, height: Int, border: Int, format: Int, type: Int, pixels: ByteArray)
    fun glTexImage2D(target: Int, level: Int, internalformat: Int, width: Int, height: Int, border: Int, format: Int, type: Int, pixels: IntArray)
    fun glTexParameteri(target: Int, pname: Int, param: Int)
    fun glTexParameterx(target: Int, pname: Int, param: Int)
    fun glTexParameteriv(target: Int, pname: Int, params: IntArray)
    fun glTexParameterxv(target: Int, pname: Int, params: IntArray)
    fun glTexSubImage2D(target: Int, level: Int, xoffset: Int, yoffset: Int, width: Int, height: Int, format: Int, type: Int, pixels: ByteArray)
    fun glTexSubImage2D(target: Int, level: Int, xoffset: Int, yoffset: Int, width: Int, height: Int, format: Int, type: Int, pixels: IntArray)
    fun glTranslatex(x: Int, y: Int, z: Int)
    fun glVertexPointer(size: Int, type: Int, stride: Int, pointer: Long)
    fun glViewport(x: Int, y: Int, width: Int, height: Int)
    // @formatter:on
}
