package org.godslew.gkcatinfosampleapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.godslew.gkcatinfosampleapp.data.CatInfo
import org.godslew.gkcatinfosampleapp.data.CatRepository
import org.godslew.gkcatinfosampleapp.data.model.CatImage
import org.godslew.gkcatinfosampleapp.domain.GetCatInfoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CatViewModel(
    private val getCatInfoUseCase: GetCatInfoUseCase,
    private val catRepository: CatRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(CatUiState())
    val uiState: StateFlow<CatUiState> = _uiState.asStateFlow()
    
    init {
        loadCatImages()
    }
    
    private fun loadCatImages() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            try {
                // 各リクエストで異なる画像を取得するため、limitを多めに設定してランダムに取得
                val images = catRepository.searchImages(limit = 10, hasBreeds = true)
                _uiState.value = _uiState.value.copy(
                    catImages = images,
                    isLoading = false,
                    error = null
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = e.message
                )
            }
        }
    }
    
    fun refresh() {
        loadCatImages()
    }
}

data class CatUiState(
    val catInfo: CatInfo? = null,
    val catImages: List<CatImage> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)