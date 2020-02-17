package skripa.ru.fuunymoments.di

import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen
import skripa.ru.fuunymoments.presentation.testFragment.TestFragment

object Screens {

    object TestScreen : SupportAppScreen() {
        override fun getFragment(): Fragment
            = TestFragment()
    }
}