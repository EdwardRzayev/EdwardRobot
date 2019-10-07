package com.miemdynamics.gnurobot.data.network.response


import com.google.gson.annotations.SerializedName
import com.miemdynamics.gnurobot.data.entity.Servo

data class ServoResponse(
    @SerializedName("servo")
    val servo: Servo
)