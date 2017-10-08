package com.kpiega.sub_activities.repository

import io.reactivex.Observable


interface NetworkRequestRepository {

    fun getData(data: String): Observable<String>
}