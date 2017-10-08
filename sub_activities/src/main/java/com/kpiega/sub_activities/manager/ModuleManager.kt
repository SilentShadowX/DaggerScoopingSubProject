package com.kpiega.sub_activities.manager

import android.app.Activity
import com.kpiega.sub_activities.di.ActivityModuleComponent
import com.kpiega.sub_activities.di.DaggerActivityModuleComponent
import com.kpiega.sub_activities.di.scope.SubAppModuleScope
import com.kpiega.sub_activities.module.SubProjectModule
import com.kpiega.sub_interface.di.InterComponentInterface
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

@SubAppModuleScope
class ModuleManager @Inject constructor(): HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    var moduleComponent: ActivityModuleComponent? = null
        private set


    fun createModuleSession() {

        if (moduleComponent != null)
            return

        moduleComponent = DaggerActivityModuleComponent.builder()
                .appComponent(SubProjectModule.appComponent as InterComponentInterface)
                .build()

        moduleComponent?.inject(this)

    }

    fun eraseModuleSession() {
        moduleComponent = null
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }

}