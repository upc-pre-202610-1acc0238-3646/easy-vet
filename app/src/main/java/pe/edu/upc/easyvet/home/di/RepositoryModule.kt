package pe.edu.upc.easyvet.home.di

import pe.edu.upc.easyvet.home.data.ProductRepositoryImpl
import pe.edu.upc.easyvet.home.data.ProductService
import pe.edu.upc.easyvet.home.di.RemoteModule.provideProductService
import pe.edu.upc.easyvet.home.domain.ProductRepository


object RepositoryModule {

    fun provideProductRepository(productService: ProductService = provideProductService()): ProductRepository {
        return ProductRepositoryImpl(productService)
    }
}