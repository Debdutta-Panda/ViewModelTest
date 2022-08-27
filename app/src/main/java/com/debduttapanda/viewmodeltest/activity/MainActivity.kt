package com.debduttapanda.viewmodeltest.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.debduttapanda.viewmodeltest.uiscreen.UserHomeScreen
import com.debduttapanda.viewmodeltest.viewmodel.UserViewModel
import com.debduttapanda.viewmodeltest.ui.theme.ViewModelTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewModelTestTheme {
                UserHomeScreen(
                    viewModel.userState.value
                )
            }
        }
    }
}