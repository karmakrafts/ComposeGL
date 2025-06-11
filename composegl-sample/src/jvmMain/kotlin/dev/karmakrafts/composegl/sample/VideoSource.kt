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
import kotlinx.io.Buffer
import org.bytedeco.javacv.FFmpegFrameGrabber
import org.bytedeco.javacv.Java2DFrameConverter
import java.awt.image.BufferedImage
import java.awt.image.DataBufferByte
import java.io.File

internal object DemoVideoSource : VideoSource {
    private val frameGrabber: FFmpegFrameGrabber = FFmpegFrameGrabber(File("demo_720.mov"))
    private val frameConverter: Java2DFrameConverter = Java2DFrameConverter()
    private val buffer: Buffer = Buffer()

    override val frameCount: Long
        get() = frameGrabber.lengthInFrames.toLong()
    override val frameIndex: Long
        get() = frameGrabber.frameNumber.toLong()

    init {
        println("Created video source")
        frameGrabber.start(true)
    }

    private fun writeImageToBuffer(image: BufferedImage) {
        require(image.type == BufferedImage.TYPE_3BYTE_BGR) {
            "Image must be of type TYPE_3BYTE_BGR"
        }
        buffer.clear()
        val pixelCount = image.width * image.height
        val bgrData = (image.raster.dataBuffer as DataBufferByte).data
        var componentIndex = 0 // Index in the BGR byte array
        for (pixelIndex in 0..<pixelCount) {
            val b = bgrData[componentIndex++].toInt() and 0xFF
            val g = bgrData[componentIndex++].toInt() and 0xFF
            val r = bgrData[componentIndex++].toInt() and 0xFF
            // Pack into RGBA as 0xRRGGBBAA
            buffer.writeInt((r shl 24) or (g shl 16) or (b shl 8) or 0xFF)
        }
    }

    override fun nextFrame(impl: GLES20, texture: Texture) = with(impl) {
        val frame = frameGrabber.grabImage()
        val frameImage = frameConverter.convert(frame)
        writeImageToBuffer(frameImage)
        texture.upload(frameImage.width, frameImage.height, buffer)
    }

    override fun seek(frameIndex: Long) {
        frameGrabber.setVideoFrameNumber(frameIndex.toInt())
    }

    override fun close() {
        frameGrabber.stop()
        println("Disposed video source")
    }
}