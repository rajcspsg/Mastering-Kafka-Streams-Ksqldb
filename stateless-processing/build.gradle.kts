plugins {
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
  implementation("org.apache.kafka", "kafka-streams", "2.7.0")
  testImplementation("org.junit.jupiter", "junit-jupiter-api", "5.7.1")
}
