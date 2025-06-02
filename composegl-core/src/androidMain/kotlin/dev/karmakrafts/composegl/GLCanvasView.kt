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

import android.content.Context
import android.opengl.GLSurfaceView
import dev.karmakrafts.composegl.gles.GLES20
import dev.karmakrafts.composegl.gles.PlatformGLES20
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

internal class GLCanvasView( // @formatter:off
    context: Context,
    content: GLRenderScope.() -> Unit
) : GLSurfaceView(context) { // @formatter:on
    constructor(context: Context) : this(context, {})

    init {
        // GL_RGBA8UI, GL_DEPTH_COMPONENT16, GL_STENCIL_INDEX8
        setEGLConfigChooser(8, 8, 8, 8, 16, 8)
        setRenderer(GLCanvasRenderer(content))
    }
}

internal class GLCanvasRenderer(
    private val content: GLRenderScope.() -> Unit
) : GLSurfaceView.Renderer {
    class RenderScope : GLRenderScope, GLES20 by PlatformGLES20 {
        override var width: Int = 0
        override var height: Int = 0

        override var refreshRateOverride: Int
            get() = GLRenderScope.NO_REFRESH_RATE_OVERRIDE
            set(value) { /* NOOP on Android for now */ }
    }

    private val renderScope: RenderScope = RenderScope()

    override fun onSurfaceCreated(gl: GL10, config: EGLConfig) {}

    override fun onSurfaceChanged(gl: GL10, width: Int, height: Int) {
        renderScope.width = width
        renderScope.height = height
    }

    override fun onDrawFrame(gl: GL10) {
        renderScope.content()
    }
}