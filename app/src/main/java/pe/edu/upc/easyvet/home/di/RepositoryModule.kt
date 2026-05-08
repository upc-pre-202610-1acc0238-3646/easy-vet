package pe.edu.upc.easyvet.home.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import pe.edu.upc.easyvet.home.data.local.ProductDao
import pe.edu.upc.easyvet.home.data.repository.ProductRepositoryImpl
import pe.edu.upc.easyvet.home.data.remote.ProductService
import pe.edu.upc.easyvet.home.di.LocalModule.provideProductDao
import pe.edu.upc.easyvet.home.di.RemoteModule.provideProductService
import pe.edu.upc.easyvet.home.domain.repository.ProductRepository

@Module
@InstallIn(ViewModelComponent::class)

interface RepositoryModule {

    @Binds
    fun provideProductRepository(
        productRepositoryImpl: ProductRepositoryImpl
    ): ProductRepository
}