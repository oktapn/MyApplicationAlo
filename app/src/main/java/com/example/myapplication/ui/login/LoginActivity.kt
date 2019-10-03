package com.example.myapplication.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.model.Login
import com.example.myapplication.ui.main.HomeActivity
import com.example.myapplication.utils.SharedPrefferences
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {

    private lateinit var session: SharedPrefferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        session = SharedPrefferences(this)
        BtnLogin.setOnClickListener {
            if (editText.text.isEmpty() || editText2.text.isEmpty()) {
                Toast.makeText(
                    baseContext,
                    "Üsername atau Password tidak boleh Kosong",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val Logins = Login()
                Logins.username = editText.text.toString()
                Logins.pass = editText2.text.toString()
                session.createLoginTemp(Logins)
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
