rootProject.name = "devenv"

pluginManagement {
  repositories {
    maven(url = "https://artifacts.metaborg.org/content/repositories/releases/")
    maven(url = "https://artifacts.metaborg.org/content/repositories/snapshots/")
    gradlePluginPortal()
  }
}

// Add all subdirectories with a settings.gradle(.kts) file as an included build.
rootDir.list().forEach {
  if(File(rootDir, "$it/${Settings.DEFAULT_SETTINGS_FILE}").isFile || File(rootDir, "$it/${Settings.DEFAULT_SETTINGS_FILE}.kts").isFile) {
    includeBuild(it)
  }
}

// HACK: add spoofax.gradle/example/calc here, as IntelliJ does not support nested composite builds yet.
if(File(rootDir, "spoofax.gradle/example/calc").exists()) {
  includeBuild("spoofax.gradle/example/calc")
}