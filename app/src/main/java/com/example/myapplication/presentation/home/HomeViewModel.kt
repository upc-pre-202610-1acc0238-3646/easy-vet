package com.example.myapplication.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch



class HomeViewModel(private val productRepository: ProductRepository): ViewModel() {

    private val _homeState = MutableStateFlow<HomeState>(HomeState())
    val homeState: StateFlow<HomeState> = _homeState


    fun getProducts() {

        _homeState.update {
            it.copy(
                isLoading = true,
                error = null
            )
        }
        viewModelScope.launch {

            try {
                val products = productRepository.getProducts()
                _homeState.update {
                    it.copy(
                        products = products,
                        isLoading = false,
                        error = null
                    )
                }

            } catch (e: Exception) {
                _homeState.update {
                    it.copy(
                        isLoading = false,
                        error = e.message
                    )
                }
            }

        }

    }

    init {
        getProducts()
    }

}