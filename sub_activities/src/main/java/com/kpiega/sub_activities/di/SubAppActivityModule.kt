package com.kpiega.sub_activities.di

import com.kpiega.sub_activities.SubMainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SubAppActivityModule {

    @ContributesAndroidInjector
    abstract fun subMainActivity() : SubMainActivity

}