package com.miemdynamics.gnurobot.data.repository

import androidx.lifecycle.LiveData
import com.miemdynamics.gnurobot.data.entity.Servo

interface ServoRepository {
    suspend fun getServo(id: Int): LiveData<out Servo>
}