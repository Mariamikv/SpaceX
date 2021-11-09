package com.example.spacex.models.launches


import com.google.gson.annotations.SerializedName

data class Launches(
    @SerializedName("crew")
    val crew: Any?,
    @SerializedName("details")
    val details: String?,
    @SerializedName("flight_number")
    val flightNumber: Any?,
    @SerializedName("is_tentative")
    val isTentative: Boolean?,
    @SerializedName("launch_date_local")
    val launchDateLocal: String?,
    @SerializedName("launch_date_unix")
    val launchDateUnix: Any?,
    @SerializedName("launch_date_utc")
    val launchDateUtc: String?,
    @SerializedName("launch_failure_details")
    val launchFailureDetails: LaunchFailureDetails?,
    @SerializedName("launch_site")
    val launchSite: LaunchSite?,
    @SerializedName("launch_success")
    val launchSuccess: Boolean?,
    @SerializedName("launch_window")
    val launchWindow: Any?,
    @SerializedName("launch_year")
    val launchYear: String?,
    @SerializedName("links")
    val links: Links?,
    @SerializedName("mission_id")
    val missionId: List<Any>?,
    @SerializedName("mission_name")
    val missionName: String?,
    @SerializedName("rocket")
    val rocket: Rocket?,
    @SerializedName("ships")
    val ships: List<Any>?,
    @SerializedName("static_fire_date_unix")
    val staticFireDateUnix: Any?,
    @SerializedName("static_fire_date_utc")
    val staticFireDateUtc: String?,
    @SerializedName("tbd")
    val tbd: Boolean?,
    @SerializedName("telemetry")
    val telemetry: Telemetry?,
    @SerializedName("tentative_max_precision")
    val tentativeMaxPrecision: String?,
    @SerializedName("timeline")
    val timeline: Timeline?,
    @SerializedName("upcoming")
    val upcoming: Boolean?
)