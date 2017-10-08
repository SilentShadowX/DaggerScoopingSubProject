package com.kpiega.sub_activities.di.utils

import android.app.Activity
import dagger.android.HasActivityInjector

class ModuleInjection {
    companion object {
        fun inject(activity: Activity, injector: HasActivityInjector) {
            injector.activityInjector().inject(activity)
        }
    }
}