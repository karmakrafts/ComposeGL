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

import dev.karmakrafts.composegl.util.copyFrom
import org.lwjgl.opengl.GL
import org.lwjgl.opengl.GLCapabilities
import org.lwjgl.opengl.awt.GLData
import org.lwjgl.system.Platform

internal object GLCanvasManager {
    private var isInitialized: Boolean = false
    private val canvases: ArrayList<GLCanvasComponent> = ArrayList()
    lateinit var capabilities: GLCapabilities
        private set

    private val defaultConfig: GLData = GLData().apply {
        profile = when(Platform.get()) {
            Platform.LINUX -> GLData.Profile.COMPATIBILITY
            else -> GLData.Profile.CORE
        }
        api = GLData.API.GL
        forwardCompatible = true
        majorVersion = 4
        minorVersion = 1
        doubleBuffer = true
        swapInterval = -1 // We already disable this later on, but it can't hurt to prevent confusion
        // GL_RGBA8UI, GL_DEPTH_COMPONENT16, GL_STENCIL_INDEX8
        redSize = 8
        greenSize = 8
        blueSize = 8
        alphaSize = 8
        depthSize = 16
        stencilSize = 8
        pixelFormatFloat = false
    }

    fun addActive(canvas: GLCanvasComponent) {
        check(canvas !in canvases) { "Canvas $canvas already exists" }
        canvases += canvas
    }

    fun removeActive(canvas: GLCanvasComponent) {
        check(canvas in canvases) { "Canvas $canvas does not exist" }
        canvases -= canvas
    }

    fun requestGL() {
        //System.setProperty("skiko.renderApi", "OPENGL")
    }

    fun initIfNeeded() {
        if (isInitialized) return
        capabilities = GL.createCapabilities()
        isInitialized = true
    }

    fun create( // @formatter:off
        refreshRate: Int,
        content: GLRenderScope.() -> Unit
    ): GLCanvasComponent = GLCanvasComponent(GLData().apply { // @formatter:on
        copyFrom(defaultConfig)
        swapInterval = refreshRate
        shareContext = canvases.firstOrNull()
    }, content)
}