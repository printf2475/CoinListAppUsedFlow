package com.example.coin_list_app_used_flow.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView.ItemAnimator
import androidx.recyclerview.widget.SimpleItemAnimator
import com.example.coin_list_app_used_flow.adapter.CoinRecyclerAdapter
import com.example.coin_list_app_used_flow.databinding.FragmentCoinListBinding


class CoinListFragment : Fragment() {
    private lateinit var binding : FragmentCoinListBinding
    private val mainViewModel : MainViewModel by activityViewModels()

    private lateinit var adapter: CoinRecyclerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoinListBinding.inflate(inflater, container, false).apply {
                lifecycleOwner = viewLifecycleOwner
            }

        initRecycler()
        initObserver()
        return binding.root
    }

    private fun initObserver() {
        mainViewModel.coinList.observe(requireActivity()){
            binding.rvCoin.visibility = View.VISIBLE
            binding.tvEmpty.visibility = View.GONE
        }
    }

    private fun initRecycler() {
        adapter = CoinRecyclerAdapter()
        binding.rvCoin.adapter = adapter
        mainViewModel.coinList.observe(viewLifecycleOwner){
            adapter.setList(it)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = CoinListFragment()
    }
}