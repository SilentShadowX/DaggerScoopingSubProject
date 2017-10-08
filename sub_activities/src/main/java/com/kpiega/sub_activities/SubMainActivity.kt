package com.kpiega.sub_activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kpiega.sub_activities.base.BaseSubActivity
import com.kpiega.sub_activities.module.SubProjectModule
import kotlinx.android.synthetic.main.activity_submain.*

class SubMainActivity : BaseSubActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)
        setContentView(R.layout.activity_submain)

        activityComponent
        welcomeText.text = SubProjectModule.preferences?.moduleWelcomeText()

    }
}
