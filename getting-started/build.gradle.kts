plugins {
  java
}

tasks.register<JavaExec>("runDSL") {
  main = "com.example.DSLExample"
  classpath ( sourceSets.main.get().runtimeClasspath)
}


tasks.register<JavaExec> ("runProcessorAPI") {
  main = "com.example.ProcessorApiExample"
  classpath ( sourceSets.main.get().runtimeClasspath)
}
