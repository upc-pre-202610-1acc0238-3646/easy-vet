package pe.edu.upc.easyvet.home.di

import androidx.room.Room
import pe.edu.upc.easyvet.MyApplication
import pe.edu.upc.easyvet.home.data.local.AppDatabase

object LocalModule {

    fun provideAppDatabase(): AppDatabase {
        return Room.databaseBuilder(
            context = MyApplication.instance.applicationContext,
            klass = AppDatabase::class.java,
            name = "easy-vet.db"
        ).build()
    }

    fun provideProductDao(appDatabase: AppDatabase = provideAppDatabase()) =
        appDatabase.productDao()

}