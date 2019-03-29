import mb.gradle.config.devenv.DevenvSettingsExtension

rootProject.name = "devenv"

// Apply devenv-settings plugin. Settings plugins must still be put on the classpath via a buildscript block.
buildscript {
  repositories {
    maven(url = "https://artifacts.metaborg.org/content/repositories/releases/")
    maven(url = "https://artifacts.metaborg.org/content/repositories/snapshots/")
    gradlePluginPortal()
  }
  dependencies {
    classpath("org.metaborg:gradle.config:0.3.7")
  }
}
apply(plugin = "org.metaborg.gradle.config.devenv-settings")

// Also make plugin repositories available, for loading plugins in included builds.
pluginManagement {
  repositories {
    maven(url = "https://artifacts.metaborg.org/content/repositories/releases/")
    maven(url = "https://artifacts.metaborg.org/content/repositories/snapshots/")
    gradlePluginPortal()
  }
}

// Include builds from subdirectories, but only if it is from an included repository.
configure<DevenvSettingsExtension> {
  includeBuildsFromSubDirs(true)
}

// HACK: emulate nested included builds, as IntelliJ does not support nested composite builds yet.
if(the<DevenvSettingsExtension>().repoProperties["spoofax.gradle"]?.include == true) {
  if(File(rootDir, "spoofax.gradle/example/calc").exists()) {
    includeBuild("spoofax.gradle/example/calc")
  }
}
