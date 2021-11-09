package com.example.spacex.api.di

import com.example.spacex.api.request.ShipService
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single(createdAtStart = false) {
        get<Retrofit>().create(ShipService::class.java)
    }
}