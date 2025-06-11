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

abstract class AbstractGLRenderScope : GLRenderScope {
    internal val memoizedValues: HashMap<Int, Pair<Any?, (Any?) -> Unit>> = HashMap()
    private var lastWidth: Int = width
    private var lastHeight: Int = height

    internal fun cleanup() {
        for ((value, cleanCallback) in memoizedValues.values) {
            cleanCallback(value)
        }
        memoizedValues.clear()
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : Any?> memoize( // @formatter:off
        key: Int,
        onCleanup: (T) -> Unit,
        factory: () -> T
    ): T { // @formatter:on
        var entry = memoizedValues[key]
        if (entry == null) {
            entry = Pair<Any?, (Any?) -> Unit>(factory(), onCleanup as (Any?) -> Unit)
            memoizedValues[key] = entry
        }
        val (value, _) = entry
        return value as T
    }

    override fun onResize(callback: (Int, Int) -> Unit) {
        if (width != lastWidth || height != lastHeight) {
            callback(width, height)
            lastWidth = width
            lastHeight = height
        }
    }
}