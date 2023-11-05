package com.stepan.pizza

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.stepan.pizza.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        navView.setupWithNavController(navController)

        hardCodeNavBar()
    }

    private fun hardCodeNavBar() {
        val yourData: List<String> = listOf("Москва", "Томск", "Минск")
        val toolbar = findViewById<Toolbar>(R.id.my_toolbar)

        toolbar?.let {
            val spinner = it.findViewById<Spinner>(R.id.spinnerCity)
            spinner?.let {
                val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, yourData)
                it.adapter = adapter
            }
        }
    }
}