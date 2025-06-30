package org.godslew.gkcatinfosampleapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.godslew.gkcatinfosampleapp.data.CatRepository
import org.godslew.gkcatinfosampleapp.data.model.CatBreed
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CatDetailViewModel(
    private val catRepository: CatRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(CatDetailUiState())
    val uiState: StateFlow<CatDetailUiState> = _uiState.asStateFlow()
    
    fun loadBreedDetails(breedId: String) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            try {
                val breed = catRepository.getBreedById(breedId)
                _uiState.value = _uiState.value.copy(
                    breedDetails = breed,
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
}

data class CatDetailUiState(
    val breedDetails: CatBreed? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)