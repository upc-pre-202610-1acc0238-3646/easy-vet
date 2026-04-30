package pe.edu.upc.easyvet.presentation.home

import pe.edu.upc.easyvet.domain.Product


data class HomeState(
    val products: List<Product> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)