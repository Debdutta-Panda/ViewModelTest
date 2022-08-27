package com.debduttapanda.viewmodeltest.use_cases

import com.debduttapanda.viewmodeltest.network.Resource
import com.debduttapanda.viewmodeltest.model.UserData
import kotlinx.coroutines.flow.MutableSharedFlow

class FakeUserUseCaseImpl: GetUserUseCase {

    private val fakeFlow = MutableSharedFlow<Resource<UserData>>()

    suspend fun emit(value: Resource<UserData>) = fakeFlow.emit(value)

    override fun fetch() =  fakeFlow
}