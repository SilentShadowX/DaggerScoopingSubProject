package com.kpiega.sub_activities.di.module
import com.kpiega.sub_activities.di.scope.SubAppModuleScope
import com.kpiega.sub_activities.repository.NetworkRequestRepository
import com.kpiega.sub_activities.repository.NetworkRequestRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
abstract class NetworkRepositoryModule {

    @SubAppModuleScope
    @Binds
    abstract fun provideAppRepository(repo: NetworkRequestRepositoryImpl): NetworkRequestRepository
}