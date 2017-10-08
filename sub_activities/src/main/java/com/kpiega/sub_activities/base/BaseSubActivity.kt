package com.kpiega.sub_activities.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kpiega.sub_activities.di.ActivityModuleComponent
import com.kpiega.sub_activities.di.DaggerActivityModuleComponent
import com.kpiega.sub_activities.module.SubProjectModule
import com.kpiega.sub_interface.di.InterComponentInterface

abstract class BaseSubActivity: AppCompatActivity() {

    lateinit var activityComponent: ActivityModuleComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityComponent = DaggerActivityModuleComponent.builder()
                .appComponent(SubProjectModule.appComponent as InterComponentInterface)
                .build()

        print("test")
    }
}