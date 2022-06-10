package com.fictivestudios.tafcha.Utils

class Constants {
    companion object {

        const val IS_USER = "is_user"

        fun isValidEmail(str: String): Boolean{
            return android.util.Patterns.EMAIL_ADDRESS.matcher(str).matches()
        }
    }
}