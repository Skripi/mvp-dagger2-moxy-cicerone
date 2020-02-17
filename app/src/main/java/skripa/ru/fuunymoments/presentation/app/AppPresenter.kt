package skripa.ru.fuunymoments.presentation.app

import com.arellomobile.mvp.InjectViewState
import ru.terrakok.cicerone.Router
import skripa.ru.fuunymoments.di.Screens
import skripa.ru.fuunymoments.presentation.base.mvp.BasePresenter

@InjectViewState
class AppPresenter(
    private val router: Router
) : BasePresenter<AppView>() {

    fun beginWork(){
        router.newRootChain(Screens.TestScreen)
    }
}