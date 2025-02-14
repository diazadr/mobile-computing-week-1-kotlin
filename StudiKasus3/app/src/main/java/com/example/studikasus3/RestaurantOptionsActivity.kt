package com.example.studikasus3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RestaurantOptionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_options)

        val btnUrl = findViewById<Button>(R.id.btnUrl)
        val url = "https://miegacoan.co.id/"
        btnUrl.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        val btnCustomerService = findViewById<Button>(R.id.btnCustomerService)
        btnCustomerService.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:(022) 2500241"))
            startActivity(intent)
        }

        val btnMaps = findViewById<Button>(R.id.btnMaps)
        btnMaps.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:?q=Mie+Gacoan+Dago@-6.8888519,107.6107802)"))
            startActivity(intent)
        }

        val btnEmail = findViewById<Button>(R.id.btnEmail)
        btnEmail.setOnClickListener {
            val subject = "Konfirmasi Pemesanan Restauran"
            val body = "Terima kasih telah memesan di Mie Gacoan. Berikut adalah konfirmasi pemesanan Anda."
            val recipients = arrayOf("gacoan@gmail.com")

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "message/rfc822"
            intent.putExtra(Intent.EXTRA_EMAIL, recipients)
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, body)

            try {
                startActivity(Intent.createChooser(intent, "Pilih aplikasi email"))
            } catch (ex: android.content.ActivityNotFoundException) {
                ex.printStackTrace()
            }
        }

        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }

    }
}