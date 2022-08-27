package com.debduttapanda.viewmodeltest.di

import com.debduttapanda.viewmodeltest.Constants.OA_REPO
import com.debduttapanda.viewmodeltest.network.JsonPlaceholderApiRepository
import com.debduttapanda.viewmodeltest.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Named(OA_REPO)
    abstract fun provideOARepository(
        repository: JsonPlaceholderApiRepository
    ): UserRepository
}