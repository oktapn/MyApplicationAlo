package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private val SELECTED_MENU = "selected_menu"
    private var navView: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        navView = findViewById(R.id.nav_view)
        navView!!.setOnNavigationItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.action_home -> {
                    fragment = HomeFragment()
                }
                R.id.action_profile -> {
                    fragment = ProfileFragment()
                }
            }
            if (fragment != null) {
                supportFragmentManager
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.container, fragment)
                    .commit()
            }
            true
        }
        if (savedInstanceState != null) {
            savedInstanceState.getInt(SELECTED_MENU)
        } else {
            navView?.selectedItemId = R.id.action_home
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SELECTED_MENU, navView!!.selectedItemId)
    }

}
