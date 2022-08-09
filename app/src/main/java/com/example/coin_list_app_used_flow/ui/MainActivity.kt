package com.example.coin_list_app_used_flow.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.onNavDestinationSelected

import androidx.navigation.ui.setupWithNavController
import com.example.coin_list_app_used_flow.R
import com.example.coin_list_app_used_flow.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initNavigation()
        initObserver()
    }

    private fun initObserver() {
        viewModel.mainEvent.observe(this){
            when(it){
                is MainViewModel.MainEvent.Exception ->
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun initNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        val navController = navHostFragment.navController
        binding.navBar.apply {
            setupWithNavController(navController)
            setOnItemSelectedListener {
                it.onNavDestinationSelected(navController)
                true
            }
            selectedItemId = R.id.list
        }



    }


}