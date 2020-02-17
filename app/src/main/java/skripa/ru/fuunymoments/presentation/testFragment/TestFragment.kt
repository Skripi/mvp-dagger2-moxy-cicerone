package skripa.ru.fuunymoments.presentation.testFragment

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import dagger.Lazy
import skripa.ru.fuunymoments.R
import skripa.ru.fuunymoments.presentation.base.fragment.BaseFragment
import javax.inject.Inject

class TestFragment : BaseFragment(), TestView {

    override val layoutRes = R.layout.fragment_test

    @Inject
    lateinit var daggerPresenter: Lazy<TestPresenter>

    @InjectPresenter
    lateinit var presenter: TestPresenter

    @ProvidePresenter
    fun providePresenter(): TestPresenter = daggerPresenter.get()

    override fun initView() {

    }

}