package pe.edu.upc.easyvet.home.presentation.home

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import pe.edu.upc.easyvet.home.domain.ProductRepository

class HomeViewModelFactory(
    private val repository: ProductRepository
) {
    fun create(): ViewModelProvider.Factory = viewModelFactory {
        initializer {
            HomeViewModel(
                productRepository = repository
            )
        }
    }
}