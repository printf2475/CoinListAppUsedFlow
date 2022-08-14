package com.example.coin_list_app_used_flow.util

import androidx.recyclerview.widget.DiffUtil
import com.example.coin_list_app_used_flow.domain.model.CoinData

class DiffUtilCallback(private val oldList: List<CoinData>, private val newList: List<CoinData>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return  oldItem.closing_price == newItem.closing_price
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]
}