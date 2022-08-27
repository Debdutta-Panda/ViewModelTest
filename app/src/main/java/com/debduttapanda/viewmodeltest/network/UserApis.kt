package com.debduttapanda.viewmodeltest.network

import com.debduttapanda.viewmodeltest.model.UserData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface UserApis {

    @GET
    suspend fun openApiReport(
        @Url url: String = "todos/1",
    ): Response<UserData>
}