package com.debduttapanda.viewmodeltest.model

import com.debduttapanda.viewmodeltest.network.ApiResponse

data class UserData (
    val userID: Long,
    val id: Long,
    val title: String,
    val completed: Boolean
): ApiResponse