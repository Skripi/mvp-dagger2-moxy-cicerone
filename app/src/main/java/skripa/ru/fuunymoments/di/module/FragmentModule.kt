package skripa.ru.fuunymoments.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import skripa.ru.fuunymoments.presentation.testFragment.TestFragment

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun bindTestFragment(): TestFragment

}