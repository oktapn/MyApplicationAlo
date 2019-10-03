package com.example.myapplication.utils

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.example.myapplication.model.Login
import com.example.myapplication.ui.login.LoginActivity
import com.example.myapplication.utils.Constant.IS_LOGIN
import com.example.myapplication.utils.Constant.KEY_PASSWORD
import com.example.myapplication.utils.Constant.KEY_USERNAME
import com.example.myapplication.utils.Constant.PREF_NAME

class SharedPrefferences(private var context: Context) {

    private var sharedPreferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    private var editor: SharedPreferences.Editor

    init {
        editor = sharedPreferences.edit()
        editor.apply()
    }

    fun createLoginTemp(login: Login) {
        editor.putString(KEY_USERNAME, login.username)
        editor.putString(KEY_PASSWORD, login.pass)
        editor.putBoolean(IS_LOGIN, true)
        editor.commit()
    }

    val login: Login
        get() {
            val login = Login()
            login.username = sharedPreferences.getString(KEY_USERNAME, null)
            login.pass = sharedPreferences.getString(KEY_PASSWORD, null)
            return login
        }

    val isLoggedIn: Boolean
        get() = sharedPreferences.getBoolean(IS_LOGIN, false)

    fun logoutUser() {
        editor.clear()
        editor.commit()

        val intent = Intent(context, LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startActivity(intent)
    }

}