package com.example.androidroomdb.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.androidroomdb.entities.Student
import com.example.androidroomdb.entities.Subject

/**
 * Breaking many-to-many relation into one-to-many relation for each entity.
 *
 * one-to-many relation: Any student can be enrolled to many subjects.
 * Naming convention: [table1 name]With[table2 name]
 * Note: It is not an entity but a relation between two entities.
 * */
data class StudentWithSubjects(
    // @Embedded annotation inserts all the fields of student class
    // internally for the room.
    @Embedded
    val student: Student,

    // a) parentColumn refers to the primary key column of the first table i.e. Student
    // b) entityColumn refers to the foreign key column of the second table i.e. Subject
    // c) associateBy specifies the class that contains the relation between the two tables
    // having many-to-many relation.
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects: List<Subject>
)
