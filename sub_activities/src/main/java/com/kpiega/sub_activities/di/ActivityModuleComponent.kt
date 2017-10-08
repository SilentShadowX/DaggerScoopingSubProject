package com.kpiega.sub_activities.di

import com.kpiega.sub_activities.SubMainActivity
import com.kpiega.sub_activities.di.scope.ActivityModuleScope
import com.kpiega.sub_interface.di.InterComponentInterface
import dagger.Component

@ActivityModuleScope
@Component(
        dependencies = arrayOf(
                InterComponentInterface::class
        ),
        modules = arrayOf(
                SubAppActivityModule::class
        )
)
interface ActivityModuleComponent {

    @Component.Builder
    interface Builder {

        fun build(): ActivityModuleComponent
        fun appComponent(component: InterComponentInterface): Builder
    }

    fun inject(activity: SubMainActivity)
}


