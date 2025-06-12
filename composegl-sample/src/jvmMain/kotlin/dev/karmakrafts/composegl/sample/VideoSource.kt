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

import co.touchlab.stately.concurrency.synchronize
import dev.karmakrafts.composegl.gles.GLES20
import dev.karmakrafts.composegl.pipeline.Texture
import kotlinx.io.Buffer
import org.bytedeco.javacv.FFmpegFrameGrabber
import org.bytedeco.javacv.Java2DFrameConverter
import java.awt.image.BufferedImage
import java.awt.image.DataBufferByte
import java.io.File
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.TimeUnit
import kotlin.concurrent.atomics.AtomicBoolean
import kotlin.concurrent.atomics.ExperimentalAtomicApi

private data class FrameData(
    val width: Int, val height: Int, val data: IntArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as FrameData

        if (width != other.width) return false
        if (height != other.height) return false
        if (!data.contentEquals(other.data)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = width
        result = 31 * result + height
        result = 31 * result + data.contentHashCode()
        return result
    }
}

@OptIn(ExperimentalAtomicApi::class)
internal object DemoVideoSource : VideoSource {
    private val frameGrabber: FFmpegFrameGrabber = FFmpegFrameGrabber(File("demo.mp4"))
    private val frameGrabberMutex: Any = Any()

    private val buffer: Buffer = Buffer()
    private val frameQueue: LinkedBlockingQueue<FrameData> = LinkedBlockingQueue()

    override val frameCount: Long
        get() = frameGrabberMutex.synchronize { frameGrabber.lengthInFrames.toLong() }
    override val frameIndex: Long
        get() = frameGrabberMutex.synchronize { frameGrabber.frameNumber.toLong() }

    private val isRunning: AtomicBoolean = AtomicBoolean(true)

    private val frameGrabberThread: Thread = Thread {
        val frameConverter = Java2DFrameConverter()
        frameGrabber.start(true)
        while (isRunning.load()) {
            // We want to buffer ahead a max of 2 frames
            while (isRunning.load() && frameQueue.size >= 10) Thread.sleep(1)
            val frame = frameGrabberMutex.synchronize { frameGrabber.grabImage() }
            val frameImage = frameConverter.convert(frame)
            frameQueue.put(FrameData(frameImage.width, frameImage.height, swizzleImage(frameImage)))
        }
        frameGrabber.stop()
    }

    init {
        println("Created video source")
        frameGrabberThread.start()
    }

    private fun swizzleImage(image: BufferedImage): IntArray {
        require(image.type == BufferedImage.TYPE_3BYTE_BGR) {
            "Image must be of type TYPE_3BYTE_BGR"
        }
        val pixelCount = image.width * image.height
        val bgrData = (image.raster.dataBuffer as DataBufferByte).data
        var componentIndex = 0 // Index in the BGR byte array
        val data = IntArray(pixelCount)
        for (pixelIndex in 0..<pixelCount) {
            val b = bgrData[componentIndex++].toInt() and 0xFF
            val g = bgrData[componentIndex++].toInt() and 0xFF
            val r = bgrData[componentIndex++].toInt() and 0xFF
            // Pack into RGBA as 0xRRGGBBAA
            data[pixelIndex] = (r shl 24) or (g shl 16) or (b shl 8) or 0xFF
        }
        return data
    }

    override fun nextFrame(impl: GLES20, texture: Texture, maxFrameTime: Long) = with(impl) {
        val (width, height, data) = frameQueue.poll(maxFrameTime, TimeUnit.MILLISECONDS) ?: return@with
        buffer.clear()
        for (value in data) buffer.writeInt(value)
        texture.upload(width, height, buffer)
    }

    override fun seek(frameIndex: Long) {
        frameGrabberMutex.synchronize {
            frameGrabber.setVideoFrameNumber(frameIndex.toInt())
        }
    }

    override fun close() {
        isRunning.store(false)
        frameGrabberThread.join()
        println("Disposed video source")
    }
}