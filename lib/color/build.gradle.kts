import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.jvm)
}


dependencies {
    implementation(libs.androidx.compose.material3)

    implementation(project(":lib:kotlin"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

tasks {
    compileKotlin {
        compilerOptions.jvmTarget = JvmTarget.JVM_21
        compilerOptions.freeCompilerArgs = listOf(
            "-opt-in=kotlin.contracts.ExperimentalContracts",
            "-Xjvm-default=all-compatibility",
        )
    }
    compileTestKotlin {
        compilerOptions.jvmTarget = JvmTarget.JVM_21
    }
}

sourceSets {
    maybeCreate("main").apply {
        java.srcDir("src/main/kotlin")
    }
}

