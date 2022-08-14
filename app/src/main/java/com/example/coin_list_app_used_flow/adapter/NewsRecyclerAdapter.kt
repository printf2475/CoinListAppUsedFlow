package com.example.coin_list_app_used_flow.adapter

import android.R
import android.text.method.TextKeyListener.clear
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.coin_list_app_used_flow.databinding.CoinListRowBinding
import com.example.coin_list_app_used_flow.databinding.CoinNewsRowBinding
import com.example.coin_list_app_used_flow.domain.model.CoinData
import com.example.coin_list_app_used_flow.domain.model.NewsItem
import com.example.coin_list_app_used_flow.util.DiffUtilCallback
import java.util.Collections.addAll


class NewsRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val itemList: MutableList<NewsItem> = ArrayList()

    inner class ViewHolder(private val binding: CoinNewsRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.model = itemList[position]
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): RecyclerView.ViewHolder {
        val binding = CoinNewsRowBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        (viewHolder as ViewHolder).bind(position)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun setList(list :List<NewsItem>) {
        list.let {
            itemList.clear()
            itemList.addAll(it)
            notifyDataSetChanged()
        }

    }
}