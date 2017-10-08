package com.kpiega.sub_activities.manager

import android.app.Activity
import com.kpiega.sub_interface.di.InterComponentInterface
import com.kpiega.sub_interface.interfaces.ModulePreference
import com.kpiega.sub_interface.interfaces.ModuleRequstsNetwork
import dagger.android.HasActivityInjector

interface ModuleInterface: HasActivityInjector {

    fun startModuleMainActivity(activity: Activity)
    fun createSession(appComponent: InterComponentInterface, network: ModuleRequstsNetwork, preferences: ModulePreference)
    fun eraseSession()
}