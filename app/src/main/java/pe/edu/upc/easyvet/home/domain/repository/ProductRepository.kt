package pe.edu.upc.easyvet.home.domain.repository

import kotlinx.coroutines.flow.Flow
import pe.edu.upc.easyvet.home.data.repository.Resource
import pe.edu.upc.easyvet.home.domain.model.Product

interface ProductRepository {

    fun getProducts(): Flow<List<Product>>
    suspend fun syncProducts(): Resource
}
