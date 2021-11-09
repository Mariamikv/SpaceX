package com.example.spacex.api.di

import com.example.spacex.api.repository.ShipRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { ShipRepository(get()) }
}