package com.kpiega.daggerscoopingsubproject

import android.app.Activity
import android.app.Application
import com.kpiega.daggerscoopingsubproject.di.AppComponent
import com.kpiega.daggerscoopingsubproject.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class SubScopeApp: Application(), HasActivityInjector {

    @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    lateinit var appComponent: AppComponent
        private set


    override fun onCreate() {
        super.onCreate()

        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .application(this)
                .build()

        appComponent.inject(this)
    }


    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }

}