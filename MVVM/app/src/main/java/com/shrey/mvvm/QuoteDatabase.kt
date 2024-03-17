package com.shrey.mvvm

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Database class representing the quote database
@Database(entities = [Quote::class], version = 1)
abstract class QuoteDatabase : RoomDatabase() {

    // Abstract method to retrieve the DAO (Data Access Object) for the Quote entity
    abstract fun quoteDao(): QuoteDao

    // Companion object to provide methods for accessing the database instance
    companion object {
        // Volatile variable to ensure visibility of INSTANCE to other threads
        @Volatile
        private var INSTANCE: QuoteDatabase? = null

        // Function to get a database instance
        fun getDatabase(context: Context): QuoteDatabase {
            // If the database instance is null, create a new instance
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        QuoteDatabase::class.java,
                        "quotes_db"
                    )
                        // To prepopulate the data from a file named quotes.db in the assets folder
                        .createFromAsset("quotes.db")
                        .build()
                }
            }
            // Return the database instance
            return INSTANCE!!
        }
    }
}
