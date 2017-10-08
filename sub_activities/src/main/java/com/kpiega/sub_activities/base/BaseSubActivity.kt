package com.kpiega.sub_activities.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.kpiega.sub_activities.di.utils.ModuleInjection
import com.kpiega.sub_activities.manager.ModuleManager
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseSubActivity: AppCompatActivity(), HasSupportFragmentInjector {

    @Inject lateinit var injector: DispatchingAndroidInjector<Fragment>

    var moduleManager: ModuleManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        if(moduleManager == null) {
            moduleManager = ModuleManager().apply {
                this.createModuleSession()
            }
        }

        androidInject()

        super.onCreate(savedInstanceState)
    }

    protected open fun androidInject() {
        ModuleInjection.inject(this, moduleManager as HasActivityInjector)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return injector
    }
}


