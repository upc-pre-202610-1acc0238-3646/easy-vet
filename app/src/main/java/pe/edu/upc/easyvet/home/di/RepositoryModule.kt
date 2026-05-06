package pe.edu.upc.easyvet.home.di

import pe.edu.upc.easyvet.home.data.repository.ProductRepositoryImpl
import pe.edu.upc.easyvet.home.data.remote.ProductService
import pe.edu.upc.easyvet.home.di.RemoteModule.provideProductService
import pe.edu.upc.easyvet.home.domain.repository.ProductRepository


object RepositoryModule {

    fun provideProductRepository(productService: ProductService = provideProductService()): ProductRepository {
        return ProductRepositoryImpl(productService)
    }
}