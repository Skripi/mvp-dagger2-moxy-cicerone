package skripa.ru.fuunymoments.di.module

import dagger.Module
import dagger.Provides
import skripa.ru.fuunymoments.di.FunnyMomentsApplication

@Module
class AppModule {

    @Provides
    fun provideContext(application: FunnyMomentsApplication)
            = application.applicationContext!!

}