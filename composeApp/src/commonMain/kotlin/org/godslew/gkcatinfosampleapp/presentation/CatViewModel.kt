package org.godslew.gkcatinfosampleapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.godslew.gkcatinfosampleapp.data.CatInfo
import org.godslew.gkcatinfosampleapp.domain.GetCatInfoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CatViewModel(
    private val getCatInfoUseCase: GetCatInfoUseCase
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(CatUiState())
    val uiState: StateFlow<CatUiState> = _uiState.asStateFlow()
    
    init {
        loadCatInfo()
    }
    
    private fun loadCatInfo() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            getCatInfoUseCase().collect { catInfo ->
                _uiState.value = CatUiState(
                    catInfo = catInfo,
                    isLoading = false
                )
            }
        }
    }
}

data class CatUiState(
    val catInfo: CatInfo? = null,
    val isLoading: Boolean = false
)