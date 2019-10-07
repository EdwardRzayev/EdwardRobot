package com.miemdynamics.gnurobot.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.miemdynamics.gnurobot.data.entity.Servo

@Dao
interface ServoDao {
    @Insert(onConflict=OnConflictStrategy.REPLACE)
    fun upsert(servo: Servo)

    @Query("select * from servo_table where id = :id")
    fun getServo(id: Int): LiveData<Servo>
}