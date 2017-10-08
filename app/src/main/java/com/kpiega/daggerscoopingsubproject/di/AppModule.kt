package com.kpiega.daggerscoopingsubproject.di

import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun getCustomClass() = CustomClass()

}


class CustomClass @Inject constructor() {
    val subScopeValue = "subScopeValue"
}
