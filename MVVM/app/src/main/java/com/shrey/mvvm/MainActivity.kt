package com.shrey.mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.shrey.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflate the layout using DataBindingUtil
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Create an instance of QuoteDatabase and obtain its DAO
        val dao = QuoteDatabase.getDatabase(applicationContext).quoteDao()
        // Create an instance of QuoteRepository using the DAO
        val quoteRepository = QuoteRepository(dao)
        // Initialize MainViewModel with the QuoteRepository using ViewModelProvider
        mainViewModel = ViewModelProvider(
            this,
            MainViewModelFactory(quoteRepository)
        ).get(MainViewModel::class.java)

        // Observe changes in the list of quotes and update the UI accordingly
        mainViewModel.getQuotes().observe(this, Observer {
            // Update the text view with the list of quotes
            binding.txtQuotes.text = it.toString()
        })

        // Set a click listener for the button to insert a new quote
        binding.btnQuotes.setOnClickListener {
            // Create a new Quote object
            val quote = Quote(369, "This is Testing", "Testing Tester Chan")
            // Insert the quote using the ViewModel
            mainViewModel.insertQuotes(quote)
        }
    }
}
