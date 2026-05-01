package pe.edu.upc.easyvet.home.domain

interface ProductRepository {

    suspend fun getProducts(): List<Product>
}