package com.example.maxime.test_jetpack

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI

import com.example.maxime.test_jetpack.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    lateinit var drawer: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val host = supportFragmentManager.findFragmentById(R.id.mainFragment) as NavHostFragment? ?: return
        drawer = findViewById(R.id.drawerLayout)
        NavigationUI.setupActionBarWithNavController(this, host.navController, drawer)
    }

    override fun onSupportNavigateUp(): Boolean {
        // TODO java.lang.IllegalArgumentException: No drawer view found with gravity LEFT
        return NavigationUI.navigateUp(drawer, Navigation.findNavController(this, R.id.mainFragment))
    }
}