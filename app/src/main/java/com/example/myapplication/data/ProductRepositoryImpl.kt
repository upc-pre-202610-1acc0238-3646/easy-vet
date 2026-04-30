package com.example.myapplication.data

import com.example.myapplication.domain.Product
import com.example.myapplication.domain.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductRepositoryImpl(
    private val productService: ProductService
) : ProductRepository {

    override suspend fun getProducts(): List<Product> = withContext(Dispatchers.IO) {
        val response = productService.getProducts()

        if (response.isSuccessful) {
            response.body()?.let {
                return@withContext it.results.map { dto ->
                    Product(
                        id = dto.id,
                        name = dto.title,
                        image = dto.image,
                        description = dto.description
                    )
                }
            }
        }

        return@withContext emptyList()
    }
}