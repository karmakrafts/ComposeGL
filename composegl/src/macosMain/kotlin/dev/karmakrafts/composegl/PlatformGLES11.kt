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

internal object PlatformGLES11 : GLES11 {
    override val GL_DEPTH_BUFFER_BIT: Int get() = platform.OpenGL.GL_DEPTH_BUFFER_BIT
    override val GL_STENCIL_BUFFER_BIT: Int get() = platform.OpenGL.GL_STENCIL_BUFFER_BIT
    override val GL_COLOR_BUFFER_BIT: Int get() = platform.OpenGL.GL_COLOR_BUFFER_BIT
    override val GL_FALSE: Int get() = platform.OpenGL.GL_FALSE
    override val GL_TRUE: Int get() = platform.OpenGL.GL_TRUE
    override val GL_POINTS: Int get() = platform.OpenGL.GL_POINTS
    override val GL_LINES: Int get() = platform.OpenGL.GL_LINES
    override val GL_LINE_LOOP: Int get() = platform.OpenGL.GL_LINE_LOOP
    override val GL_LINE_STRIP: Int get() = platform.OpenGL.GL_LINE_STRIP
    override val GL_TRIANGLES: Int get() = platform.OpenGL.GL_TRIANGLES
    override val GL_TRIANGLE_STRIP: Int get() = platform.OpenGL.GL_TRIANGLE_STRIP
    override val GL_TRIANGLE_FAN: Int get() = platform.OpenGL.GL_TRIANGLE_FAN
    override val GL_NEVER: Int get() = platform.OpenGL.GL_NEVER
    override val GL_LESS: Int get() = platform.OpenGL.GL_LESS
    override val GL_EQUAL: Int get() = platform.OpenGL.GL_EQUAL
    override val GL_LEQUAL: Int get() = platform.OpenGL.GL_LEQUAL
    override val GL_GREATER: Int get() = platform.OpenGL.GL_GREATER
    override val GL_NOTEQUAL: Int get() = platform.OpenGL.GL_NOTEQUAL
    override val GL_GEQUAL: Int get() = platform.OpenGL.GL_GEQUAL
    override val GL_ALWAYS: Int get() = platform.OpenGL.GL_ALWAYS
    override val GL_ZERO: Int get() = platform.OpenGL.GL_ZERO
    override val GL_ONE: Int get() = platform.OpenGL.GL_ONE
    override val GL_SRC_COLOR: Int get() = platform.OpenGL.GL_SRC_COLOR
    override val GL_ONE_MINUS_SRC_COLOR: Int get() = platform.OpenGL.GL_ONE_MINUS_SRC_COLOR
    override val GL_SRC_ALPHA: Int get() = platform.OpenGL.GL_SRC_ALPHA
    override val GL_ONE_MINUS_SRC_ALPHA: Int get() = platform.OpenGL.GL_ONE_MINUS_SRC_ALPHA
    override val GL_DST_ALPHA: Int get() = platform.OpenGL.GL_DST_ALPHA
    override val GL_ONE_MINUS_DST_ALPHA: Int get() = platform.OpenGL.GL_ONE_MINUS_DST_ALPHA
    override val GL_DST_COLOR: Int get() = platform.OpenGL.GL_DST_COLOR
    override val GL_ONE_MINUS_DST_COLOR: Int get() = platform.OpenGL.GL_ONE_MINUS_DST_COLOR
    override val GL_SRC_ALPHA_SATURATE: Int get() = platform.OpenGL.GL_SRC_ALPHA_SATURATE
    override val GL_FRONT: Int get() = platform.OpenGL.GL_FRONT
    override val GL_BACK: Int get() = platform.OpenGL.GL_BACK
    override val GL_FRONT_AND_BACK: Int get() = platform.OpenGL.GL_FRONT_AND_BACK
    override val GL_TEXTURE_2D: Int get() = platform.OpenGL.GL_TEXTURE_2D
    override val GL_CULL_FACE: Int get() = platform.OpenGL.GL_CULL_FACE
    override val GL_BLEND: Int get() = platform.OpenGL.GL_BLEND
    override val GL_DITHER: Int get() = platform.OpenGL.GL_DITHER
    override val GL_STENCIL_TEST: Int get() = platform.OpenGL.GL_STENCIL_TEST
    override val GL_DEPTH_TEST: Int get() = platform.OpenGL.GL_DEPTH_TEST
    override val GL_SCISSOR_TEST: Int get() = platform.OpenGL.GL_SCISSOR_TEST
    override val GL_SAMPLE_ALPHA_TO_COVERAGE: Int get() = platform.OpenGL.GL_SAMPLE_ALPHA_TO_COVERAGE
    override val GL_SAMPLE_COVERAGE: Int get() = platform.OpenGL.GL_SAMPLE_COVERAGE
    override val GL_NO_ERROR: Int get() = platform.OpenGL.GL_NO_ERROR
    override val GL_INVALID_ENUM: Int get() = platform.OpenGL.GL_INVALID_ENUM
    override val GL_INVALID_VALUE: Int get() = platform.OpenGL.GL_INVALID_VALUE
    override val GL_INVALID_OPERATION: Int get() = platform.OpenGL.GL_INVALID_OPERATION
    override val GL_OUT_OF_MEMORY: Int get() = platform.OpenGL.GL_OUT_OF_MEMORY
    override val GL_CW: Int get() = platform.OpenGL.GL_CW
    override val GL_CCW: Int get() = platform.OpenGL.GL_CCW
    override val GL_LINE_WIDTH: Int get() = platform.OpenGL.GL_LINE_WIDTH
    override val GL_ALIASED_POINT_SIZE_RANGE: Int get() = platform.OpenGL.GL_ALIASED_POINT_SIZE_RANGE
    override val GL_ALIASED_LINE_WIDTH_RANGE: Int get() = platform.OpenGL.GL_ALIASED_LINE_WIDTH_RANGE
    override val GL_CULL_FACE_MODE: Int get() = platform.OpenGL.GL_CULL_FACE_MODE
    override val GL_FRONT_FACE: Int get() = platform.OpenGL.GL_FRONT_FACE
    override val GL_DEPTH_RANGE: Int get() = platform.OpenGL.GL_DEPTH_RANGE
    override val GL_DEPTH_WRITEMASK: Int get() = platform.OpenGL.GL_DEPTH_WRITEMASK
    override val GL_DEPTH_CLEAR_VALUE: Int get() = platform.OpenGL.GL_DEPTH_CLEAR_VALUE
    override val GL_DEPTH_FUNC: Int get() = platform.OpenGL.GL_DEPTH_FUNC
    override val GL_STENCIL_CLEAR_VALUE: Int get() = platform.OpenGL.GL_STENCIL_CLEAR_VALUE
    override val GL_STENCIL_FUNC: Int get() = platform.OpenGL.GL_STENCIL_FUNC
    override val GL_STENCIL_VALUE_MASK: Int get() = platform.OpenGL.GL_STENCIL_VALUE_MASK
    override val GL_STENCIL_FAIL: Int get() = platform.OpenGL.GL_STENCIL_FAIL
    override val GL_STENCIL_PASS_DEPTH_FAIL: Int get() = platform.OpenGL.GL_STENCIL_PASS_DEPTH_FAIL
    override val GL_STENCIL_PASS_DEPTH_PASS: Int get() = platform.OpenGL.GL_STENCIL_PASS_DEPTH_PASS
    override val GL_STENCIL_REF: Int get() = platform.OpenGL.GL_STENCIL_REF
    override val GL_STENCIL_WRITEMASK: Int get() = platform.OpenGL.GL_STENCIL_WRITEMASK
    override val GL_VIEWPORT: Int get() = platform.OpenGL.GL_VIEWPORT
    override val GL_SCISSOR_BOX: Int get() = platform.OpenGL.GL_SCISSOR_BOX
    override val GL_COLOR_CLEAR_VALUE: Int get() = platform.OpenGL.GL_COLOR_CLEAR_VALUE
    override val GL_COLOR_WRITEMASK: Int get() = platform.OpenGL.GL_COLOR_WRITEMASK
    override val GL_MAX_TEXTURE_SIZE: Int get() = platform.OpenGL.GL_MAX_TEXTURE_SIZE
    override val GL_MAX_VIEWPORT_DIMS: Int get() = platform.OpenGL.GL_MAX_VIEWPORT_DIMS
    override val GL_MAX_TEXTURE_UNITS: Int get() = platform.OpenGL.GL_MAX_TEXTURE_UNITS
    override val GL_SUBPIXEL_BITS: Int get() = platform.OpenGL.GL_SUBPIXEL_BITS
    override val GL_RED_BITS: Int get() = platform.OpenGL.GL_RED_BITS
    override val GL_GREEN_BITS: Int get() = platform.OpenGL.GL_GREEN_BITS
    override val GL_BLUE_BITS: Int get() = platform.OpenGL.GL_BLUE_BITS
    override val GL_ALPHA_BITS: Int get() = platform.OpenGL.GL_ALPHA_BITS
    override val GL_DEPTH_BITS: Int get() = platform.OpenGL.GL_DEPTH_BITS
    override val GL_STENCIL_BITS: Int get() = platform.OpenGL.GL_STENCIL_BITS
    override val GL_POLYGON_OFFSET_UNITS: Int get() = platform.OpenGL.GL_POLYGON_OFFSET_UNITS
    override val GL_POLYGON_OFFSET_FILL: Int get() = platform.OpenGL.GL_POLYGON_OFFSET_FILL
    override val GL_POLYGON_OFFSET_FACTOR: Int get() = platform.OpenGL.GL_POLYGON_OFFSET_FACTOR
    override val GL_TEXTURE_BINDING_2D: Int get() = platform.OpenGL.GL_TEXTURE_BINDING_2D
    override val GL_SAMPLE_BUFFERS: Int get() = platform.OpenGL.GL_SAMPLE_BUFFERS
    override val GL_SAMPLES: Int get() = platform.OpenGL.GL_SAMPLES
    override val GL_SAMPLE_COVERAGE_VALUE: Int get() = platform.OpenGL.GL_SAMPLE_COVERAGE_VALUE
    override val GL_SAMPLE_COVERAGE_INVERT: Int get() = platform.OpenGL.GL_SAMPLE_COVERAGE_INVERT
    override val GL_COMPRESSED_TEXTURE_FORMATS: Int get() = platform.OpenGL.GL_COMPRESSED_TEXTURE_FORMATS
    override val GL_DONT_CARE: Int get() = platform.OpenGL.GL_DONT_CARE
    override val GL_FASTEST: Int get() = platform.OpenGL.GL_FASTEST
    override val GL_NICEST: Int get() = platform.OpenGL.GL_NICEST
    override val GL_GENERATE_MIPMAP_HINT: Int get() = platform.OpenGL.GL_GENERATE_MIPMAP_HINT
    override val GL_BYTE: Int get() = platform.OpenGL.GL_BYTE
    override val GL_UNSIGNED_BYTE: Int get() = platform.OpenGL.GL_UNSIGNED_BYTE
    override val GL_SHORT: Int get() = platform.OpenGL.GL_SHORT
    override val GL_UNSIGNED_SHORT: Int get() = platform.OpenGL.GL_UNSIGNED_SHORT
    override val GL_FLOAT: Int get() = platform.OpenGL.GL_FLOAT
    override val GL_INVERT: Int get() = platform.OpenGL.GL_INVERT
    override val GL_TEXTURE: Int get() = platform.OpenGL.GL_TEXTURE
    override val GL_ALPHA: Int get() = platform.OpenGL.GL_ALPHA
    override val GL_RGB: Int get() = platform.OpenGL.GL_RGB
    override val GL_RGBA: Int get() = platform.OpenGL.GL_RGBA
    override val GL_LUMINANCE: Int get() = platform.OpenGL.GL_LUMINANCE
    override val GL_LUMINANCE_ALPHA: Int get() = platform.OpenGL.GL_LUMINANCE_ALPHA
    override val GL_UNPACK_ALIGNMENT: Int get() = platform.OpenGL.GL_UNPACK_ALIGNMENT
    override val GL_PACK_ALIGNMENT: Int get() = platform.OpenGL.GL_PACK_ALIGNMENT
    override val GL_UNSIGNED_SHORT_4_4_4_4: Int get() = platform.OpenGL.GL_UNSIGNED_SHORT_4_4_4_4
    override val GL_UNSIGNED_SHORT_5_5_5_1: Int get() = platform.OpenGL.GL_UNSIGNED_SHORT_5_5_5_1
    override val GL_UNSIGNED_SHORT_5_6_5: Int get() = platform.OpenGL.GL_UNSIGNED_SHORT_5_6_5
    override val GL_KEEP: Int get() = platform.OpenGL.GL_KEEP
    override val GL_REPLACE: Int get() = platform.OpenGL.GL_REPLACE
    override val GL_INCR: Int get() = platform.OpenGL.GL_INCR
    override val GL_DECR: Int get() = platform.OpenGL.GL_DECR
    override val GL_VENDOR: Int get() = platform.OpenGL.GL_VENDOR
    override val GL_RENDERER: Int get() = platform.OpenGL.GL_RENDERER
    override val GL_VERSION: Int get() = platform.OpenGL.GL_VERSION
    override val GL_ADD: Int get() = platform.OpenGL.GL_ADD
    override val GL_NEAREST: Int get() = platform.OpenGL.GL_NEAREST
    override val GL_LINEAR: Int get() = platform.OpenGL.GL_LINEAR
    override val GL_NEAREST_MIPMAP_NEAREST: Int get() = platform.OpenGL.GL_NEAREST_MIPMAP_NEAREST
    override val GL_LINEAR_MIPMAP_NEAREST: Int get() = platform.OpenGL.GL_LINEAR_MIPMAP_NEAREST
    override val GL_NEAREST_MIPMAP_LINEAR: Int get() = platform.OpenGL.GL_NEAREST_MIPMAP_LINEAR
    override val GL_LINEAR_MIPMAP_LINEAR: Int get() = platform.OpenGL.GL_LINEAR_MIPMAP_LINEAR
    override val GL_TEXTURE_MAG_FILTER: Int get() = platform.OpenGL.GL_TEXTURE_MAG_FILTER
    override val GL_TEXTURE_MIN_FILTER: Int get() = platform.OpenGL.GL_TEXTURE_MIN_FILTER
    override val GL_TEXTURE_WRAP_S: Int get() = platform.OpenGL.GL_TEXTURE_WRAP_S
    override val GL_TEXTURE_WRAP_T: Int get() = platform.OpenGL.GL_TEXTURE_WRAP_T
    override val GL_TEXTURE0: Int get() = platform.OpenGL.GL_TEXTURE0
    override val GL_TEXTURE1: Int get() = platform.OpenGL.GL_TEXTURE1
    override val GL_TEXTURE2: Int get() = platform.OpenGL.GL_TEXTURE2
    override val GL_TEXTURE3: Int get() = platform.OpenGL.GL_TEXTURE3
    override val GL_TEXTURE4: Int get() = platform.OpenGL.GL_TEXTURE4
    override val GL_TEXTURE5: Int get() = platform.OpenGL.GL_TEXTURE5
    override val GL_TEXTURE6: Int get() = platform.OpenGL.GL_TEXTURE6
    override val GL_TEXTURE7: Int get() = platform.OpenGL.GL_TEXTURE7
    override val GL_TEXTURE8: Int get() = platform.OpenGL.GL_TEXTURE8
    override val GL_TEXTURE9: Int get() = platform.OpenGL.GL_TEXTURE9
    override val GL_TEXTURE10: Int get() = platform.OpenGL.GL_TEXTURE10
    override val GL_TEXTURE11: Int get() = platform.OpenGL.GL_TEXTURE11
    override val GL_TEXTURE12: Int get() = platform.OpenGL.GL_TEXTURE12
    override val GL_TEXTURE13: Int get() = platform.OpenGL.GL_TEXTURE13
    override val GL_TEXTURE14: Int get() = platform.OpenGL.GL_TEXTURE14
    override val GL_TEXTURE15: Int get() = platform.OpenGL.GL_TEXTURE15
    override val GL_TEXTURE16: Int get() = platform.OpenGL.GL_TEXTURE16
    override val GL_TEXTURE17: Int get() = platform.OpenGL.GL_TEXTURE17
    override val GL_TEXTURE18: Int get() = platform.OpenGL.GL_TEXTURE18
    override val GL_TEXTURE19: Int get() = platform.OpenGL.GL_TEXTURE19
    override val GL_TEXTURE20: Int get() = platform.OpenGL.GL_TEXTURE20
    override val GL_TEXTURE21: Int get() = platform.OpenGL.GL_TEXTURE21
    override val GL_TEXTURE22: Int get() = platform.OpenGL.GL_TEXTURE22
    override val GL_TEXTURE23: Int get() = platform.OpenGL.GL_TEXTURE23
    override val GL_TEXTURE24: Int get() = platform.OpenGL.GL_TEXTURE24
    override val GL_TEXTURE25: Int get() = platform.OpenGL.GL_TEXTURE25
    override val GL_TEXTURE26: Int get() = platform.OpenGL.GL_TEXTURE26
    override val GL_TEXTURE27: Int get() = platform.OpenGL.GL_TEXTURE27
    override val GL_TEXTURE28: Int get() = platform.OpenGL.GL_TEXTURE28
    override val GL_TEXTURE29: Int get() = platform.OpenGL.GL_TEXTURE29
    override val GL_TEXTURE30: Int get() = platform.OpenGL.GL_TEXTURE30
    override val GL_TEXTURE31: Int get() = platform.OpenGL.GL_TEXTURE31
    override val GL_ACTIVE_TEXTURE: Int get() = platform.OpenGL.GL_ACTIVE_TEXTURE
    override val GL_REPEAT: Int get() = platform.OpenGL.GL_REPEAT
    override val GL_CLAMP_TO_EDGE: Int get() = platform.OpenGL.GL_CLAMP_TO_EDGE
    override val GL_ARRAY_BUFFER: Int get() = platform.OpenGL.GL_ARRAY_BUFFER
    override val GL_ELEMENT_ARRAY_BUFFER: Int get() = platform.OpenGL.GL_ELEMENT_ARRAY_BUFFER
    override val GL_ARRAY_BUFFER_BINDING: Int get() = platform.OpenGL.GL_ARRAY_BUFFER_BINDING
    override val GL_ELEMENT_ARRAY_BUFFER_BINDING: Int get() = platform.OpenGL.GL_ELEMENT_ARRAY_BUFFER_BINDING
    override val GL_STATIC_DRAW: Int get() = platform.OpenGL.GL_STATIC_DRAW
    override val GL_DYNAMIC_DRAW: Int get() = platform.OpenGL.GL_DYNAMIC_DRAW
    override val GL_BUFFER_SIZE: Int get() = platform.OpenGL.GL_BUFFER_SIZE
    override val GL_BUFFER_USAGE: Int get() = platform.OpenGL.GL_BUFFER_USAGE
    override val GL_SUBTRACT: Int get() = platform.OpenGL.GL_SUBTRACT
}