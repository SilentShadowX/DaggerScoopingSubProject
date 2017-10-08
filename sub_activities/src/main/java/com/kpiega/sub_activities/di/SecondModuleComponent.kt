package com.kpiega.sub_activities.di

import com.kpiega.sub_activities.di.module.NetworkModule
import com.kpiega.sub_activities.di.scope.SubAppModuleScope
import com.kpiega.sub_interface.di.InterComponentInterface
import com.kpiega.sub_interface.interfaces.ModulePreference
import com.kpiega.sub_interface.interfaces.ModuleRequstsNetwork
import dagger.BindsInstance
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
interface SecondModuleComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {

        fun build(): SecondModuleComponent

        fun appComponent(component: InterComponentInterface): Builder

        @BindsInstance
        fun buildNetworkRequest(obj: ModuleRequstsNetwork): Builder

        @BindsInstance
        fun buildPreference(obj: ModulePreference): Builder
    }

}


