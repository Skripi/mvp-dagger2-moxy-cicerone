package skripa.ru.fuunymoments.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import skripa.ru.fuunymoments.presentation.testFragment.TestFragment
import skripa.ru.fuunymoments.presentation.testFragment.TestModule

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector(modules = [TestModule::class])
    abstract fun bindTestFragment(): TestFragment

}