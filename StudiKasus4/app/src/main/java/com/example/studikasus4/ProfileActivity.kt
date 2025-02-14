package com.example.studikasus4

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProfileActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_profile)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val userList = intent.getParcelableArrayListExtra<UserModel>("userList") ?: mutableListOf()
        adapter = UserAdapter(this, userList)
        recyclerView.adapter = adapter

        val btnEdit = findViewById<Button>(R.id.btnEdit)

        btnEdit.setOnClickListener {
            finish()
        }

    }
}