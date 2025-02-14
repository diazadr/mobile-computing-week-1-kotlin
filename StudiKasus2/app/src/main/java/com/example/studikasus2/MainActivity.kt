package com.example.studikasus2

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var spinnerEvent: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerEvent = findViewById(R.id.spinner)

        val eventSpinner = arrayOf("Seminar", "Workshop", "Webinar")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, eventSpinner)
        spinnerEvent.adapter = adapter


        val edtName = findViewById<EditText>(R.id.edtName)
        val edtPhoneNumber = findViewById<EditText>(R.id.edtPhoneNumber)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val cbxSertifikat = findViewById<CheckBox>(R.id.cbxSertifikat)
        val cbxMerchandise = findViewById<CheckBox>(R.id.cbxMerchandise)
        val cbxMakanan = findViewById<CheckBox>(R.id.cbxMakanan)
        val swNotifikasi = findViewById<Switch>(R.id.swNotifikasi)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            val name = edtName.text.toString()
            val phonenumber = edtPhoneNumber.text.toString()
            val email = edtEmail.text.toString()
            val jenisEvent = spinnerEvent.selectedItem.toString()
            val sertifikat = cbxSertifikat.isChecked
            val marchindise = cbxMerchandise.isChecked
            val makanan = cbxMakanan.isChecked

            val gender = if (rgGender.checkedRadioButtonId == R.id.rbLakiLaki) {
                "Laki - laki"
            } else if (rgGender.checkedRadioButtonId == R.id.rbPerempuan) {
                "Perempuan"
            } else {
                "Not Specified"
            }
            val enable = if (swNotifikasi.isChecked) "Enabled" else "Disabled"

            val intent = Intent(this, ConfirmationActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("phonenumber", phonenumber)
            intent.putExtra("email", email)
            intent.putExtra("jenisEvent", jenisEvent)
            intent.putExtra("sertifikat", sertifikat)
            intent.putExtra("marchindise", marchindise)
            intent.putExtra("makanan", makanan)
            intent.putExtra("gender", gender)
            intent.putExtra("enable", enable)
            startActivity(intent)
        }

        val btnNavigation = findViewById<Button>(R.id.btnNavigation)
        btnNavigation.setOnClickListener {
            val intent = Intent(this, MoreOptionActivity::class.java)
            startActivity(intent)
        }

    }
}