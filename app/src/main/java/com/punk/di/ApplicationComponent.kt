package com.punk.di

import android.content.Context
import com.punk.home.HomeActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class,DatabaseModule::class])
interface ApplicationComponent {
    fun inject(homeActivity: HomeActivity)

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context:Context) : ApplicationComponent
    }
}