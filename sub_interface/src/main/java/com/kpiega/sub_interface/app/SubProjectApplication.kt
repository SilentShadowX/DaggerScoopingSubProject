package com.kpiega.sub_interface.app

import android.app.Application

interface SubProjectApplication {
    fun provideAppContext(): Application
}