package com.example.fintechapp.settings

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PatternMatcher
import android.util.Patterns
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.fintechapp.R
import com.example.fintechapp.profile.ProfileActivity
import java.lang.StringBuilder

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        title = "Menu Setting"
        val btnsave = findViewById<Button>(R.id.btnsave)
        val nama = findViewById<EditText>(R.id.nama)
        val nim = findViewById<EditText>(R.id.nim)
        val mail = findViewById<EditText>(R.id.email)
        val nope = findViewById<EditText>(R.id.no)
        val pass = findViewById<EditText>(R.id.password)
        val rgjk = findViewById<RadioGroup>(R.id.rdg)
        val spiner = findViewById<Spinner>(R.id.spinner)
        val amcc = findViewById<CheckBox>(R.id.amcc)
        val himsi = findViewById<CheckBox>(R.id.himsi)
        val bem = findViewById<CheckBox>(R.id.bem)
        val togglebtn = findViewById<ToggleButton>(R.id.togglebtn)

        btnsave.setOnClickListener{
            val cekjk = rgjk.checkedRadioButtonId
            val jk = findViewById<RadioButton>(cekjk)

            val org = StringBuilder()
            if(amcc.isChecked){
                org.append("AMCC\n")
            }
            if(himsi.isChecked){
                org.append("HIMSI\n")
            }
            if(bem.isChecked){
                org.append("BEM\n")
            }

            val bundle = Bundle()
            bundle.putString("nama",nama.text.toString())
            bundle.putString("nim",nim.text.toString())
            bundle.putString("mail",mail.text.toString())
            bundle.putString("nope",nope.text.toString())
            bundle.putString("jkel","${jk.text}")
            bundle.putString("prodi",spiner.selectedItem.toString())
            bundle.putString("org",org.toString())
            bundle.putString("status",togglebtn.text.toString())

            if (!Patterns.EMAIL_ADDRESS.matcher(mail.text.toString()).matches()){
                mail.error = "Masukkan Email Dengan Benar..!!"
            }
            else if (pass.length()==0){
                pass.error = "Password Tidak Boleh Kosong..!!"
            }
            else{
                val alertDialogBuilder = AlertDialog.Builder(this)
                alertDialogBuilder.setTitle("Peringatan..!!")
                alertDialogBuilder.setMessage("Apakah Data Anda Sudah Benar..??")
                    .setCancelable(false)
                    .setPositiveButton("Yes")
                    { dialogInterface, i ->
                        val intent = Intent (this, ProfileActivity::class.java)
                        intent.putExtras(bundle)
                        startActivity(intent)
                        Toast.makeText(this,"Data Profil berhasil Disimpan", Toast.LENGTH_SHORT).show()
                    }
                    .setNegativeButton("No"){
                        dialogInterface, i -> dialogInterface.cancel()
                    }
                val alertDialog = alertDialogBuilder.create()
                alertDialog.show()
            }

        }

    }
}