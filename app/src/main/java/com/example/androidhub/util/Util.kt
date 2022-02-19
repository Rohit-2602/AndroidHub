package com.example.androidhub.util

object Util {

    fun isEmailValid(text: String?): Boolean {
        return text != null && android.util.Patterns.EMAIL_ADDRESS.matcher(text).matches()
    }

}