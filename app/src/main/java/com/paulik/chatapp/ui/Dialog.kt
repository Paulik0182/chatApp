package com.paulik.chatapp.ui

sealed class SystemAlert(val message: String, val runnable: Runnable? = null) {

    // перечисляются все потомки класса
    class ShowAlert(message: String) : SystemAlert(message)

    class ShowCloseAlert(message: String, runnable: Runnable? = null) :
        SystemAlert(message, runnable)
}