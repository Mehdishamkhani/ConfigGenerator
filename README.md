<h1> MultiPlatform Config Generator Plugin  </h1>
<h3>A Gradle plugin to generate a Kotlin object within desired properties for using in  KMP project configurations</h3>
<p>
  Android's native BuildConfig cannot be used in other KMP platforms source code (web, iOS, desktop). This plugin generates a reusable Kotlin object, allowing you to define configuration properties that can be accessed across all KMP platforms
</p>
<h4>1.Add plugin into your project (setting.gradle) </h4>
<code>includeBuild("ConfigGenerator")</code>
  </br>  </br>
<h4>2.Apply it in plugin section in module-level build.gradle</p>
<code>id("config.generator.plugin-multiplatform")</code>
    </br>  </br>
<h4>3.Add your config fields to your module's build.gradle file</p>
<code>multiPlatformConfig {
    configDirectory("$projectDir/src/commonMain/kotlin/")
    field("APP_VERSION", "String", "1.0.0")
    field("API_URL", "String", "https://github.com")
}</code>
  </br>  </br>
<p>The plugin generates a Kotlin object with your defined fields, providing accessible configuration properties for all KMP supported platforms.</p>
<h4>output:</h4>
<code>
object Config{
    const val APP_VERSION : String = "1.0.0"
    const val API_URL : String = "https://github.com"
}
</code>
</br></br>
<h3>configDirectory("output/file/path")</h3>
<p>generate output file in given path</p>
