package com.example.studikasus2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        val txtName = findViewById<TextView>(R.id.txtName)
        val txtPhoneNumber = findViewById<TextView>(R.id.txtPhoneNumber)
        val txtEmail = findViewById<TextView>(R.id.txtEmail)
        val txtGender = findViewById<TextView>(R.id.txtGender)
        val txtSpinner = findViewById<TextView>(R.id.txtSpinner)
        val txtSertifikat = findViewById<TextView>(R.id.txtSertifikat)
        val txtMarchandise = findViewById<TextView>(R.id.txtMarchandise)
        val txtMakanan = findViewById<TextView>(R.id.txtMakanan)
        val txtEnable = findViewById<TextView>(R.id.txtEnable)

        val name = intent.getStringExtra("name")
        val phoneNumber = intent.getStringExtra("phonenumber")
        val email = intent.getStringExtra("email")
        val gender = intent.getStringExtra("gender")
        val jenisEvent = intent.getStringExtra("jenisEvent")
        val sertifikat = intent.getBooleanExtra("sertifikat", false)
        val marchindise = intent.getBooleanExtra("marchindise", false)
        val makanan = intent.getBooleanExtra("makanan", false)
        val enable = intent.getStringExtra("enable")

        txtName.text = "Nama: $name"
        txtEmail.text = "Email: $email"
        txtPhoneNumber.text = "Nomor Telepon: $phoneNumber"
        txtGender.text = "Gender: $gender"
        txtSpinner.text = "Jenis Event: $jenisEvent"
        txtSertifikat.text = "Sertifikat: $sertifikat"
        txtMarchandise.text = "Marchandise: $marchindise"
        txtMakanan.text = "Makanan: $makanan"
        txtEnable.text = "Fitur: $enable"

        val btnUbahData = findViewById<Button>(R.id.btnUbahData)
        btnUbahData.setOnClickListener {
            finish()
        }

    }
}