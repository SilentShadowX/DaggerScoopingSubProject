package com.kpiega.sub_activities

import android.os.Bundle
import com.kpiega.sub_activities.base.BaseSubActivity
import com.kpiega.sub_activities.repository.NetworkRequestRepository
import kotlinx.android.synthetic.main.activity_submain.*
import javax.inject.Inject

class SubMainActivity : BaseSubActivity() {

    @Inject
    lateinit var repo: NetworkRequestRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submain)

        repo.getData("Welcome")
                .subscribe { welcomeText.text = it }
    }
}
