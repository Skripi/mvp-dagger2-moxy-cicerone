package skripa.ru.fuunymoments.presentation.base.activity

import android.content.Context
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.moxy.MvpAppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import skripa.ru.fuunymoments.R
import javax.inject.Inject

abstract class BaseActivity : MvpAppCompatActivity(), HasAndroidInjector {

    protected abstract val layoutRes: Int

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    protected val navigator: Navigator = SupportAppNavigator(this, R.id.mainContainer)

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)
        initView()
    }

    protected abstract fun initView()

    override fun onResumeFragments() {
        navigatorHolder.setNavigator(navigator)
        super.onResumeFragments()
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun dispatchTouchEvent(@NonNull event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            val view = currentFocus
            if (view != null) {
                val imm =
                    applicationContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }
        return super.dispatchTouchEvent(event)
    }
}