package com.kpiega.sub_activities

import android.app.Application
import android.os.Bundle
import com.kpiega.sub_activities.base.BaseSubActivity
import com.kpiega.sub_activities.module.SubProjectModule
import kotlinx.android.synthetic.main.activity_submain.*
import javax.inject.Inject

class SubMainActivity : BaseSubActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submain)

    }
}
