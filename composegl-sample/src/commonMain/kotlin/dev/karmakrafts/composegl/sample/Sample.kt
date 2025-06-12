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

package dev.karmakrafts.composegl.sample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import dev.karmakrafts.composegl.GLCanvas
import dev.karmakrafts.composegl.pipeline.IndexBufferBuilder.Companion.indexBuffer
import dev.karmakrafts.composegl.pipeline.IndexFormat
import dev.karmakrafts.composegl.pipeline.Pipeline.Companion.pipeline
import dev.karmakrafts.composegl.pipeline.Resource
import dev.karmakrafts.composegl.pipeline.Shader.Companion.shader
import dev.karmakrafts.composegl.pipeline.ShaderProgram.Companion.shaderProgram
import dev.karmakrafts.composegl.pipeline.ShaderStage
import dev.karmakrafts.composegl.pipeline.Texture.Companion.texture
import dev.karmakrafts.composegl.pipeline.TextureFilter
import dev.karmakrafts.composegl.pipeline.TextureFormat
import dev.karmakrafts.composegl.pipeline.VertexBufferBuilder.Companion.vertexBuffer
import dev.karmakrafts.composegl.pipeline.VertexFormat
import dev.karmakrafts.composegl.pipeline.VertexFormatElement
import dev.karmakrafts.composegl.pipeline.VertexFormatElementType
import org.intellij.lang.annotations.Language

@Language("glsl")
private const val vertexShader: String = """
#version 410
    
in vec2 in_position;
in vec2 in_uv;
in vec4 in_color;

out vec2 v_uv;
out vec4 v_color;

void main(void) {
    gl_Position = vec4(vec3(in_position, 0.0), 1.0);
    v_uv = in_uv;
    v_color = in_color;
}
"""

@Language("glsl")
private const val fragmentShader: String = """
#version 410
    
uniform sampler2D u_texture;

in vec2 v_uv;
in vec4 v_color;

out vec4 out_color;
    
void main(void) {
    out_color = (texture(u_texture, v_uv) * 0.5) + (v_color * 0.5);
}
"""

@Composable
fun Sample(videoSource: VideoSource) {
    Column {
        Text( // @formatter:off
            text = "OpenGL in Compose Demo",
            fontSize = 20.sp
        ) // @formatter:on
        GLCanvas( // @formatter:off
            modifier = Modifier.fillMaxSize(),
            refreshRate = 30 // Our video plays at 30FPS
        ) { // @formatter:on
            onResize { width, height -> glViewport(0, 0, width, height) }
            glEnable(GL_TEXTURE_2D)

            val pipeline = memoize(onCleanup = Resource::dispose) {
                val vertexFormat = VertexFormat(
                    VertexFormatElement(VertexFormatElementType.FLOAT_2, "in_position"),
                    VertexFormatElement(VertexFormatElementType.FLOAT_2, "in_uv"),
                    VertexFormatElement(VertexFormatElementType.FLOAT_4, "in_color")
                )
                pipeline( // @formatter:off
                    vbo = vertexBuffer {
                        format = vertexFormat
                        // Top left
                        write(-1F, 1F)
                        write(0F, 0F)
                        write(1F, 0F, 0F, 1F)
                        // Bottom left
                        write(-1F, -1F)
                        write(0F, 1F)
                        write(0F, 1F, 0F, 1F)
                        // Bottom right
                        write(1F, -1F)
                        write(1F, 1F)
                        write(0F, 0F, 1F, 1F)
                        // Top right
                        write(1F, 1F)
                        write(1F, 0F)
                        write(1F, 1F, 1F, 1F)
                    },
                    ibo = indexBuffer {
                        format = IndexFormat.UBYTE
                        write(0U.toUByte(), 1U.toUByte(), 2U.toUByte())
                        write(0U.toUByte(), 2U.toUByte(), 3U.toUByte())
                    },
                    program = shaderProgram(
                        vertexFormat,
                        shader(ShaderStage.VERTEX, vertexShader),
                        shader(ShaderStage.FRAGMENT, fragmentShader)
                    )
                ) // @formatter:on
            }

            val texture = memoize(onCleanup = Resource::dispose) {
                texture( // @formatter:off
                    format = TextureFormat.RGBA_8UI,
                    minFilter = TextureFilter.LINEAR,
                    magFilter = TextureFilter.LINEAR
                ) // @formatter:on
            }

            glClearColor(0F, 0F, 0F, 1F)
            glClear(GL_COLOR_BUFFER_BIT or GL_DEPTH_BUFFER_BIT or GL_STENCIL_BUFFER_BIT)

            glActiveTexture(GL_TEXTURE0) // We only use texture unit 0
            texture.bind()
            pipeline.program.uniform1i("u_texture", 0) // Sampler uses texture unit 0
            pipeline.draw(GL_TRIANGLES)
            texture.unbind()

            if (!videoSource.hasNextFrame()) {
                videoSource.seek(0L) // Loop to beginning
            }
            videoSource.nextFrame(this, texture, 33)

            glDisable(GL_TEXTURE_2D)
        }
    }
}