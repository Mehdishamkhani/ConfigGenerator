package config.generator.plugin

import config.generator.plugin.model.ConfigProperty
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.ListProperty
import org.gradle.kotlin.dsl.listProperty
import javax.inject.Inject

open class ConfigExtension @Inject constructor(
    private val objectFactory: ObjectFactory
) {

    internal var directory: String? = null
    internal val configsList: ListProperty<ConfigProperty> =
        objectFactory.listProperty<ConfigProperty>()

    /***
     *  Specify Output Path for Generated Config File
     */
    open fun configDirectory(path: String) {
        this.directory = path
    }

    /**
     * Declare Config properties
     * [name] property name
     * [type] property type (String , Int , Long , Boolean , ... )
     * [value] property value
     */
    open fun field(name: String, type: String, value: String) {
        configsList.add(ConfigProperty(name, type, value))
    }
}