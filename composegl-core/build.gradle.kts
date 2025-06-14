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

import dev.karmakrafts.conventions.GitLabCI
import dev.karmakrafts.conventions.apache2License
import dev.karmakrafts.conventions.configureJava
import dev.karmakrafts.conventions.setProjectInfo
import dev.karmakrafts.conventions.setRepository
import dev.karmakrafts.conventions.signPublications
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.konan.target.Family
import java.time.ZonedDateTime

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose)
    alias(libs.plugins.dokka)
    alias(libs.plugins.introspekt)
    signing
    `maven-publish`
}

configureJava(rootProject.libs.versions.java)

val lwjglPlatforms: Array<String> = arrayOf("linux", "linux-arm64", "macos", "macos-arm64", "windows")

fun Provider<MinimalExternalModuleDependency>.withVariant(variant: String): String {
    val dependency = get()
    return "${dependency.module}:${dependency.version}:$variant"
}

kotlin {
    compilerOptions {
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }
    jvm()
    androidTarget {
        publishLibraryVariants("release")
    }
    macosX64()
    macosArm64()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    js {
        browser()
    }
    applyDefaultHierarchyTemplate()
    targets.withType<KotlinNativeTarget>().filter { it.konanTarget.family == Family.IOS }.forEach { target ->
        target.apply {
            compilations {
                val main by getting {
                    cinterops {
                        val MetalANGLE by creating
                    }
                }
            }
        }
    }
    sourceSets {
        commonMain {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.ui)
                api(compose.material3)
                api(libs.introspekt.runtime)
                api(libs.kotlinx.io)
                implementation(libs.skiko)
                implementation(libs.annotations)
            }
        }
        jvmMain {
            dependencies {
                api(compose.desktop.currentOs)
                api(libs.lwjgl)
                api(libs.lwjgl.opengl)
                implementation(libs.lwjgl.jawt)
                val lwjglxModule = libs.lwjglx.awt.get()
                implementation("${lwjglxModule.module}:${lwjglxModule.version}") { isTransitive = false }
                for (platform in lwjglPlatforms) {
                    val variant = "natives-$platform"
                    implementation(libs.lwjgl.asProvider().withVariant(variant))
                    implementation(libs.lwjgl.opengl.withVariant(variant))
                }
            }
        }
    }
}

dokka {
    moduleName = project.name
    pluginsConfiguration {
        html {
            footerMessage = "(c) ${ZonedDateTime.now().year} Karma Krafts & associates"
        }
    }
}

val dokkaJar by tasks.registering(Jar::class) {
    dependsOn(tasks.dokkaGeneratePublicationHtml)
    from(tasks.dokkaGeneratePublicationHtml.flatMap { it.outputDirectory })
    archiveClassifier.set("javadoc")
}

tasks {
    System.getProperty("publishDocs.root")?.let { docsDir ->
        register("publishDocs", Copy::class) {
            dependsOn(dokkaJar)
            mustRunAfter(dokkaJar)
            from(zipTree(dokkaJar.get().outputs.files.first()))
            into(docsDir)
        }
    }
}

android {
    namespace = "$group.${rootProject.name}"
    compileSdk = libs.versions.androidCompileSDK.get().toInt()
    defaultConfig {
        minSdk = libs.versions.androidMinimalSDK.get().toInt()
    }
}

publishing {
    publications.withType<MavenPublication> {
        artifact(dokkaJar)
    }
    setProjectInfo(
        rootProject.name,
        "A GLCanvas composable for hardware accelerated rendering in Compose Multiplatform."
    )
    apache2License()
    setRepository("github.com/karmakrafts/ComposeGL")
    with(GitLabCI) { karmaKraftsDefaults() }
}

signing {
    signPublications()
}