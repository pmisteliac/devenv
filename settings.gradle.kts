import mb.gradle.config.devenv.DevenvSettingsExtension

rootProject.name = "devenv"

// Make plugin repositories available, for loading plugins in included builds.
pluginManagement {
  repositories {
    maven(url = "https://artifacts.metaborg.org/content/repositories/releases/")
    maven(url = "https://artifacts.metaborg.org/content/repositories/snapshots/")
    gradlePluginPortal()
  }
}

// Apply devenv-settings plugin. Settings plugins must still be put on the classpath via a buildscript block.
buildscript {
  repositories {
    maven(url = "https://artifacts.metaborg.org/content/repositories/releases/")
    maven(url = "https://artifacts.metaborg.org/content/repositories/snapshots/")
    gradlePluginPortal()
  }
  dependencies {
    classpath("org.metaborg:gradle.config:0.3.8")
  }
}
apply(plugin = "org.metaborg.gradle.config.devenv-settings")

// Include builds from subdirectories, but only if it is from an included repository.
configure<DevenvSettingsExtension> {
  includeBuildsFromSubDirs(true)
}
