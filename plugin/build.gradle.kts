plugins {
    kotlin("jvm") version "1.7.22"
    `java-gradle-plugin`
    `maven-publish`
}

group = "com.javiersc.repro-gradle-dsl"
version = "0.1.0"

gradlePlugin {
    plugins {
        create("com.javiersc.repro.plugin") {
            id = "com.javiersc.repro.plugin"
            implementationClass = "com.javiersc.repro.plugin.ReproPlugin"
        }
    }
}

dependencies {
    implementation(gradleApi())
    implementation(gradleKotlinDsl())
}
