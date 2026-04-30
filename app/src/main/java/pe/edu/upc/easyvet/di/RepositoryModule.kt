package pe.edu.upc.easyvet.di

import pe.edu.upc.easyvet.data.ProductRepositoryImpl
import pe.edu.upc.easyvet.data.ProductService
import pe.edu.upc.easyvet.di.RemoteModule.provideProductService
import pe.edu.upc.easyvet.domain.ProductRepository


object RepositoryModule {

    fun provideProductRepository(productService: ProductService = provideProductService()): ProductRepository {
        return ProductRepositoryImpl(productService)
    }
}