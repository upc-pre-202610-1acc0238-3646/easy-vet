package pe.edu.upc.easyvet.home.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("select * from products")
    fun getProducts(): Flow<List<ProductEntity>>

    @Query("delete from products")
    suspend fun deleteAllProducts()

    @Insert
    suspend fun insertProducts(products: List<ProductEntity>)

}