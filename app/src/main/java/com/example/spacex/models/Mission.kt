package com.example.spacex.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Mission(
    val flight: Int?,
    val name: String?
): Parcelable