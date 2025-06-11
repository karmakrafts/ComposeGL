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

import dev.karmakrafts.composegl.GLRenderScope.Companion.NO_REFRESH_RATE_OVERRIDE
import dev.karmakrafts.composegl.gles.GLES20
import dev.karmakrafts.composegl.pipeline.Resource
import dev.karmakrafts.introspekt.util.SourceLocation

/**
 * A render scope which provides access to the underlying [GLES20] implementation
 * and information about the current viewport.
 * It also provides functions to control the rendering dynamically from within the draw callback.
 */
@GLRenderScopeDsl
interface GLRenderScope : GLES20 {
    companion object {
        /**
         * When assigned to [GLRenderScope.refreshRateOverride],
         * tells the underlying implementation to use the refresh
         * rate of the current display.
         */
        const val NO_REFRESH_RATE_OVERRIDE: Int = -1
    }

    /**
     * The width of the current GL viewport in pixels.
     */
    val width: Int

    /**
     * The height of the current GL viewport in pixels.
     */
    val height: Int

    /**
     * Temporarily override the refresh rate of the current GL render scope in Hertz.
     * This can be used to implement things such as adaptive framerate.
     * **This feature may not have an effect on all platforms due to implementation constraints!**
     */
    var refreshRateOverride: Int

    /**
     * Resets [refreshRateOverride] to [NO_REFRESH_RATE_OVERRIDE].
     */
    fun resetRefreshRate() {
        refreshRateOverride = NO_REFRESH_RATE_OVERRIDE
    }

    /**
     * Memoizes the value created in [factory] between rendered frames.
     * This is ideal for creating resources such as textures and shaders.
     *
     * @param key The source location hash of the value to memoize. Computed at compile time by default.
     * @param onCleanup A callback which is invoked when the render scope which the value was
     *  originally created in is disposed.
     * @param factory A closure to invoke once to create the new value to memoize.
     */
    fun <T> memoize( // @formatter:off
        key: Int = SourceLocation.hereHash(),
        onCleanup: (T) -> Unit = {},
        factory: () -> T
    ): T // @formatter:on

    fun onResize(callback: (width: Int, height: Int) -> Unit)
}