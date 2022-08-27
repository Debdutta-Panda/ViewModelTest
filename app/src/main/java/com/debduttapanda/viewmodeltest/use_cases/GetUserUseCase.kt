package com.debduttapanda.viewmodeltest.use_cases

import com.debduttapanda.viewmodeltest.network.Resource
import com.debduttapanda.viewmodeltest.model.UserData
import kotlinx.coroutines.flow.Flow

interface GetUserUseCase {

    fun fetch(): Flow<Resource<UserData>>
}