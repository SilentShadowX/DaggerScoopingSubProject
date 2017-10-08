package com.kpiega.daggerscoopingsubproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kpiega.sub_activities.module.SubProjectModule
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        startSubProject.setOnClickListener {
            SubProjectModule.redirect?.startSubProjectActivity(this)
            finish()
        }
    }
}
