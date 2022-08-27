package com.debduttapanda.viewmodeltest.di

import com.debduttapanda.viewmodeltest.use_cases.GetUserUseCase
import com.debduttapanda.viewmodeltest.use_cases.GetUserUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun provideGetUserUseCase(
        useCase: GetUserUseCaseImpl
    ): GetUserUseCase
}