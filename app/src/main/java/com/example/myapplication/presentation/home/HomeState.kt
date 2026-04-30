package com.example.myapplication.presentation.home

import com.example.myapplication.domain.Product

data class HomeState(
    val products: List<Product> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)