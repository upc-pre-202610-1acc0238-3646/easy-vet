package pe.edu.upc.easyvet.home.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface ProductService {

    @GET("products")
    suspend fun getProducts(): Response<ProductsDto>
}