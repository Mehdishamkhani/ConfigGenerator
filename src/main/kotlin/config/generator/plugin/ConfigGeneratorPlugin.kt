package config.generator.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 *
 */
internal class ConfigGeneratorPlugin : Plugin<Project> {

    private val extensionName: String = "multiPlatformConfig"
    private val generateConfigTaskName: String = "multiPlatformConfigGenerator"
    private val defaultDirectory: String = "build/generated/source/$extensionName/"
    private val pluginPackagePath: String = "/config/generator/plugin/"

    override fun apply(project: Project) {
        val extension = project.extensions.create(extensionName, ConfigExtension::class.java)
        val task = project.tasks.register(generateConfigTaskName, GenerateConfigTask::class.java) {
            outputDir.set(
                project.file(
                    "${extension.directory ?: defaultDirectory}${pluginPackagePath}"
                )
            )
        }
        project.afterEvaluate {
            task.configure {
                properties.addAll(extension.configsList)
            }
        }
    }
}