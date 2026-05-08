package pe.edu.upc.easyvet.home.presentation.home

import android.net.http.NetworkException
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil3.network.HttpException
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pe.edu.upc.easyvet.home.domain.repository.ProductRepository
import java.net.UnknownHostException


@HiltViewModel
class HomeViewModel @Inject constructor(private val productRepository: ProductRepository) :
    ViewModel() {

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

            } catch (e: UnknownHostException) {
                homeState.update {
                    it.copy(
                        isLoading = false,
                    )
                }

            } catch (e: Exception) {
                homeState.update {
                    it.copy(
                        isLoading = false,
                        error = e.message ?: "An error occurred"
                    )
                }
            }

        }

    }

    init {
        observeProducts()
        syncProducts()
    }

}