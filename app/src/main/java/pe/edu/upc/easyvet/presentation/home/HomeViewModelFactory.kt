package pe.edu.upc.easyvet.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import pe.edu.upc.easyvet.domain.ProductRepository

class HomeViewModelFactory(
    private val repository: ProductRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(
            repository
        ) as T

    }
}