package com.example.libreriasfiterror.viewmodel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class UserAdminViewModel : ViewModel() {
    var isAdmin by mutableStateOf(false)
}
