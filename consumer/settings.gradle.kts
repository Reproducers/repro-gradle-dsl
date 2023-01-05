rootProject.name = "consumer"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        mavenLocal {
            content {
                includeGroup("com.javiersc.repro.plugin")
                includeGroup("com.javiersc.repro-gradle-dsl")
            }
        }
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        mavenLocal {
            content {
                includeGroup("com.javiersc.repro.plugin")
                includeGroup("com.javiersc.repro-gradle-dsl")
            }
        }
    }
}
