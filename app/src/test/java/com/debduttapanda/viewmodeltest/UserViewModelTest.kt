package com.debduttapanda.viewmodeltest

import com.debduttapanda.viewmodeltest.model.UserData
import com.debduttapanda.viewmodeltest.network.Resource
import com.debduttapanda.viewmodeltest.use_cases.FakeUserUseCaseImpl
import com.debduttapanda.viewmodeltest.viewmodel.UserViewModel
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Created by Saurabh
 */
@OptIn(ExperimentalCoroutinesApi::class)
class UserViewModelTest {

    @get: Rule
    val dispatcherRule = ViewModelRule()

    private lateinit var viewModel: UserViewModel
    private lateinit var fakeUserUseCase: FakeUserUseCaseImpl

    @Before
    fun setUp() {
        fakeUserUseCase = FakeUserUseCaseImpl()
        viewModel = UserViewModel(fakeUserUseCase)
    }

    @Test
    fun `for success resource, data must be available`() = runTest {
        fakeUserUseCase.emit(Resource.Success(UserData(userID = 0, id = 0, title = "title", completed = false)))
        assertThat(viewModel.userState.value.data).isNotNull()
    }

    @Test
    fun `for loading resource, data should be null && isLoading should be true`() = runTest {
        fakeUserUseCase.emit(Resource.Loading())
        assertThat(viewModel.userState.value.isLoading).isTrue()
        assertThat(viewModel.userState.value.data).isNull()
    }

    @Test
    fun `for error resource, data should be null && hasError should be true && errorMessage should be Error`() = runTest {
        fakeUserUseCase.emit(Resource.Error(message = "Error"))
        assertThat(viewModel.userState.value.data).isNull()
        assertThat(viewModel.userState.value.hasError).isTrue()
        assertThat(viewModel.userState.value.errorMessage).isEqualTo("Error")
    }
}