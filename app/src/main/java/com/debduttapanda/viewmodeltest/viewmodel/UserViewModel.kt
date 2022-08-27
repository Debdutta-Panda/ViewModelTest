package com.debduttapanda.viewmodeltest.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.debduttapanda.viewmodeltest.network.Resource
import com.debduttapanda.viewmodeltest.model.UserScreenState
import com.debduttapanda.viewmodeltest.use_cases.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UserViewModel @Inject constructor(
    private val userUseCase: GetUserUseCase
): ViewModel() {

    private var _userState = mutableStateOf(UserScreenState())
    val userState: State<UserScreenState> = _userState

    init {
        getUserReport()
    }

    private fun getUserReport() {
        viewModelScope.launch {
            userUseCase.fetch().collect { resource ->
                when(resource) {
                    is Resource.Success -> {
                        _userState.value = UserScreenState(
                            data = resource.data
                        )
                    }
                    is Resource.Error -> {
                        _userState.value = UserScreenState(
                            hasError = true,
                            errorMessage = resource.message
                        )
                    }
                    is Resource.Loading -> {
                        _userState.value = UserScreenState(
                            isLoading = true
                        )
                    }
                }
            }
        }
    }
}