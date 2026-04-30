package pe.edu.upc.easyvet.domain

interface ProductRepository {

    suspend fun getProducts(): List<pe.edu.upc.easyvet.domain.Product>
}