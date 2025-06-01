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
}