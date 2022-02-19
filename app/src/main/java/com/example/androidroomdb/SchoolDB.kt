package com.example.androidroomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidroomdb.entities.Director
import com.example.androidroomdb.entities.School
import com.example.androidroomdb.entities.Student
import com.example.androidroomdb.entities.Subject
import com.example.androidroomdb.entities.relations.StudentSubjectCrossRef

/**
 * We must specify all the entities of the database. It also includes the cross ref entities.
 * */
@Database(
    entities = [
        Student::class,
        Subject::class,
        School::class,
        Director::class,
        StudentSubjectCrossRef::class
    ],
    version = 1
)
abstract class SchoolDB: RoomDatabase() {

    abstract val schoolDAO: SchoolDAO

    companion object {

        /**
         * @Volatile annotation ensures that whenever the database instance is changed,
         * the changes are reflected immediately to all the other threads using it.
         * */
        @Volatile
        private var INSTANCE: SchoolDB? = null

        fun getInstance(context: Context): SchoolDB {
            synchronized(this) {
                // synchronized block to prevent creation of two database instances
                // by using two different threads.
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDB::class.java,
                    "school_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}