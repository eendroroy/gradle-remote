/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package io.github.eendroroy.gradle.remote

import org.gradle.testfixtures.ProjectBuilder
import kotlin.test.Test
import kotlin.test.assertNotNull

/**
 * A simple unit test for the 'io.github.eendroroy.gradle.remote' plugin.
 */
class GradleRemotePluginTest {
    @Test fun `plugin registers task`() {
        // Create a test project and apply the plugin
        val project = ProjectBuilder.builder().build()
        project.plugins.apply("io.github.eendroroy.gradle.remote")

        // Verify the result
        assertNotNull(project.tasks.findByName("greeting"))
    }
}
