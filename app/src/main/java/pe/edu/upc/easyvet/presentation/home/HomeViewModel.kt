package pe.edu.upc.easyvet.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pe.edu.upc.easyvet.domain.ProductRepository


class HomeViewModel(private val productRepository: ProductRepository): ViewModel() {

    private val _homeState = MutableStateFlow(
        HomeState()
    )
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