package com.example.spacex.api.di

import com.example.spacex.ui.detail.DetailFragmentViewModel
import com.example.spacex.ui.home.HomeViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel


val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailFragmentViewModel(get()) }
}