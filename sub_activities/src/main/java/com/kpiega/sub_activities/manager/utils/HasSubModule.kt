package com.kpiega.sub_activities.manager.utils

import com.kpiega.sub_activities.manager.ModuleManager


interface HasSubModule {
    fun hasModule(): Boolean
    fun moduleManager(): ModuleManager?
}