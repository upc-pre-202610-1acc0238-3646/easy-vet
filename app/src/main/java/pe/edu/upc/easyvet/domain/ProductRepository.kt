package pe.edu.upc.easyvet.domain

interface ProductRepository {

    suspend fun getProducts(): List<Product>
}