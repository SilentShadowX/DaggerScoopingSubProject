package com.kpiega.daggerscoopingsubproject.di

import com.kpiega.sub_activities.di.scope.SubAppModuleScope
import com.kpiega.sub_activities.manager.ModuleManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideModuleManager() = ModuleManager()

}