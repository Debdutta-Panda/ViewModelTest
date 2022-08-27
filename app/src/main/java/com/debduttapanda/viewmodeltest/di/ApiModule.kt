package com.debduttapanda.viewmodeltest.di

import com.debduttapanda.viewmodeltest.network.UserApis
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    fun provideUserService(): UserApis {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApis::class.java)
    }
}