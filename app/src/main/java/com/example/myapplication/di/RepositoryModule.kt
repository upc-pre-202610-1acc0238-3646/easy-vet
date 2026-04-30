package com.example.myapplication.di

import com.example.myapplication.data.ProductRepositoryImpl
import com.example.myapplication.data.ProductService
import com.example.myapplication.di.RemoteModule.provideProductService
import com.example.myapplication.domain.ProductRepository

object RepositoryModule {

    fun provideProductRepository(productService: ProductService = provideProductService()): ProductRepository {
        return ProductRepositoryImpl(productService)
    }
}