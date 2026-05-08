package pe.edu.upc.easyvet.home.di

import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import pe.edu.upc.easyvet.MyApplication
import pe.edu.upc.easyvet.home.data.local.AppDatabase
import pe.edu.upc.easyvet.home.data.local.ProductDao

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideAppDatabase(): AppDatabase {
        return Room.databaseBuilder(
            context = MyApplication.instance.applicationContext,
            klass = AppDatabase::class.java,
            name = "easy-vet.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideProductDao(appDatabase: AppDatabase ) =
        appDatabase.productDao()

}