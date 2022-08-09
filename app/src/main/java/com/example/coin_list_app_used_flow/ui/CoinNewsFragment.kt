package com.example.coin_list_app_used_flow.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coin_list_app_used_flow.R

class CoinNewsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coin_news, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = CoinNewsFragment()
    }
}