plugins {
    `java-gradle-plugin`
    id("org.jetbrains.kotlin.jvm") version "1.7.20"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(gradleApi())
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useKotlinTest()
        }

        val functionalTest by registering(JvmTestSuite::class) {
            useKotlinTest()

            dependencies {
                implementation(project)
            }

            targets {
                all {
                    testTask.configure { shouldRunAfter(test) }
                }
            }
        }
    }
}

gradlePlugin {
    plugins {
        create("remote") {
            id = "io.github.eendroroy.gradle.remote"
            implementationClass = "io.github.eendroroy.gradle.remote.GradleRemotePlugin"
        }
    }
}

gradlePlugin.testSourceSets(sourceSets["functionalTest"])

tasks.named<Task>("check") {
    dependsOn(testing.suites.named("functionalTest"))
}