package skripa.ru.fuunymoments.di

import android.annotation.SuppressLint
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import skripa.ru.fuunymoments.di.component.DaggerAppComponent

@SuppressLint("Registered")
class FunnyMomentsApplication : DaggerApplication() {

    override fun onCreate()  = super.onCreate()

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder().application(this).build()
}