package com.shrey.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//Repository as a constructor for communication
class MainViewModel(private var quoteRepository: QuoteRepository) : ViewModel() {
    //Create methods to access repository
    fun getQuotes(): LiveData<List<Quote>> {
        return quoteRepository.getQuotes()
    }

    fun insertQuotes(quote: Quote) {
        //To use the coroutines, we'll use viewModelScope
        //IO -> As it's a input output operation
        viewModelScope.launch(Dispatchers.IO) {
            // Call the repository method to insert a quote
            quoteRepository.insertQuotes(quote)
        }
    }
}
