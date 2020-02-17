package skripa.ru.fuunymoments.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import skripa.ru.fuunymoments.di.FunnyMomentsApplication
import skripa.ru.fuunymoments.di.module.*
import skripa.ru.fuunymoments.presentation.app.AppScreanModule
import skripa.ru.fuunymoments.presentation.testFragment.TestModel
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AndroidInjectionModule::class,

    AppModule::class,
    NavigationModule::class,
    ActivityBuilder::class,
    RepositoryModule::class,
    NetworkModule::class,

    AppScreanModule::class,

    TestModel::class
])
interface AppComponent : AndroidInjector <FunnyMomentsApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: FunnyMomentsApplication): Builder

        fun build(): AppComponent
    }
}