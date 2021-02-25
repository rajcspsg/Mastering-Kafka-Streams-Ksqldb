

allprojects {
  group = "org.example"
  version = "1.0-SNAPSHOT"
}

subprojects {
  apply(plugin = "java")
  apply(plugin = "application")

  repositories {
    mavenCentral()
    mavenLocal()
    jcenter()
  }

  configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }

  dependencies {
    val implementation by configurations
    val testImplementation by configurations
    implementation("org.apache.kafka", "kafka-streams", "2.7.0")
    testImplementation("org.junit.jupiter", "junit-jupiter-api", "5.7.1")
  }
}

