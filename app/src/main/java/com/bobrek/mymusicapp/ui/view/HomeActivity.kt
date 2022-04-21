package com.bobrek.mymusicapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.bobrek.mymusicapp.R
import com.bobrek.mymusicapp.databinding.ActivityHomeBinding
import com.bobrek.mymusicapp.databinding.ActivityMainBinding
import com.bobrek.mymusicapp.di.SpotifyConstants
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private var homeFragment: HomeFragment = HomeFragment()
    private var favoritesFragment: FavoritesFragment = FavoritesFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    loadFragment(homeFragment)
                    true
                }
                R.id.favoritesFragment -> {
                    loadFragment(favoritesFragment)
                    true
                }
                else -> false
            }
        }

        loadFragment(homeFragment)
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit()
    }
}