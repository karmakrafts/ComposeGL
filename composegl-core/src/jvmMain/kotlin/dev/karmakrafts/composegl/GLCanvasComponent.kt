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

import dev.karmakrafts.composegl.gles.GLES20
import dev.karmakrafts.composegl.gles.PlatformGLES20
import dev.karmakrafts.composegl.util.copyFrom
import org.lwjgl.opengl.awt.AWTGLCanvas
import org.lwjgl.opengl.awt.GLData
import javax.swing.Timer

internal class GLCanvasComponent( // @formatter:off
    data: GLData,
    private val content: GLRenderScope.() -> Unit
) : AWTGLCanvas(GLData().apply { // @formatter:on
    copyFrom(data)
    swapInterval = -1 // Disable vertical sync in hardware since we can't use it
}) {
    init {
        require(data.swapInterval != null) { "Swap interval must be specified for GL canvas" }
    }

    private var lastWidth: Int = width
    private var lastHeight: Int = height

    // We cannot use vertical sync sadly, so calculate max frame time from swap interval
    private val frameTime: Int = 1000 / data.swapInterval!!
    private val frameTimer: Timer = Timer(frameTime) { render() }

    inner class RenderScope : GLRenderScope, GLES20 by PlatformGLES20 {
        override var width: Int = this@GLCanvasComponent.width
        override var height: Int = this@GLCanvasComponent.height
        override val refreshRate: Int = data.swapInterval!!
        override var refreshRateOverride: Int = refreshRate
            set(value) {
                frameTimer.delay = if (value == GLRenderScope.NO_REFRESH_RATE_OVERRIDE) refreshRate
                else value
            }
    }

    private val renderScope: RenderScope = RenderScope()

    init {
        frameTimer.start()
        GLCanvasManager.addActive(this)
    }

    override fun disposeCanvas() {
        frameTimer.stop()
        GLCanvasManager.removeActive(this)
        super.disposeCanvas()
    }

    private fun onResize() {
        renderScope.width = width
        renderScope.height = height
    }

    override fun initGL() {
        GLCanvasManager.initIfNeeded()
    }

    override fun paintGL() {
        if (lastWidth != width || lastHeight != height) {
            onResize()
            lastWidth = width
            lastHeight = height
        }
        renderScope.content()
        swapBuffers()
    }
}