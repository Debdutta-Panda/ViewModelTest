package com.debduttapanda.viewmodeltest.repository

import com.debduttapanda.viewmodeltest.network.ApiResponse
import retrofit2.Response

interface UserRepository {
    suspend fun getUserReport(): Response<out ApiResponse>
}