package io.github.eendroroy.gradle.remote

import io.github.eendroroy.gradle.remote.config.Remote
import org.gradle.api.Project
import org.gradle.api.Plugin

/**
 * A simple 'hello world' plugin.
 */
class GradleRemotePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val remote: Remote = project.extensions.create("remote", Remote::class.java)

        project.tasks.register("greeting") { task ->
            task.doFirst {
                println(remote.name)
                println(remote.ip)
            }
            task.doLast {
                println("Hello from plugin 'io.github.eendroroy.gradle.remote'")
            }
        }
    }
}
