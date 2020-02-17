package skripa.ru.fuunymoments.presentation.app

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router

@Module
class AppScreanModule {

    @Provides
    fun providePresenter(router: Router): AppPresenter
            = AppPresenter(router)

}