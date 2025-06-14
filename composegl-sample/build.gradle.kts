/*
 * Copyright 2025 Karma Krafts & associates
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

import dev.karmakrafts.conventions.configureJava
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    //alias(libs.plugins.android.application)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose)
    alias(libs.plugins.introspekt)
}

configureJava(rootProject.libs.versions.java)

kotlin {
    jvm()
    //androidTarget()
    //macosX64()
    //macosArm64()
    //iosX64()
    //iosArm64()
    //iosSimulatorArm64()
    //js {
    //    browser()
    //}
    applyDefaultHierarchyTemplate()
    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.composeglCore)
            }
        }
        jvmMain {
            dependencies {
                implementation(compose.desktop.currentOs)
                implementation(libs.javacv)
                implementation(libs.javacv.platform)
            }
        }
    }
}

//android {
//    namespace = "$group.${rootProject.name}"
//    compileSdk = libs.versions.androidCompileSDK.get().toInt()
//    defaultConfig {
//        minSdk = libs.versions.androidMinimalSDK.get().toInt()
//    }
//}

compose {
    desktop {
        application {
            mainClass = "$group.sample.MainKt"
            nativeDistributions {
                packageVersion = rootProject.version.toString().substringBeforeLast('.')
                targetFormats(TargetFormat.Deb)
            }
        }
    }
}