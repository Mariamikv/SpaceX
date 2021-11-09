package com.example.spacex.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue


@Parcelize
data class Ship(
    val abs: Int?,
    val active: Boolean?,
    @SerializedName("attempted_landings")
    val attemptedLandings: @RawValue Any?,
    @SerializedName("class")
    val classX: Int?,
    @SerializedName("course_deg")
    val courseDeg: @RawValue Any?,
    @SerializedName("home_port")
    val homePort: String?,
    val image: String?,
    val imo: Int?,
    val missions: List<Mission>?,
    val mmsi: Int?,
    val position: Position?,
    val roles: List<String>?,
    @SerializedName("ship_id")
    val shipId: String?,
    @SerializedName("ship_model")
    val shipModel: @RawValue Any?,
    @SerializedName("ship_name")
    val shipName: String?,
    @SerializedName("ship_type")
    val shipType: String?,
    @SerializedName("speed_kn")
    val speedKn: @RawValue Any?,
    val status: String?,
    @SerializedName("successful_landings")
    val successfulLandings: @RawValue Any?,
    val url: String?,
    @SerializedName("weight_kg")
    val weightKg: Int?,
    @SerializedName("weight_lbs")
    val weightLbs: Int?,
    @SerializedName("year_built")
    val yearBuilt: Int?
): Parcelable