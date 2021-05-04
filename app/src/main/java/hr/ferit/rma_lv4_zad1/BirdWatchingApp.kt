package hr.ferit.rma_lv4_zad1

import android.app.Application
import android.content.Context
import hr.ferit.rma_lv4_zad1.di.appModule
import hr.ferit.rma_lv4_zad1.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BirdWatchingApp: Application() {

    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this

        startKoin{
            androidContext(this@BirdWatchingApp)
            modules(appModule, viewModelModule)
        }
    }
}