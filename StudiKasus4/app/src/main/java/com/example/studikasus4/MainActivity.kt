package com.example.studikasus4

import android.app.DatePickerDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var edtName: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPhoneNumber: EditText
    private lateinit var edtAddress: EditText
    private lateinit var cbReading: CheckBox
    private lateinit var cbTraveling: CheckBox
    private lateinit var cbSports: CheckBox
    private lateinit var spinnerJob: Spinner
    private lateinit var switchNotification: Switch
    private lateinit var btnMoreOptions: Button
    private lateinit var btnSubmit: Button
    private lateinit var btnDate: Button
    private lateinit var tvSelectedDate: TextView
    private lateinit var btnSelectImage: Button
    private lateinit var ivProfilePicture: ImageView
    private lateinit var seekBarSatisfaction: SeekBar
    private lateinit var tvSeekBarValue: TextView

    private val PICK_IMAGE_REQUEST = 1
    private var selectedImageUri: Uri? = null

    private val calendar = Calendar.getInstance()
    val userList = mutableListOf<UserModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtName = findViewById(R.id.edtName)
        edtEmail = findViewById(R.id.edtEmail)
        edtPhoneNumber = findViewById(R.id.edtPhoneNumber)
        edtAddress = findViewById(R.id.edtAddress)
        cbReading = findViewById(R.id.cbReading)
        cbTraveling = findViewById(R.id.cbTraveling)
        cbSports = findViewById(R.id.cbSports)
        spinnerJob = findViewById(R.id.spinner)
        switchNotification = findViewById(R.id.switch1)
        btnMoreOptions = findViewById(R.id.btnMoreOptions)
        btnSubmit = findViewById(R.id.btnSubmit)
        btnDate = findViewById(R.id.btnDate)
        tvSelectedDate = findViewById(R.id.selectedDate)
        btnSelectImage = findViewById(R.id.btnSelectImage)
        ivProfilePicture = findViewById(R.id.ivProfilePicture)
        seekBarSatisfaction = findViewById(R.id.seekBar)
        tvSeekBarValue = findViewById(R.id.tvSeekBarValue)

        val radioGroupGender = findViewById<RadioGroup>(R.id.rgGender)
        var gender = ""

        radioGroupGender.setOnCheckedChangeListener { _, checkedId ->
            gender = when (checkedId) {
                R.id.rbMale -> "Male"
                R.id.rbFemale -> "Female"
                else -> "Not Selected"
            }
        }

        val jobOptions = arrayOf("Student", "Teacher", "Engineer", "Doctor", "Other")
        spinnerJob.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, jobOptions)

        seekBarSatisfaction.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvSeekBarValue.text = "Satisfaction: $progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        btnDate.setOnClickListener {
            showDatePicker { selectedDate ->
                tvSelectedDate.text = "$selectedDate"
            }
        }

        btnSelectImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
        }

        btnSubmit.setOnClickListener {
            val name = edtName.text.toString()
            val email = edtEmail.text.toString()
            val phone = edtPhoneNumber.text.toString()
            val address = edtAddress.text.toString()

            val hobbies = mutableListOf<String>()
            if (cbReading.isChecked) hobbies.add("Reading")
            if (cbTraveling.isChecked) hobbies.add("Traveling")
            if (cbSports.isChecked) hobbies.add("Sports")

            val notificationStatus = if (switchNotification.isChecked) "Enabled" else "Disabled"
            val selectedDate = tvSelectedDate.text.toString()
            val job = spinnerJob.selectedItem.toString()
            val satisfactionLevel = seekBarSatisfaction.progress

            userList.add(
                UserModel(
                    name, email, phone, address, gender,
                    hobbies.joinToString(", "), job, satisfactionLevel,
                    notificationStatus, selectedDate, selectedImageUri?.toString()
                )
            )

            val intent = Intent(this, ProfileActivity::class.java).apply {
                putParcelableArrayListExtra("userList", ArrayList(userList))
                putExtra("imageUri", selectedImageUri.toString())
            }
            startActivity(intent)
        }

        btnMoreOptions.setOnClickListener {
            val intent = Intent(this, MoreOptionsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showDatePicker(onDateSelected: (String) -> Unit) {
        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, month, dayOfMonth)
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                onDateSelected(dateFormat.format(selectedDate.time))
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK) {
            selectedImageUri = data?.data
            ivProfilePicture.setImageURI(selectedImageUri)
        }
    }
}
