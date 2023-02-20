package com.paulik.chatapp.utils

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.viewbinding.BuildConfig
import com.google.android.material.snackbar.Snackbar

fun View.snack(text: String) {
    Snackbar.make(
        this,
        text,
        Snackbar.ANIMATION_MODE_SLIDE
    ).show()
}

fun View.showSnackBar(
    text: String,
    actionText: String,
    length: Int = Snackbar.LENGTH_INDEFINITE,
    action: (View) -> Unit
) {
    Snackbar.make(this, text, length).setAction(actionText, action).show()
}

fun Context.toastMake(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

// только для дебажной версии
fun Context.showDebugToast(text: String) {
    if (BuildConfig.DEBUG) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}

fun View.show(): View {
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }
    return this
}

fun View.hide(): View {
    if (visibility != View.GONE) {
        visibility = View.GONE
    }
    return this
}

/**
 * экстеншен (для viewModel). Указываем mutable - возвращается версия MutableLiveData
 * это сделано чтобы во фрагменте случайно не изменить список (рельной безописности нет)
 */
fun <T> LiveData<T>.mutable(): MutableLiveData<T> {
    return this as MutableLiveData
}