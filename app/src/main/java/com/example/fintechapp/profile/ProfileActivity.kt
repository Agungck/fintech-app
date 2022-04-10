package com.example.fintechapp.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.fintechapp.R

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        title = "Menu Profile"
        val nama = findViewById<TextView>(R.id.tvnama)
        val nim = findViewById<TextView>(R.id.tvnim)
        val mail = findViewById<TextView>(R.id.tvemail)
        val nope = findViewById<TextView>(R.id.tvno)
        val jk = findViewById<TextView>(R.id.tvjk)
        val prodi = findViewById<TextView>(R.id.tvprodi)
        val org = findViewById<CheckBox>(R.id.tvorg)
        val status = findViewById<CheckBox>(R.id.tvstatus)

        val bukabundle = intent.extras
        if (bukabundle != null){
            nama.setText(bukabundle.getString("nama"))
            nim.setText(bukabundle.getString("nim"))
            mail.setText(bukabundle.getString("mail"))
            nope.setText(bukabundle.getString("nope"))
            jk.setText(bukabundle.getString("jkel"))
            prodi.setText(bukabundle.getString("prodi"))
            org.setText(bukabundle.getString("org"))
            status.setText(bukabundle.getString("status"))
        }

    }
}