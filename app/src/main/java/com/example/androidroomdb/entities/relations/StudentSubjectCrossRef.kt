package com.example.androidroomdb.entities.relations

import androidx.room.Entity

/**
 * many-to-many relation:
 * As any student can be enrolled into many subjects and any subject can also have many students.
 * Naming convention: [table1 name][table2 name]CrossRef
 *
 * When we enroll a student in any subject, then we must insert a record in this table
 * to ensure the student - subject relation.
 *
 * Note: In a cross ref entity, only the combination of columns is unique so specifying
 * collection of those columns as primary keys in entity annotation.
 * */
@Entity(primaryKeys = ["studentName", "subjectName"])
data class StudentSubjectCrossRef(
    // The primary key of the first table i.e. Student table
    val studentName: String,
    // The primary key of the second table i.e. Subject table
    val subjectName: String
)
