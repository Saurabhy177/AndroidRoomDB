package com.example.androidroomdb.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.androidroomdb.entities.Director
import com.example.androidroomdb.entities.School

/**
 * one-to-one relation: As one school has only one director and vice-versa.
 * Naming convention: [table1 name]And[table2 name]
 * Note: It is not an entity but a relation between two entities.
 * */
data class SchoolAndDirector(
    // @Embedded annotation inserts all the fields of school class
    // internally for the room.
    @Embedded
    val school: School,

    // a) parentColumn refers to the primary key column of the first table i.e. School
    // b) entityColumn refers to the foreign key column of the second table i.e. Director
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)
