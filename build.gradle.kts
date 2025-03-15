plugins {
    id("java")
    id("io.freefair.lombok") version "8.12.2.1"
}

group = "tamastudiosaseoha"
version = "${ModVer}"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}