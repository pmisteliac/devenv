plugins {
  id("org.metaborg.gradle.config.devenv") version "0.3.7"
}

devenv {
  repoUrlPrefix = "git@github.com:metaborg"

  // Gradle plugins.
  registerRepo("gradle.config")
  registerRepo("gitonium")
  registerRepo("coronium")
  registerRepo("spoofax.gradle")

  // Spoofax Core libraries and applications.
  registerRepo("spoofax")
  registerRepo("sdf")
  
  // Libraries and applications.
  registerRepo("log")
  registerRepo("resource")
  registerRepo("pie")
  registerRepo("spoofax-pie")

  // Continuous integration.
  registerRepo("jenkins.pipeline")
}

devenv {
  registerCompositeBuildTask("cleanAll", "Deletes the build directory for all projects in the composite build.")
  registerCompositeBuildTask("checkAll", "Runs all checks for all projects in the composite build.")
  registerCompositeBuildTask("assembleAll", "Assembles the outputs for all projects in the composite build.")
  registerCompositeBuildTask("buildAll", "Assembles and tests all projects in the composite build.")
  registerCompositeBuildTask("publishAll", "Publishes all publications produced by all projects in the composite build.")
}

tasks {
  wrapper {
    gradleVersion = "5.3"
    distributionType = Wrapper.DistributionType.ALL
    setJarFile(".gradlew/wrapper/gradle-wrapper.jar")
  }
}
