package com.tromian.shoppinglist.ui.shopinglist

import androidx.lifecycle.ViewModel
import com.tromian.shoppinglist.data.entities.ShoppingItem
import com.tromian.shoppinglist.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repository: ShoppingRepository) : ViewModel(){

    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }
    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }
    fun getAllItems() = repository.getAllItems()

}