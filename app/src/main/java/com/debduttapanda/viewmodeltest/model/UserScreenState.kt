package com.debduttapanda.viewmodeltest.model

import com.debduttapanda.viewmodeltest.model.UserData

data class UserScreenState(
    val data: UserData? = null,
    val isLoading: Boolean = false,
    val hasError: Boolean = false,
    val errorMessage: String? = null
)