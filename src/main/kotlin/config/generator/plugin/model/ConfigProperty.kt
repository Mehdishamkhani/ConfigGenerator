package config.generator.plugin.model

import java.io.Serializable

internal data class ConfigProperty(val name: String, val type: String, val value: String) :
    Serializable