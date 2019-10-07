package com.miemdynamics.gnurobot.data.request


import com.google.gson.annotations.SerializedName

// TODO: DELET THIS

data class FakeServoGet(
    @SerializedName("servo_id")
    val id: Int
)