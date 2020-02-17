package skripa.ru.fuunymoments.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import skripa.ru.fuunymoments.presentation.app.AppActivity

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun bindAppActivity(): AppActivity
}
