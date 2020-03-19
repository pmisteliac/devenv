plugins {
  id("org.metaborg.gradle.config.devenv") version "0.3.20"
  id("org.metaborg.gradle.config.root-project") version "0.3.20"
}

devenv {
  repoUrlPrefix = "git@github.com:metaborg"

  // Gradle plugins.
  registerRepo("gradle.config")
  registerRepo("gitonium")
  registerRepo("coronium")
  registerRepo("spoofax.gradle")

  // Spoofax Core libraries and applications.
  registerRepo("mb-exec")
  registerRepo("nabl")
  registerRepo("spoofax")
  registerRepo("sdf")
  registerRepo("jsglr")

  // Libraries and applications.
  registerRepo("log")
  registerRepo("resource")
  registerRepo("pie")
  registerRepo("spoofax-pie")

  // Phil: Renaming + Tiger examples
  registerRepo("metaborg-tiger", defaultUrl = "git@github.com:pmisteliac/metaborg-tiger.git", defaultBranch = "renaming")

  // Continuous integration.
  registerRepo("jenkins.pipeline")
}
