package pe.edu.upc.easyvet.home.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pe.edu.upc.easyvet.home.domain.repository.ProductRepository
import java.net.UnknownHostException


class HomeViewModel(private val productRepository: ProductRepository) : ViewModel() {

    val homeState = MutableStateFlow(HomeState())

    fun observeProducts() {
        viewModelScope.launch {
            productRepository.getProducts().collect { products ->
                homeState.update {
                    it.copy(
                        products = products
                    )
                }
            }

        }
    }

    fun syncProducts() {

        homeState.update {
            it.copy(
                isLoading = true,
                error = null
            )
        }
        viewModelScope.launch {

            try {
                productRepository.syncProducts()
                homeState.update {
                    it.copy(
                        isLoading = false,
                        error = null
                    )
                }

            } catch (_: UnknownHostException) {
                homeState.update {
                    it.copy(
                        isLoading = false,
                        error = "No internet connection."
                    )
                }
            }

            catch (e: Exception) {
                homeState.update {
                    it.copy(
                        isLoading = false,
                        error = e.message ?: "An error occurred"
                    )
                }
            }

        }

    }

    fun clearError() {
        homeState.update {
            it.copy(error = null)
        }
    }

    init {
        observeProducts()
        syncProducts()
    }

}