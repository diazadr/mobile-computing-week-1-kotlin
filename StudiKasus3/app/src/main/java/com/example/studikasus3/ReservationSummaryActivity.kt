package com.example.studikasus3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ReservationSummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_reservation_summary)

        val txtName = findViewById<TextView>(R.id.txtName)
        val txtPhoneNumber = findViewById<TextView>(R.id.txtPhoneNumber)
        val txtDate = findViewById<TextView>(R.id.txtDate)
        val txtTime = findViewById<TextView>(R.id.txtTime)
        val txtJumlahOrang = findViewById<TextView>(R.id.txtSpinner)
        val txtPilihanMeja = findViewById<TextView>(R.id.txtPilihanMeja)
        val txtMakananVegan = findViewById<TextView>(R.id.txtMakananVegan)
        val txtDekatJendela = findViewById<TextView>(R.id.txtDekatJendela)
        val txtKursiBayi = findViewById<TextView>(R.id.txtKursiBayi)

        val name = intent.getStringExtra("name")
        val phoneNumber = intent.getStringExtra("phonenumber")
        val date = intent.getStringExtra("date")
        val time = intent.getStringExtra("time")
        val jumlahOrang = intent.getStringExtra("jumlahorang")
        val pilihanMeja = intent.getStringExtra("pilihanmeja")
        val makananVegan = intent.getBooleanExtra("makananvegan", false)
        val dekatJendela = intent.getBooleanExtra("dekatjendela", false)
        val kursiBayi = intent.getBooleanExtra("kursibayi", false)

        txtName.text = "Nama: $name"
        txtPhoneNumber.text = "Nomor Telepon: $phoneNumber"
        txtDate.text = "Tanggal: $date"
        txtTime.text = "Waktu: $time"
        txtJumlahOrang.text = "Jumlah Orang: $jumlahOrang"
        txtPilihanMeja.text = "Pilhan Meja: $pilihanMeja"
        txtMakananVegan.text = "Makanan Vegan: $makananVegan"
        txtDekatJendela.text = "Dekat Jendela: $dekatJendela"
        txtKursiBayi.text = "Kursi Bayi: $kursiBayi"

        val btnUbahPemesanan = findViewById<Button>(R.id.btnUbahPemesanan)
        btnUbahPemesanan.setOnClickListener {
            finish()
        }

    }
}