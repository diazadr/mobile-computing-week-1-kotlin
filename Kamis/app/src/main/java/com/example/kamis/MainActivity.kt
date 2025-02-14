package com.example.kamis

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale
import android.widget.Spinner
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var btnCheckIn: Button
    private lateinit var btnCheckOut: Button
    private lateinit var tvSelectedDateCheckIn: TextView
    private lateinit var tvSelectedDateCheckOut: TextView
    private val calendar = Calendar.getInstance()
    private lateinit var spinnerKamar: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        btnCheckIn = findViewById(R.id.btnCheckIn)
        btnCheckOut = findViewById(R.id.btnCheckOut)
        tvSelectedDateCheckIn = findViewById(R.id.tvSelectedDateCheckIn)
        tvSelectedDateCheckOut = findViewById(R.id.tvSelectedDateCheckOut)
        spinnerKamar = findViewById(R.id.spinner)
        btnCheckIn.setOnClickListener {
            // Show the DatePicker dialog
            showDatePicker(tvSelectedDateCheckIn)
        }

        btnCheckOut.setOnClickListener {
            showDatePicker(tvSelectedDateCheckOut)
        }

        val kamarOptions = arrayOf("Single", "Double", "Suite")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, kamarOptions)
        spinnerKamar.adapter = adapter


        val edtName = findViewById<EditText>(R.id.edtName)
        val edtPhoneNumber = findViewById<EditText>(R.id.edtPhoneNumber)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)

        val cbxSarapan = findViewById<CheckBox>(R.id.cbxSarapan)
        val cbxSpa = findViewById<CheckBox>(R.id.cbxSpa)
        val cbxGym = findViewById<CheckBox>(R.id.cbxGym)
        val rgMetodePembayaran = findViewById<RadioGroup>(R.id.rgMetodePembayaran)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            val name = edtName.text.toString()
            val phonenumber = edtPhoneNumber.text.toString()
            val email = edtEmail.text.toString()
            val jenisKamar = spinnerKamar.selectedItem.toString()
            val sarapan = cbxSarapan.isChecked
            val spa = cbxSpa.isChecked
            val gym = cbxGym.isChecked

            val metodePembayaran = if (rgMetodePembayaran.checkedRadioButtonId == R.id.rbTunai) {
                "Tunai"
            } else if (rgMetodePembayaran.checkedRadioButtonId == R.id.rbKartuKredit) {
                "Kartu Kredit"
            } else if (rgMetodePembayaran.checkedRadioButtonId == R.id.rbTransferBank) {
                "Transfer Bank"
            } else {
                "Not Specified"
            }

            val intent = Intent(this, BookingSummaryActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("phonenumber", phonenumber)
            intent.putExtra("email", email)
            intent.putExtra("jenisKamar", jenisKamar)
            intent.putExtra("sarapan", sarapan)
            intent.putExtra("spa", spa)
            intent.putExtra("gym", gym)
            intent.putExtra("checkIn", tvSelectedDateCheckIn.text.toString())
            intent.putExtra("checkOut", tvSelectedDateCheckOut.text.toString())
            intent.putExtra("metodePembayaran", metodePembayaran)
            startActivity(intent)
        }

        val btnNavigation = findViewById<Button>(R.id.btnNavigation)
        btnNavigation.setOnClickListener {
            val intent = Intent(this, MoreOptionActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showDatePicker(targetTextView: TextView) {
        val datePickerDialog = DatePickerDialog(
            this, { _, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                val selectedDate = Calendar.getInstance().apply {
                    set(year, monthOfYear, dayOfMonth)
                }
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                targetTextView.text = dateFormat.format(selectedDate.time)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

}

