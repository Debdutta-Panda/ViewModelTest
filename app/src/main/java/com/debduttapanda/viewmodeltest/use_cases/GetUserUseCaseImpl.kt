package com.debduttapanda.viewmodeltest.use_cases

import com.debduttapanda.viewmodeltest.Constants.OA_REPO
import com.debduttapanda.viewmodeltest.network.Resource
import com.debduttapanda.viewmodeltest.model.UserData
import com.debduttapanda.viewmodeltest.repository.UserRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.TimeoutException
import javax.inject.Inject
import javax.inject.Named

class GetUserUseCaseImpl @Inject constructor(
    @Named(OA_REPO) private val oaRepository: UserRepository
): GetUserUseCase {

    override fun fetch() = flow {
        try {
            emit(Resource.Loading())
            val apiResponse = oaRepository.getUserReport()
            if (apiResponse.isSuccessful) {
                val result = apiResponse.body() as UserData
                emit(Resource.Success(result))
            } else {
                emit(Resource.Error("Api is unsuccessful"))
            }
        } catch (e: IOException) {
            emit(Resource.Error("IO Exception: ${e.message}"))
        } catch (e: TimeoutException) {
            emit(Resource.Error("Timeout Exception: ${e.message}"))
        } catch (e: HttpException) {
            emit(Resource.Error("Http Exception: ${e.message}"))
        }
    }
}