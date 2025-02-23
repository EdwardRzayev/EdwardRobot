package com.miemdynamics.gnurobot.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.miemdynamics.gnurobot.data.entity.Servo

@Database(
    entities = [Servo::class],
    version = 1
)
abstract class ServoDatabase : RoomDatabase() {
    abstract fun servoDao(): ServoDao

    companion object {
        @Volatile private var instance: ServoDatabase? = null
        private val Lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(Lock) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                ServoDatabase::class.java,
                "servo.db")
                .build()
    }
}