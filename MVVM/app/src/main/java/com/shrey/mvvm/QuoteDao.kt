package com.shrey.mvvm

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

// Data Access Object (DAO) interface for the Quote entity
@Dao
interface QuoteDao {

    // Insert a quote into the database
    @Insert
    suspend fun insertQuotes(quote: Quote)

    // Retrieve all quotes from the database
    @Query("SELECT * FROM quote")
    fun getQuotes() : LiveData<List<Quote>>

}
