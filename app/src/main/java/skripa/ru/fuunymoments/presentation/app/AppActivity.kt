package skripa.ru.fuunymoments.presentation.app

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import dagger.Lazy
import ru.terrakok.cicerone.Router
import skripa.ru.fuunymoments.R
import skripa.ru.fuunymoments.presentation.base.activity.BaseActivity
import skripa.ru.fuunymoments.presentation.base.fragment.BaseFragment
import javax.inject.Inject

open class AppActivity : BaseActivity(), AppView {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var daggerPresenter: Lazy<AppPresenter>

    @InjectPresenter
    lateinit var presenter: AppPresenter

    @ProvidePresenter
    fun providePresenter(): AppPresenter = daggerPresenter.get()

    override val layoutRes : Int = R.layout.activity_main

    private val currentFragment: BaseFragment?
        get() = supportFragmentManager.findFragmentById(R.id.mainContainer) as? BaseFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initView() {
        if (supportFragmentManager.fragments.isEmpty())
            presenter.beginWork()
    }

    override fun onBackPressed() { router.exit() }
}