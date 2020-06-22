package skripa.ru.fuunymoments.presentation.testFragment

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router

@Module
class TestModule {

    @Provides
    fun providePresenter(router: Router): TestPresenter
            = TestPresenter(router)
}