package com.example.instagramclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.instagramclone.databinding.ActivityMainBinding
import com.example.instagramclone.fragment.ExploreFragment
import com.example.instagramclone.fragment.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getFragments(HomeFragment())

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home_button -> getFragments(HomeFragment())
                R.id.search_button -> getFragments(ExploreFragment())

                else -> {

                }
            }
            true
        }
    }

    private fun getFragments(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_data, fragment)
        fragmentTransaction.commit()
    }

}