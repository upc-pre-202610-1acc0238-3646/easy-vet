package pe.edu.upc.easyvet.data

import retrofit2.Response
import retrofit2.http.GET

interface ProductService {

    @GET("products")
    suspend fun getProducts(): Response<pe.edu.upc.easyvet.data.ProductsDto>
}