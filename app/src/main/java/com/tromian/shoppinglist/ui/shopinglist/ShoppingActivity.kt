package com.tromian.shoppinglist.ui.shopinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.tromian.shoppinglist.R
import com.tromian.shoppinglist.adapters.ShopingItemAdapter
import com.tromian.shoppinglist.data.ShoppingDatabase
import com.tromian.shoppinglist.data.entities.ShoppingItem
import com.tromian.shoppinglist.data.repositories.ShoppingRepository
import kotlinx.android.synthetic.main.activity_shopping.*

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)

        val viewModel = ViewModelProvider(this,factory).get(ShoppingViewModel::class.java)

        val adapter = ShopingItemAdapter(listOf(),viewModel)

        rvShopping.layoutManager = LinearLayoutManager(this)
        rvShopping.adapter = adapter

        viewModel.getAllItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            AddShoppingItemDialog(this, object : AddDialogListener{
                override fun onAddButtonClisked(item: ShoppingItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }
    }
}