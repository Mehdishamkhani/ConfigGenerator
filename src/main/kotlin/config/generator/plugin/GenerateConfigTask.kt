package config.generator.plugin

import config.generator.plugin.model.ConfigProperty
import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.ListProperty
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.File

/**
 *
 */
internal abstract class GenerateConfigTask : DefaultTask() {

    @get:OutputDirectory
    internal abstract val outputDir: DirectoryProperty

    @get:Input
    internal abstract val properties: ListProperty<ConfigProperty>

    private val generatedObjectName: String = "Config"
    private val generatedFileExtension: String = ".kt"
    private val pluginPackage: String = "config.generator.plugin"

    @TaskAction
    fun generate() {
        val outputFileDirectory = outputDir.get().asFile
        outputFileDirectory.mkdirs()
        val properties = properties.getOrElse(emptyList())
        val objectBody = buildString {
            appendLine("package $pluginPackage")
            appendLine("")
            appendLine("object $generatedObjectName { ")
            properties.forEach { property ->
                val value =
                    if (property.type == "String") "\"${property.value}\"" else property.value
                appendLine("    const val ${property.name.uppercase()}: ${property.type} = $value")
            }
            appendLine("}")
        }
        val outputFile = File(outputFileDirectory, "$generatedObjectName$generatedFileExtension")
        outputFile.writeText(objectBody)
    }
}


