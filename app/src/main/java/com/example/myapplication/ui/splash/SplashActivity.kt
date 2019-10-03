package com.example.myapplication.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.ui.login.LoginActivity
import com.example.myapplication.ui.main.HomeActivity
import com.example.myapplication.utils.SharedPrefferences

class SplashActivity : AppCompatActivity() {

    private lateinit var session: SharedPrefferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        session = SharedPrefferences(this)
        Handler().postDelayed({
            if (session.isLoggedIn) {
                val mainIntent = Intent(this, HomeActivity::class.java)
                startActivity(mainIntent)
                finish()
            } else {
                val mainIntent = Intent(this, LoginActivity::class.java)
                startActivity(mainIntent)
                finish()
            }
            /* Create an Intent that will start the Menu-Activity. */

        }, 2000)
    }
}
