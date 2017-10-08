package com.kpiega.daggerscoopingsubproject

import android.os.Bundle
import com.kpiega.sub_activities.manager.ModuleManager
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_start.*
import javax.inject.Inject

class StartActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var manager: ModuleManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        startSubProject.setOnClickListener {
            manager.startModuleMainActivity(this)
            finish()
        }
    }
}
