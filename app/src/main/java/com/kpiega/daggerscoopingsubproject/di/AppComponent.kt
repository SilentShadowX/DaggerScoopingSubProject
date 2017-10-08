package com.kpiega.daggerscoopingsubproject.di

import android.app.Application
import com.kpiega.daggerscoopingsubproject.SubScopeApp
import com.kpiega.daggerscoopingsubproject.di.app.SubProjectActivityBindingModule
import com.kpiega.sub_interface.di.InterComponentInterface
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        AppModule::class,
        SubProjectActivityBindingModule::class
))
interface AppComponent : AndroidInjector<DaggerApplication>, InterComponentInterface {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder
        fun build(): AppComponent
    }

    fun inject(subScopeApp: SubScopeApp)
}


