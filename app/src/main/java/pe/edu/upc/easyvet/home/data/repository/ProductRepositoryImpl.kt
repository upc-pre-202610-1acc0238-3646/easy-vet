package pe.edu.upc.easyvet.home.data.repository

import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import pe.edu.upc.easyvet.home.data.local.ProductDao
import pe.edu.upc.easyvet.home.data.mapper.toDomain
import pe.edu.upc.easyvet.home.data.mapper.toEntity
import pe.edu.upc.easyvet.home.data.remote.ProductService
import pe.edu.upc.easyvet.home.domain.model.Product
import pe.edu.upc.easyvet.home.domain.repository.ProductRepository

class ProductRepositoryImpl @Inject constructor(
    private val productService: ProductService,
    private val productDao: ProductDao
) : ProductRepository {
    override fun getProducts(): Flow<List<Product>> {
        return productDao.getProducts()
            .map { entities ->
                entities.map { productEntity ->
                    productEntity.toDomain()
                }
            }
    }

    override suspend fun syncProducts() = withContext(Dispatchers.IO) {
        val response = productService.getProducts()

        if (response.isSuccessful) {
            response.body()?.let { productsDto ->
                val entities = productsDto.results.map { productDto ->
                    productDto.toEntity()
                }
                productDao.deleteAllProducts()
                productDao.insertProducts(entities)
            }
        }
    }


}