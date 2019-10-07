package com.miemdynamics.gnurobot.data.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName="servo_table")
data class Servo(
    @PrimaryKey
    val id: Int,
    val angle: Int,
    val maxAngle: Int
)