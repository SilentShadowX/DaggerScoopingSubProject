package com.kpiega.sub_activities.repository

import com.kpiega.sub_interface.interfaces.ModuleRequstsNetwork
import io.reactivex.Observable
import javax.inject.Inject

class NetworkRequestRepositoryImpl @Inject constructor(val obj: ModuleRequstsNetwork)
    : NetworkRequestRepository {

    override fun getData(data: String): Observable<String> {
        return obj.dowloadModuleData(data)
    }
}