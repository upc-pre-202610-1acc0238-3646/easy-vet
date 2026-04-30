package pe.edu.upc.easyvet.data


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.upc.easyvet.domain.Product
import pe.edu.upc.easyvet.domain.ProductRepository

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