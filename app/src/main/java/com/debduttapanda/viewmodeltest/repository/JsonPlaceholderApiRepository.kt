package com.debduttapanda.viewmodeltest.repository

import com.debduttapanda.viewmodeltest.model.UserData
import com.debduttapanda.viewmodeltest.network.UserApis
import com.debduttapanda.viewmodeltest.repository.UserRepository
import retrofit2.Response
import javax.inject.Inject

class JsonPlaceholderApiRepository @Inject constructor(
    private val api: UserApis
): UserRepository {
    override suspend fun getUserReport(): Response<UserData> =
        api.openApiReport()
}