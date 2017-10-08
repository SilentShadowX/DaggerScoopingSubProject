package com.kpiega.sub_interface.di

import android.app.Activity
import android.app.Application

interface InterComponentInterface {
    val application: Application
    fun inject(activity: Activity)
}