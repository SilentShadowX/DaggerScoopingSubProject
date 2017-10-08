package com.kpiega.daggerscoopingsubproject.di.app

import com.kpiega.daggerscoopingsubproject.StartActivity
import com.kpiega.sub_activities.SubMainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SubProjectActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun subMainActivity(): StartActivity
}