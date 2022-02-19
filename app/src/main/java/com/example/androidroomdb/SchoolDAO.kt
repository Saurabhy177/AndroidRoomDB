package com.example.androidroomdb

import androidx.room.*
import com.example.androidroomdb.entities.Director
import com.example.androidroomdb.entities.School
import com.example.androidroomdb.entities.Student
import com.example.androidroomdb.entities.Subject
import com.example.androidroomdb.entities.relations.*

@Dao
interface SchoolDAO {

    // In case we are inserting a school that already exists, then it will replace the school.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(crossRef: StudentSubjectCrossRef)

    // @Transaction annotation makes sure that the query performed is a thread-safe operation
    // using atomic transactions.
    // Passing on the parameter "schoolName" in the query using colon (:)
    @Transaction
    @Query("SELECT * FROM school WHERE schoolName= :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String): List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName= :schoolName")
    suspend fun getSchoolWithStudents(schoolName: String): List<SchoolWithStudents>

    @Transaction
    @Query("SELECT * FROM subject WHERE subjectName= :subjectName")
    suspend fun getStudentsOfSubject(subjectName: String): List<SubjectWithStudents>

    @Transaction
    @Query("SELECT * FROM student WHERE studentName= :studentName")
    suspend fun getSubjectsOfStudent(studentName: String): List<StudentWithSubjects>
}