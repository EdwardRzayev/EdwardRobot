package com.miemdynamics.gnurobot.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.miemdynamics.gnurobot.data.network.response.ServoResponse
import com.miemdynamics.gnurobot.data.request.FakeServoGet
import com.miemdynamics.gnurobot.internal.NoConnectivityException

class ServoNetworkDataSourceImpl(
    private val fakeServoApiService: FakeServoApiService
) : ServoNetworkDataSource {

    private val _downloadedServo = MutableLiveData<ServoResponse>()
    override val downloadedServo: LiveData<ServoResponse>
        get() = _downloadedServo

    override suspend fun fetchServo(id: Int) {
        try {
            val fetchedServo = fakeServoApiService
                .getServo(FakeServoGet(id))
                .await()
            _downloadedServo.postValue(fetchedServo)
        } catch (e: NoConnectivityException) {
            Log.e("Connectivity", "No internet connection", e)
        }
    }
}