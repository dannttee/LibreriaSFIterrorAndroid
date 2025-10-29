package com.example.libreriasfiterror

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.libreriasfiterror.viewmodel.UserAdminViewModel
import com.example.libreriasfiterror.ui.LibraryAppNavegacion


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // Instancia global del ViewModel
                val userAdminViewModel: UserAdminViewModel = viewModel()
                LibraryAppNavegacion(userAdminViewModel)
            }
        }
    }
}
