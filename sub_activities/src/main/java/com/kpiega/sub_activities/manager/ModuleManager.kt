package com.kpiega.sub_activities.manager

import android.app.Activity
import android.content.Intent
import com.kpiega.sub_activities.SubMainActivity
import com.kpiega.sub_activities.di.DaggerSecondModuleComponent
import com.kpiega.sub_activities.di.SecondModuleComponent
import com.kpiega.sub_interface.di.InterComponentInterface
import com.kpiega.sub_interface.interfaces.ModulePreference
import com.kpiega.sub_interface.interfaces.ModuleRequstsNetwork
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

class ModuleManager @Inject constructor(): ModuleInterface {

    @Inject lateinit var injector: DispatchingAndroidInjector<Activity>

    var moduleComponent: SecondModuleComponent? = null

    override fun startModuleMainActivity(activity: Activity) {
        activity.startActivity(Intent(activity, SubMainActivity::class.java))
    }

    override fun createSession(
            appComponent: InterComponentInterface,
            network: ModuleRequstsNetwork,
            preferences: ModulePreference
    ) {
        if(moduleComponent != null)
            return

        moduleComponent = DaggerSecondModuleComponent.builder()
                .appComponent(appComponent)
                .buildNetworkRequest(network)
                .buildPreference(preferences)
                .build()

        moduleComponent?.inject(this)
    }

    override fun eraseSession() {
        if(moduleComponent != null)
            moduleComponent = null
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return injector
    }



}

