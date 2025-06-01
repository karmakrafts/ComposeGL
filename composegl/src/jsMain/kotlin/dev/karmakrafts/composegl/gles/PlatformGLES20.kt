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
}