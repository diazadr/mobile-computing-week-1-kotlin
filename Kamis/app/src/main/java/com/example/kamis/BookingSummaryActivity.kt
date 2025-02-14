package com.example.kamis

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BookingSummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_summary)

        val txtName = findViewById<TextView>(R.id.txtName)
        val txtPhoneNumber = findViewById<TextView>(R.id.txtPhoneNumber)
        val txtEmail = findViewById<TextView>(R.id.txtEmail)
        val txtSpinner = findViewById<TextView>(R.id.txtSpinner)
        val txtSarapan = findViewById<TextView>(R.id.txtSarapan)
        val txtSpa = findViewById<TextView>(R.id.txtSpa)
        val txtGym = findViewById<TextView>(R.id.txtGym)
        val txtCheckIn = findViewById<TextView>(R.id.txtCheckIn)
        val txtCheckOut = findViewById<TextView>(R.id.txtCheckOut)
        val txtMetodePembayaran = findViewById<TextView>(R.id.txtMetodePembayaran)

        val name = intent.getStringExtra("name")
        val phoneNumber = intent.getStringExtra("phonenumber")
        val email = intent.getStringExtra("email")
        val jenisKamar = intent.getStringExtra("jenisKamar")
        val sarapan = intent.getBooleanExtra("sarapan", false)
        val spa = intent.getBooleanExtra("spa", false)
        val gym = intent.getBooleanExtra("gym", false)
        val checkIn = intent.getStringExtra("checkIn")
        val checkOut = intent.getStringExtra("checkOut")
        val metodePembayaran = intent.getStringExtra("metodePembayaran")

        txtName.text = "Nama: $name"
        txtPhoneNumber.text = "Nomor Telepon: $phoneNumber"
        txtEmail.text = "Email: $email"
        txtSpinner.text = "Jenis Kamar: $jenisKamar"
        txtSarapan.text = "Sarapan: $sarapan"
        txtSpa.text = "Spa: $spa"
        txtGym.text = "Gym: $gym"
        txtCheckIn.text = "Check In: $checkIn"
        txtCheckOut.text = "CheckOut: $checkOut"
        txtMetodePembayaran.text = "Metode Pembayaran: $metodePembayaran"

        val btnUbahPemesanan = findViewById<Button>(R.id.btnUbahPemesanan)
        btnUbahPemesanan.setOnClickListener {
            finish()
        }
    }
}