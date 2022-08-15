package com.example.coin_list_app_used_flow.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coin_list_app_used_flow.domain.model.CoinData
import com.example.coin_list_app_used_flow.domain.model.NewsItem
import com.example.coin_list_app_used_flow.domain.useCase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCases: UseCases
    ) : ViewModel() {

    private val _coinList = MutableLiveData<List<CoinData>>()
    val coinList : LiveData<List<CoinData>> get() = _coinList

    private val _newsList = MutableLiveData<List<NewsItem>>()
    val newsList : LiveData<List<NewsItem>> get() = _newsList


    private val _mainEvent = MutableLiveData<MainEvent>()
    val mainEvent : LiveData<MainEvent> get() = _mainEvent

    //코루틴 안에서 Exception이 발생하면 coroutineExceptionHandler에서 처리할수있음
    private var  coroutineExceptionHandler : CoroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        when(throwable){
            is Exception -> {
                _mainEvent.postValue(MainEvent.Exception("리스트 로드 실패"))
                Log.e("Exeption", throwable.message.toString())
            }
        }
    }

    init {
        loadCoinList()
        laodNewsList()
    }





    fun loadCoinList() = viewModelScope.launch(coroutineExceptionHandler) {
       useCases.loadCoinList.loadCoinList().collect{
            _coinList.postValue(it)
        }
    }

    fun laodNewsList() = viewModelScope.launch(coroutineExceptionHandler) {
        val newsList = useCases.loadNewsList.loadNewsList()
        _newsList.postValue(newsList)
    }

    sealed class MainEvent {
        data class Exception(val message: String) : MainEvent()
    }
}