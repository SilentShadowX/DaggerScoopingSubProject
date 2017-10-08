package com.kpiega.sub_activities.di

import com.kpiega.sub_activities.di.scope.SubAppModuleScope
import com.kpiega.sub_activities.manager.ModuleManager
import com.kpiega.sub_interface.di.InterComponentInterface
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication

@SubAppModuleScope
@Component(
        dependencies = arrayOf(
                InterComponentInterface::class
        ),
        modules = arrayOf(
                AndroidSupportInjectionModule::class,
                SubAppActivityModule::class
        )
)
interface ActivityModuleComponent: AndroidInjector<DaggerApplication> {

    val moduleManager: ModuleManager

    @Component.Builder
    interface Builder {

        fun build(): ActivityModuleComponent
        fun appComponent(component: InterComponentInterface): Builder
    }

    fun inject(moduleManager: ModuleManager)

}


