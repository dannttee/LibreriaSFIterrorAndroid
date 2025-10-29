package com.example.libreriasfiterror.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.libreriasfiterror.viewmodel.UserAdminViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val userAdminViewModel: UserAdminViewModel = viewModel()
            LibraryAppNavegacion(userAdminViewModel)
        }
    }
}

