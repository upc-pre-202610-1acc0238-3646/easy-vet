package pe.edu.upc.easyvet.home.di

import pe.edu.upc.easyvet.home.data.local.ProductDao
import pe.edu.upc.easyvet.home.data.repository.ProductRepositoryImpl
import pe.edu.upc.easyvet.home.data.remote.ProductService
import pe.edu.upc.easyvet.home.di.LocalModule.provideProductDao
import pe.edu.upc.easyvet.home.di.RemoteModule.provideProductService
import pe.edu.upc.easyvet.home.domain.repository.ProductRepository


object RepositoryModule {

    fun provideProductRepository(
        productService: ProductService = provideProductService(),
        productDao: ProductDao = provideProductDao()
    ): ProductRepository {
        return ProductRepositoryImpl(productService, productDao)
    }
}