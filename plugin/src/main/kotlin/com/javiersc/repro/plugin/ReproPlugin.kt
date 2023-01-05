package com.javiersc.repro.plugin

import javax.inject.Inject
import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.property
import org.gradle.kotlin.dsl.the

open class ReproPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.extensions.create<ReproExtension>("_InternalRepro").configure()
        target.extensions.create<ReproNestedExtension>("_InternalReproNested").configure()
    }
}

open class ReproExtension
@Inject
constructor(
    project: Project,
    objects: ObjectFactory,
) : BaseReproExtension(project, objects) {

    val reproNested: ReproNestedExtension
        get() = the()

    fun reproNested(action: Action<ReproNestedExtension> = Action {}) {
        action.execute(reproNested)
    }
}

open class ReproNestedExtension
@Inject
constructor(
    project: Project,
    objects: ObjectFactory,
) : BaseReproExtension(project, objects) {

    val someProperty: Property<String> = property<String>().convention("default")

    override fun configure() {
        super.configure()
        println("Default `someProperty`: ${someProperty.get()}")
    }
}

abstract class BaseReproExtension
@Inject
constructor(
    project: Project,
    objects: ObjectFactory,
) : Project by project, ObjectFactory by objects {

    internal open fun configure() {
        val className = this::class.simpleName ?: "Unknown"
        val configurationName =
            if (name.endsWith("_Decorated")) className.substringBefore("_Decorated") else className
        println("Configuring $configurationName")
    }
}
