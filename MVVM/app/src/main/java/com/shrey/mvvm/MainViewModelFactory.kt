package com.shrey.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

// Factory class to create MainViewModel instances
class MainViewModelFactory(private var quoteRepository: QuoteRepository) :
    ViewModelProvider.Factory {
    // Override the create method to instantiate MainViewModel
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // Return an instance of MainViewModel with the provided QuoteRepository
        return MainViewModel(quoteRepository) as T
    }
}
