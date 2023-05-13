plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // lombok ----------------------------------------------------------------------------------------------------
    compileOnly("org.projectlombok:lombok:1.18.26")
    annotationProcessor("org.projectlombok:lombok:1.18.26")

    testCompileOnly("org.projectlombok:lombok:1.18.26")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.26")

    // mockito ----------------------------------------------------------------------------------------------------
    testImplementation("org.mockito:mockito-core:4.11.0+")
    testImplementation("org.mockito:mockito-junit-jupiter:4.11.0")

    // h2 ----------------------------------------------------------------------------------------------------
    runtimeOnly("com.h2database:h2:2.1.214+")
    // ---------------------------------------------------------------------------------------------------- h2

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}