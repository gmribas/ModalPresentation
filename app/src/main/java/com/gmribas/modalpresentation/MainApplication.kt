package com.gmribas.modalpresentation

import android.app.Application
import com.gmribas.modalpresentation.di.repositoryModule
import com.gmribas.modalpresentation.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MainApplication)
            modules(
                listOf(viewModelModule, repositoryModule)
            )
        }
    }
}