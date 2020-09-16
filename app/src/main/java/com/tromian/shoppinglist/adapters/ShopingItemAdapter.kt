package com.tromian.shoppinglist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tromian.shoppinglist.R
import com.tromian.shoppinglist.data.entities.ShoppingItem
import com.tromian.shoppinglist.ui.shopinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shoppin_item.view.*

class ShopingItemAdapter(
    var items : List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShopingItemAdapter.ShoppingViewHolder>(){

    inner class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shoppin_item,parent,false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItem = items[position]

        holder.itemView.tvName.text = curShoppingItem.name
        holder.itemView.tvAmount.text = "${curShoppingItem.amount}"

        holder.itemView.delete.setOnClickListener {
            viewModel.delete(curShoppingItem)
        }
        holder.itemView.plus.setOnClickListener {
            if (curShoppingItem.amount < 100){
                curShoppingItem.amount++
                viewModel.upsert(curShoppingItem)
            }
        }
        holder.itemView.minus.setOnClickListener {
            if (curShoppingItem.amount > 0){
                curShoppingItem.amount--
                viewModel.upsert(curShoppingItem)
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }


}