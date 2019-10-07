package com.miemdynamics.gnurobot.data.repository

import androidx.lifecycle.LiveData
import com.miemdynamics.gnurobot.data.db.ServoDao
import com.miemdynamics.gnurobot.data.entity.Servo
import com.miemdynamics.gnurobot.data.network.ServoNetworkDataSource
import com.miemdynamics.gnurobot.data.network.response.ServoResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.threeten.bp.ZonedDateTime

// TODO: REIMPLEMENT FOR SERVOS

class ServoRepositoryImpl(
    private val servoDao: ServoDao,
    private val servoNetworkDataSource: ServoNetworkDataSource
) : ServoRepository {

    init {
        servoNetworkDataSource.downloadedServo.observeForever { newServo ->
            persistFetchedServo(newServo)
        }
    }

    override suspend fun getServo(id: Int): LiveData<out Servo> {
        return withContext(Dispatchers.IO) {
            return@withContext servoDao.getServo(id)
        }
    }

    private fun persistFetchedServo(fetchedServo: ServoResponse) {
        GlobalScope.launch(Dispatchers.IO) {
            servoDao.upsert(fetchedServo.servo)
        }
    }

    // TODO: USE getAllServos
    private suspend fun initServoData() {
        if (isFetchCurrentNeeded(ZonedDateTime.now().minusHours(1))) {
            fetchServoData()
        }
    }

    // TODO: USER getALLServos
    private suspend fun fetchServoData() {
        servoNetworkDataSource.fetchServo(0)
        servoNetworkDataSource.fetchServo(1)
        servoNetworkDataSource.fetchServo(2)
    }

    private fun isFetchCurrentNeeded(lastFetchTime: ZonedDateTime): Boolean {
        val time = ZonedDateTime.now().minusSeconds(1)
        return lastFetchTime.isBefore(time)
    }
}