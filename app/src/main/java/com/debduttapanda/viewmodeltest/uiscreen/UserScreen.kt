package com.debduttapanda.viewmodeltest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.debduttapanda.viewmodeltest.model.UserData

@Composable
fun UserScreen(
    state: UserData,
) {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .background(Color.White),
        verticalArrangement = Arrangement.Top
    ) {
        Text(state.title)
    }
}

@Preview
@Composable
fun previewUserScreen() {
    UserScreen(state = UserData(
        title = "Fake Title",
        completed = false,
        id = 0,
        userID = 123L
    )
    )
}