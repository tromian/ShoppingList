package com.tromian.shoppinglist.ui.shopinglist

import com.tromian.shoppinglist.data.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClisked(item: ShoppingItem)
}