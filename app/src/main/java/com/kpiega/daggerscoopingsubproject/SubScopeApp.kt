package com.kpiega.daggerscoopingsubproject

import android.app.Activity
import android.app.Application
import android.content.Intent
import com.kpiega.daggerscoopingsubproject.di.AppComponent
import com.kpiega.daggerscoopingsubproject.di.DaggerAppComponent
import com.kpiega.sub_activities.SubMainActivity
import com.kpiega.sub_activities.module.SubProjectModule
import com.kpiega.sub_interface.SubProjectInterface
import com.kpiega.sub_interface.app.SubProjectApplication
import com.kpiega.sub_interface.app.SubProjectPreference
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

        initModule()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .application(this)
                .build()

        appComponent.inject(this)
    }

    fun initModule() {
        SubProjectModule.redirect = redirectApp()
        SubProjectModule.appModule = provideApp(this)
        SubProjectModule.preferences = providePreferences()

        SubProjectModule.appComponent = appComponent
    }

    fun redirectApp() = object: SubProjectInterface {
        override fun startSubProjectActivity(activity: Activity) {
            activity.startActivity(Intent(activity, SubMainActivity::class.java))
        }

    }

    fun provideApp(app: Application) = object : SubProjectApplication {
        override fun provideAppContext(): Application {
            return app
        }
    }

    fun providePreferences() = object : SubProjectPreference {
        override fun moduleWelcomeText(): String {
            return "Subscope project - Welcome!"
        }
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }

}