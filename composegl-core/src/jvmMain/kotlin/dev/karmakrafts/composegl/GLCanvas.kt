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

@file:JvmName("GLCanvasImpl")

package dev.karmakrafts.composegl

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.SwingPanel
import java.awt.DisplayMode

private const val FALLBACK_REFRESH_RATE: Int = 30

@Composable
actual fun GLCanvas(
    modifier: Modifier,
    onDispose: () -> Unit,
    fallbackContent: @Composable () -> Unit,
    refreshRate: Int,
    content: GLRenderScope.() -> Unit
) {
    if (!OpenGLSupported.current) {
        fallbackContent()
        return
    }
    val window = WindowInstance.current!!
    SwingPanel( // @formatter:off
        modifier = modifier,
        factory = {
            val displayMode = window.graphicsConfiguration.device.displayMode
            val actualRefreshRate = when (refreshRate) {
                DEFAULT_REFRESH_RATE -> when (val currentRefreshRate = displayMode.refreshRate) {
                    DisplayMode.REFRESH_RATE_UNKNOWN -> FALLBACK_REFRESH_RATE
                    else -> currentRefreshRate
                }
                else -> refreshRate
            }
            GLCanvasManager.create(actualRefreshRate) {
                content()
            }
        }
    ) // @formatter:on
}