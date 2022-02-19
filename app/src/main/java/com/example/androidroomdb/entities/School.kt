package com.example.androidroomdb.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * The @Entity annotation is used to declare a class as SQL table.
 * If table name is not set, it uses the class name as default table name.
 * */
@Entity
data class School(
    @PrimaryKey(autoGenerate = false)
    val schoolName: String
)
