package com.shrey.mvvm

import androidx.room.Entity
import androidx.room.PrimaryKey

// Entity class representing a quote table in the database
@Entity(tableName = "quote")
data class Quote(
    // Primary key for the quote entity, auto-generated
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    // Text of the quote
    val text: String,
    // Author of the quote
    val author: String
)
