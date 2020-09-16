package com.tromian.shoppinglist.data.repositories

import com.tromian.shoppinglist.data.ShoppingDatabase
import com.tromian.shoppinglist.data.entities.ShoppingItem

class ShoppingRepository(private val db: ShoppingDatabase) {

    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)
    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)
    fun getAllItems() = db.getShoppingDao().getAllShopingItems()
}