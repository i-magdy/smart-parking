pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Smart_Parking"
include(":androidApp")
include(":shared")
include(":ui")
include(":feature:login")
include(":core:data")
include(":core:model")
include(":core:common")
