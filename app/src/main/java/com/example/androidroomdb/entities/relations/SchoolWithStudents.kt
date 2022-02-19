package com.example.androidroomdb.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.androidroomdb.entities.School
import com.example.androidroomdb.entities.Student

/**
 * one-to-many relation: As one school can have many students.
 * Naming convention: [table1 name]With[table2 name]
 * Note: It is not an entity but a relation between two entities.
 * */
data class SchoolWithStudents(
    // @Embedded annotation inserts all the fields of school class
    // internally for the room.
    @Embedded
    val school: School,

    // a) parentColumn refers to the primary key column of the first table i.e. School
    // b) entityColumn refers to the foreign key column of the second table i.e. Student
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val student: List<Student>
)
