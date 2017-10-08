package com.kpiega.daggerscoopingsubproject

import android.app.Activity
import android.app.Application
import com.kpiega.daggerscoopingsubproject.di.AppComponent
import com.kpiega.daggerscoopingsubproject.di.DaggerAppComponent
import com.kpiega.sub_activities.manager.ModuleManager
import com.kpiega.sub_activities.manager.utils.HasSubModule
import com.kpiega.sub_interface.interfaces.ModulePreference
import com.kpiega.sub_interface.interfaces.ModuleRequstsNetwork
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.reactivex.Observable
import javax.inject.Inject

class SubScopeApp: Application(), HasActivityInjector, HasSubModule {

    @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    @Inject lateinit var moduleManager: ModuleManager

    lateinit var appComponent: AppComponent
        private set


    override fun onCreate() {
        super.onCreate()

        initAppComponent()

        initModule()
    }

    private fun initModule() {

        moduleManager.createSession(
                appComponent,
                provideRequestNetwork(),
                providePreference()
        )

    }

    private fun providePreference() = object: ModulePreference {
        override fun isAttachToCore(): Boolean {
            return false
        }

        override fun moduleWelcomeText(): String {
            return "Hello my friend - SubProject app here!"
        }

    }

    private fun provideRequestNetwork() = object: ModuleRequstsNetwork {
        override fun dowloadModuleData(data: String): Observable<String> {
            return Observable.just("SubProject Data")
        }
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

    override fun hasModule(): Boolean {
        return true
    }

    override fun moduleManager(): ModuleManager? {
        return moduleManager
    }


}