package skripa.ru.fuunymoments.extensions

import android.view.View

fun View.show(display: Boolean = true){ visibility = if (display) View.VISIBLE else View.GONE }

fun View.hide(display: Boolean = true){ show(!display) }

fun View.toggle() {
    val state = visibility == View.GONE || visibility == View.INVISIBLE
    show(state)
}



