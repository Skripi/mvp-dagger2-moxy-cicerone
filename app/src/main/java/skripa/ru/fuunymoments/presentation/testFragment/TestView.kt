package skripa.ru.fuunymoments.presentation.testFragment

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import skripa.ru.fuunymoments.presentation.base.mvp.BaseView

@StateStrategyType(AddToEndSingleStrategy::class)
interface TestView : BaseView {
}