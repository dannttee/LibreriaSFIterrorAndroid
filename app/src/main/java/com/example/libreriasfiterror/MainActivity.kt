package com.example.libreriasfiterror

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.libreriasfiterror.ui.HomeScreen
import com.example.libreriasfiterror.ui.theme.LibreriaSfiterrorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LibreriaSfiterrorTheme {
                HomeScreen()
            }
        }
    }
}
