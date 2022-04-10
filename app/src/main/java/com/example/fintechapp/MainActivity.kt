package com.example.fintechapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.fintechapp.home.HomeFragment
import com.example.fintechapp.profile.ProfileFragment
import com.example.fintechapp.settings.SettingFragment

class MainActivity : AppCompatActivity() {

    private lateinit var btnHome : Button
    private lateinit var btnSeting : Button
    private lateinit var btnProfile : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnHome = findViewById(R.id.btn_home)
        btnProfile = findViewById(R.id.btn_profile)
        btnSeting = findViewById(R.id.btn_settings)

        btnHome.setOnClickListener {
        loadFragment(HomeFragment() )
        }

        btnProfile.setOnClickListener {
            loadFragment(ProfileFragment() )
        }

        btnHome.setOnClickListener {
            loadFragment(SettingFragment() )
        }
    }
    private fun loadFragment(fragment : Fragment ){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commitNow()
    }
}