package com.kpiega.sub_interface.interfaces

import io.reactivex.Observable

interface ModuleRequstsNetwork {
    fun dowloadModuleData(data: String): Observable<String>
}