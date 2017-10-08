package com.kpiega.sub_activities.module

import com.kpiega.sub_interface.SubProjectInterface
import com.kpiega.sub_interface.app.SubProjectApplication
import com.kpiega.sub_interface.app.SubProjectPreference
import com.kpiega.sub_interface.di.InterComponentInterface

class SubProjectModule {

    companion object {

        var appComponent: InterComponentInterface? = null

        var redirect: SubProjectInterface? = null
        var appModule: SubProjectApplication? = null
        var preferences: SubProjectPreference? = null

    }

}