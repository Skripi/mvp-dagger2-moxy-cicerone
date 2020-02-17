package skripa.ru.fuunymoments.presentation.base.mvp

import androidx.annotation.CallSuper
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.plusAssign

abstract class BasePresenter<View : BaseView> : MvpPresenter<View>(){

    private val autoDisposableOnDestroy = CompositeDisposable()

    protected fun Disposable.autoDisposeOnDestroy(): Disposable {
        autoDisposableOnDestroy += this
        return this
    }

    @CallSuper
    override fun onDestroy() {
        autoDisposableOnDestroy.dispose()
    }

}