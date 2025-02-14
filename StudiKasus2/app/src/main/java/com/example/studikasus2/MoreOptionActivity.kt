package com.example.studikasus2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MoreOptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_more_option)

        val btnUrl = findViewById<Button>(R.id.btnUrl)
        val url = "https://www.dicoding.com/events"
        btnUrl.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        val btnCustomerService = findViewById<Button>(R.id.btnCustomerService)
        btnCustomerService.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:0818485850"))
            startActivity(intent)
        }

        val btnMaps = findViewById<Button>(R.id.btnMaps)
        btnMaps.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:-6.9023637,107.6109339?q=-6.9023637,107.6109339(Dicoding+Indonesia)"))
            startActivity(intent)
        }

        val btnEmail = findViewById<Button>(R.id.btnEmail)
        btnEmail.setOnClickListener {
            val subject = "Konfirmasi Pemesanan Event"
            val body = "Terima kasih telah memesan di Event Dicoding. Berikut adalah konfirmasi pemesanan Anda."
            val recipients = arrayOf("info@dicoding.com")

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