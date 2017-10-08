package com.kpiega.sub_activities.base

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.kpiega.sub_activities.manager.ModuleManager
import com.kpiega.sub_activities.manager.utils.HasSubModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseSubActivity: AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var injector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var manager: ModuleManager

    override fun onCreate(savedInstanceState: Bundle?) {
        androidInject()
        super.onCreate(savedInstanceState)
    }

    protected open fun androidInject() {
        try {
            val moduleInterface = application as HasSubModule
            if(moduleInterface.hasModule()) {
                ModuleInjector.inject(this, moduleInterface.moduleManager() as ModuleManager)
            } else {
                Toast.makeText(this, "This module is not attached", Toast.LENGTH_LONG).show()
                finish()
            }
        } catch (e: Exception) {
            Toast.makeText(this, "This app doesn't have sub module", Toast.LENGTH_LONG).show()
            finish()
        }
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return injector
    }
}

class ModuleInjector {

    companion object {
        fun inject(activity: Activity, injector: HasActivityInjector) {
            injector.activityInjector().inject(activity)
        }
    }
}


