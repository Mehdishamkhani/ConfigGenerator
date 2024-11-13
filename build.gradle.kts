plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
     signing
}

kotlin {}

gradlePlugin {
    vcsUrl = "https://github.com/Mehdishamkhani/ConfigGenerator/"
    website = "https://github.com/Mehdishamkhani/ConfigGenerator/"
    plugins {
        register("configGenerator") {
            id = "config.generator.plugin-multiplatform"
            implementationClass = "config.generator.plugin.ConfigGeneratorPlugin"
            displayName = "MultiPlatform Config Generator Plugin "
            description =
                "A Gradle plugin to generate a Kotlin object within desired properties for using in  KMP project configurations\n @MehdiShamkhani"
            tags = listOf("KMP", "kotlin-multiplatform", "build-config", "config-generator")
        }
    }
}


repositories {
    mavenCentral()
    gradlePluginPortal()
}





