package com.tromian.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tromian.shoppinglist.data.entities.ShoppingItem

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun getAllShopingItems(): LiveData<List<ShoppingItem>>
}