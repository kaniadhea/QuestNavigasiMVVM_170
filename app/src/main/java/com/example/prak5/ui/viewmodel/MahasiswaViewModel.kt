package com.example.prak5.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.prak5.model.mahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MahasiswaViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(mahasiswa())

    val uiState: StateFlow <mahasiswa> = _uiState.asStateFlow()

    fun saveDataMahasiswa(
        ls :MutableList<String>
    ){
        _uiState.update { data ->
            data.copy(
                nama = ls[0],
                gender = ls[1],
                alamat = ls[2]
            )
        }
    }

}