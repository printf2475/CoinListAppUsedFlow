package com.example.coin_list_app_used_flow.util

import androidx.recyclerview.widget.DiffUtil
import com.example.coin_list_app_used_flow.domain.model.CoinData

class DiffUtilCallback(private val oldList: List<CoinData>, private val newList: List<CoinData>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    // 먼저 호출하여 같은 객체인가 확인
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return  oldItem == newItem
    }
    // areItemsTheSame 메서드가 true이면 호출
    // 특정 변수가 같은가 확인 후 다르면 새로그림
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].closing_price == newList[newItemPosition].closing_price
}