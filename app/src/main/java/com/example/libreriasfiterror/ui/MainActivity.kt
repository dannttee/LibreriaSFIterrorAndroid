package com.example.libreriasfiterror.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.libreriasfiterror.ui.theme.LibreriaSfiterrorTheme
import com.example.libreriasfiterror.ui.NavegacionApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibreriaSfiterrorTheme {
                NavegacionApp()
            }
        }
    }
}
