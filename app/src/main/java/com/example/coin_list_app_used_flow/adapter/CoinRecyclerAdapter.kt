package com.example.coin_list_app_used_flow.adapter

import android.R
import android.text.method.TextKeyListener.clear
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.coin_list_app_used_flow.databinding.CoinListRowBinding
import com.example.coin_list_app_used_flow.domain.model.CoinData
import com.example.coin_list_app_used_flow.util.DiffUtilCallback
import java.util.Collections.addAll


class CoinRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val itemList: MutableList<CoinData> = ArrayList()

    inner class ViewHolder(private val binding: CoinListRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.model = itemList[position]
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): RecyclerView.ViewHolder {
        val binding = CoinListRowBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        (viewHolder as ViewHolder).bind(position)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun setList(list :List<CoinData>) {
        list?.let {
            val diffCallback = DiffUtilCallback(this.itemList, list)
            val diffResult = DiffUtil.calculateDiff(diffCallback)

            this.itemList.run {
                clear()
                addAll(list)
                diffResult.dispatchUpdatesTo(this@CoinRecyclerAdapter)
            }
        }

    }
}