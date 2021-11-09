package com.example.spacex.app

import android.app.Application
import android.content.Context
import com.example.spacex.BuildConfig
import com.example.spacex.api.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class App: Application() {
    companion object{
        lateinit var instance: App
        //private var instance: App? = null

        fun applicationContext() : Context {
            return instance.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(listOf(
                viewModelModule,
                apiModule,
                repositoryModule,
                retrofitModule
            ))
        }
        instance = this
    }


}