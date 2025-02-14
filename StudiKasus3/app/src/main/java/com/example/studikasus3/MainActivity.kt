package com.example.studikasus3

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var btnDate: Button
    private lateinit var tvSelectedDate: TextView
    private lateinit var btnTime: Button
    private lateinit var txtTime: TextView
    private val calendar = Calendar.getInstance()
    private lateinit var spinnerJumlah: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        btnDate = findViewById(R.id.btnDate)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        btnTime = findViewById(R.id.btnTime)
        txtTime = findViewById(R.id.timeSelected)
        spinnerJumlah = findViewById(R.id.spinner)

        btnDate.setOnClickListener {
            showDatePicker(tvSelectedDate)
        }

        btnTime.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                txtTime.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
        }

        val jumlahOrang = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, jumlahOrang)
        spinnerJumlah.adapter = adapter

        val edtName = findViewById<EditText>(R.id.edtName)
        val edtPhoneNumber = findViewById<EditText>(R.id.edtPhoneNumber)
        val rgMeja = findViewById<RadioGroup>(R.id.rgMeja)
        val cbxMakananVegan = findViewById<CheckBox>(R.id.cbxMakananVegan)
        val cbxDekatJendela = findViewById<CheckBox>(R.id.cbxDekatJendela)
        val cbxKursiBayi = findViewById<CheckBox>(R.id.cbxKursiBayi)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            val name = edtName.text.toString()
            val phonenumber = edtPhoneNumber.text.toString()
            val jumlahorang = spinnerJumlah.selectedItem.toString()
            val pilihanmeja = if (rgMeja.checkedRadioButtonId == R.id.rbIndoor) {
                "Indoor"
            } else if (rgMeja.checkedRadioButtonId == R.id.rbOutdoor) {
                "Outdoor"
            } else {
                "Not Specified"
            }
            val makananvegan = cbxMakananVegan.isChecked
            val dekatjendela = cbxDekatJendela.isChecked
            val kursibayi = cbxKursiBayi.isChecked


            val intent = Intent(this, ReservationSummaryActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("phonenumber", phonenumber)
            intent.putExtra("date", tvSelectedDate.text.toString())
            intent.putExtra("time", txtTime.text.toString())
            intent.putExtra("jumlahorang", jumlahorang)
            intent.putExtra("pilihanmeja", pilihanmeja)
            intent.putExtra("makananvegan", makananvegan)
            intent.putExtra("dekatjendela", dekatjendela)
            intent.putExtra("kursibayi", kursibayi)

            startActivity(intent)
        }

        val btnNavigation = findViewById<Button>(R.id.btnNavigation)
        btnNavigation.setOnClickListener {
            val intent = Intent(this, RestaurantOptionsActivity::class.java)
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