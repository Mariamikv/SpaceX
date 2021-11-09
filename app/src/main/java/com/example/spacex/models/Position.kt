package com.example.spacex.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Position(
    val latitude: @RawValue Any?,
    val longitude: @RawValue Any?
):Parcelable