package com.example.coin_list_app_used_flow.adapter

import android.graphics.Color
import android.widget.TextView
import androidx.databinding.BindingAdapter

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("assets_buy_state_bind")
    fun assetBuyStateBinding(view: TextView, value: Int) {
        if (value == 1) {
            view.setTextColor(Color.BLUE)
            view.text = "구매 가능"
        } else {
            view.setTextColor(Color.RED)
            view.text = "구매 불가"
        }
    }

    @JvmStatic
    @BindingAdapter("assets_sell_state_bind")
    fun assetSellStateBinding(view: TextView, value: Int) {
        if (value == 1) {
            view.setTextColor(Color.BLUE)
            view.text = "판매 가능"
        } else {
            view.setTextColor(Color.RED)
            view.text = "판매 불가"
        }
    }
}