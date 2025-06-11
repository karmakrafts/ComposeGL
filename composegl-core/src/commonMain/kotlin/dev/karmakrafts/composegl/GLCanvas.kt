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

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DefaultGLCanvasFallbackContent() {
    Text("OpenGL is not supported")
}

/**
 * Uses the refresh rate of the primary display device.
 * This is effectively equivalent to using vertical sync.
 */
const val DEFAULT_REFRESH_RATE: Int = -1

@Composable
expect fun GLCanvas( // @formatter:off
    modifier: Modifier = Modifier,
    onDispose: () -> Unit = {},
    fallbackContent: @Composable () -> Unit = { DefaultGLCanvasFallbackContent() },
    refreshRate: Int = DEFAULT_REFRESH_RATE,
    content: GLRenderScope.() -> Unit
) // @formatter:on