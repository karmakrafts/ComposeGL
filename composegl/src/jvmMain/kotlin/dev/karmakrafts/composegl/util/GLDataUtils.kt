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

package dev.karmakrafts.composegl.util

import org.lwjgl.opengl.awt.GLData

internal fun GLData.copyFrom(data: GLData) {
    doubleBuffer = data.doubleBuffer
    stereo = data.stereo
    redSize = data.redSize
    greenSize = data.greenSize
    blueSize = data.blueSize
    alphaSize = data.alphaSize
    depthSize = data.depthSize
    stencilSize = data.stencilSize
    accumRedSize = data.accumRedSize
    accumGreenSize = data.accumGreenSize
    accumBlueSize = data.accumBlueSize
    accumAlphaSize = data.accumAlphaSize
    sampleBuffers = data.sampleBuffers
    samples = data.samples
    shareContext = data.shareContext
    majorVersion = data.majorVersion
    minorVersion = data.minorVersion
    forwardCompatible = data.forwardCompatible
    profile = data.profile
    api = data.api
    debug = data.debug
    swapInterval = data.swapInterval
    sRGB = data.sRGB
    pixelFormatFloat = data.pixelFormatFloat
    contextReleaseBehavior = data.contextReleaseBehavior
    robustness = data.robustness
    loseContextOnReset = data.loseContextOnReset
    contextResetIsolation = data.contextResetIsolation
}