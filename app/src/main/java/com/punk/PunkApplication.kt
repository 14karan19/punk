package com.punk

import android.app.Application
import android.content.Context
import com.punk.di.ApplicationComponent
import com.punk.di.DaggerApplicationComponent

class PunkApplication : Application() {

    companion object{
        var context: Context? = null
    }

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.factory().create(this)
        context = applicationContext
    }

    fun getAppContext(): Context {
        return context!!
    }
}
