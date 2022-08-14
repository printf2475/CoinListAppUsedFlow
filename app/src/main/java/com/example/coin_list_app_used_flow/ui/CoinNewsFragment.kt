package com.example.coin_list_app_used_flow.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import com.example.coin_list_app_used_flow.adapter.NewsRecyclerAdapter
import com.example.coin_list_app_used_flow.databinding.FragmentCoinNewsBinding

class CoinNewsFragment : Fragment() {
    private lateinit var binding : FragmentCoinNewsBinding
    private val mainViewModel : MainViewModel by activityViewModels()

    private lateinit var adapter: NewsRecyclerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCoinNewsBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }

        initRecycler()
        initObserver()
        return binding.root
    }


    private fun initObserver() {
        mainViewModel.coinList.observe(requireActivity()){
            binding.rvNews.visibility = View.VISIBLE
            binding.tvEmpty.visibility = View.GONE
        }
    }

    private fun initRecycler() {
        adapter = NewsRecyclerAdapter()
        binding.rvNews.adapter = adapter
        mainViewModel.newsList.observe(viewLifecycleOwner){
            adapter.setList(it)
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = CoinNewsFragment()
    }
}