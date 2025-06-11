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

import dev.karmakrafts.composegl.gles.GLES20
import dev.karmakrafts.composegl.pipeline.Texture

interface VideoSource : AutoCloseable {
    val frameCount: Long
    val frameIndex: Long
    fun nextFrame(impl: GLES20, texture: Texture, maxFrameTime: Long)
    fun seek(frameIndex: Long)
    fun hasNextFrame(): Boolean = frameIndex < frameCount - 1
}