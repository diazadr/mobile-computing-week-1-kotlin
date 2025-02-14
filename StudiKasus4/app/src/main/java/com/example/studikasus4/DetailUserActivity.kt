package com.example.studikasus4

import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        val user = intent.getParcelableExtra<UserModel>("USER") ?: return

        val imageView = findViewById<ImageView>(R.id.ivProfileDetail)
        if (!user.imageUri.isNullOrEmpty()) {
            imageView.setImageURI(Uri.parse(user.imageUri))
        } else {
            imageView.setImageResource(R.drawable.img_avatar_pria)
        }

        findViewById<TextView>(R.id.tvNameDetail).text = "Nama: ${user.name}"
        findViewById<TextView>(R.id.tvEmailDetail).text = "Email: ${user.email}"
        findViewById<TextView>(R.id.tvPhoneDetail).text = "Nomor Telepon: ${user.phone}"
        findViewById<TextView>(R.id.tvAddressDetail).text = "Alamat: ${user.address}"
        findViewById<TextView>(R.id.tvGenderDetail).text = "Gender: ${user.gender}"
        findViewById<TextView>(R.id.tvHobbiesDetail).text = "Hobi: ${user.hobbies}"
        findViewById<TextView>(R.id.tvJobDetail).text = "Pekerjaan: ${user.job}"
        findViewById<TextView>(R.id.tvSatisfactionDetail).text = "Kepuasan: ${user.satisfactionLevel}/10"
        findViewById<TextView>(R.id.tvNotificationDetail).text = "Notifikasi: ${user.notificationStatus}"
        findViewById<TextView>(R.id.tvBirthDateDetail).text = "Tanggal Lahir: ${user.selectedDate}"
    }
}
