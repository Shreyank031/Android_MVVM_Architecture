package com.shrey.mvvm

import androidx.lifecycle.LiveData

//It takes a DAO as constructor to assess the data
class QuoteRepository(private val quoteDao: QuoteDao) {

    //Define the same methods which you have defined in DAO
    suspend fun insertQuotes(quote: Quote) {
        quoteDao.insertQuotes(quote)
    }

    fun getQuotes(): LiveData<List<Quote>> {
        return quoteDao.getQuotes()
    }
}