plugins {
    kotlin("jvm") version "1.9.22"
    alias(libs.plugins.sonatypeCentralPortalPublisher)
}

group = "world.avionik"
version = "1.0.2"

repositories {
    mavenCentral()

    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly(kotlin("stdlib"))

    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
    testCompileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
}

signing {
    useGpgCmd()
    sign(configurations.archives.get())
}

centralPortal {
    username = project.findProperty("sonatypeUsername") as String
    password = project.findProperty("sonatypePassword") as String

    pom {
        name.set("Event Requirement Manager")
        description.set("Register Bukkit listeners and add one or more requirements")
        url.set("https://github.com/avionik-world/event-requirement-manager")

        developers {
            developer {
                id.set("niklasnieberler")
                email.set("admin@avionik.world")
            }
        }
        licenses {
            license {
                name.set("Apache-2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        scm {
            url.set("https://github.com/avionik-world/event-requirement-manager.git")
            connection.set("git:git@github.com:avionik-world/event-requirement-manager.git")
        }
    }
}