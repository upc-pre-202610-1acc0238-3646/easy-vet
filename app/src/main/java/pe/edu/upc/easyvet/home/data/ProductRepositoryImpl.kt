package pe.edu.upc.easyvet.home.data


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.upc.easyvet.home.domain.Product
import pe.edu.upc.easyvet.home.domain.ProductRepository

class ProductRepositoryImpl(
    private val productService: ProductService
) : pe.edu.upc.easyvet.home.domain.ProductRepository {

    override suspend fun getProducts(): List<pe.edu.upc.easyvet.home.domain.Product> = withContext(Dispatchers.IO) {
        val response = productService.getProducts()

        if (response.isSuccessful) {
            response.body()?.let {
                return@withContext it.results.map { dto ->
                    .Product(
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