package com.example.myapplication.domain

interface ProductRepository {

    suspend fun getProducts(): List<Product>
}