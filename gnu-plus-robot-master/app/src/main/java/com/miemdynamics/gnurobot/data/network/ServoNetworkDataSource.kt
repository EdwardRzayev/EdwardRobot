package com.miemdynamics.gnurobot.data.network

import androidx.lifecycle.LiveData
import com.miemdynamics.gnurobot.data.network.response.ServoResponse

interface ServoNetworkDataSource {
    val downloadedServo: LiveData<ServoResponse>

    suspend fun fetchServo(
        id: Int
    )
}