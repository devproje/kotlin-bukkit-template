import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
}

group = property("group")!!
version = property("version")!!

java.toolchain {
    languageVersion.set(JavaLanguageVersion.of(17))
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

val exposedVersion = property("exposed_version")!!

dependencies {
    implementation(kotlin("stdlib"))
    implementation("io.github.monun:kommand-api:2.14.0")
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
    implementation("net.projecttl:InventoryGUI-api:4.4.0")

    compileOnly(dependencyNotation = "com.mysql:mysql-connector-j:8.0.31")
    compileOnly(dependencyNotation = "io.papermc.paper:paper-api:1.19.2-R0.1-SNAPSHOT")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()
    }

    processResources {
        filesMatching("*.yml") {
            expand(project.properties)
        }
    }

    create<Jar>("paperJar") {
        archiveBaseName.set(rootProject.name)
        archiveClassifier.set("")
        archiveVersion.set("")

        from(sourceSets["main"].output)
    }
}
