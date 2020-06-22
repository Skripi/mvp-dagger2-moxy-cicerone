package skripa.ru.fuunymoments.presentation.base.fragment

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.moxy.MvpAppCompatFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.plusAssign
import skripa.ru.fuunymoments.presentation.base.mvp.BaseView
import javax.inject.Inject

abstract class BaseFragment : MvpAppCompatFragment(), BaseView, HasAndroidInjector {

    protected abstract val layoutRes: Int

    /*@Inject
    lateinit var childFragmentInjector: DispatchingAndroidInjector<Fragment>*/

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreateView(inflater: LayoutInflater,
                              viewGroup: ViewGroup?,
                              savedInstanceState: Bundle?): View?
            = inflater.inflate(layoutRes, viewGroup, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    protected abstract fun initView()

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    open fun onBackPressed(){}

    //Auto Disposable

    private val autoDisposableOnPause = CompositeDisposable()
    private val autoDisposableOnStop = CompositeDisposable()
    private val autoDisposableOnDestroy = CompositeDisposable()

    protected fun Disposable.autoDisposeOnPause(): Disposable {
        autoDisposableOnPause += this
        return this
    }

    protected fun Disposable.autoDisposeOnStop(): Disposable {
        autoDisposableOnStop += this
        return this
    }

    protected fun Disposable.autoDisposeOnDestroy(): Disposable {
        autoDisposableOnDestroy += this
        return this
    }

    override fun onPause() {
        super.onPause()
        // use clear() instead of dispose to able reuse the same object again
        autoDisposableOnPause.clear()
    }

    override fun onStop() {
        super.onStop()
        // use clear() instead of dispose to able reuse the same object again
        autoDisposableOnStop.clear()
    }

    override fun onDestroy() {
        super.onDestroy()
        autoDisposableOnDestroy.dispose()
    }
}