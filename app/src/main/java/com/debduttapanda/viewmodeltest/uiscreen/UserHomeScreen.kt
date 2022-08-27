package com.debduttapanda.viewmodeltest.uiscreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.debduttapanda.viewmodeltest.UserScreen
import com.debduttapanda.viewmodeltest.model.UserScreenState


@Composable
fun UserHomeScreen(
    state: UserScreenState
) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        state.data?.let { userData ->
            Column(
                verticalArrangement = Arrangement.Top
            ) {
                UserScreen(
                    state = userData,
                )
            }
        }

        // if there is an error loading the report
        if (state.hasError) {
            Text(
                text = state.errorMessage ?: "Something went wrong",
                style = TextStyle(
                    color = Color.DarkGray,
                    fontSize = 40.sp,
                    textAlign = TextAlign.Center
                )
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(
                color = Color.DarkGray,
            )
        }
    }
}