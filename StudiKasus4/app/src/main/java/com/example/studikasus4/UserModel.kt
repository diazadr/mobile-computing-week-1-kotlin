package com.example.studikasus4

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel(
    val name: String,
    val email: String,
    val phone: String,
    val address: String,
    val gender: String,
    val hobbies: String,
    val job: String,
    val satisfactionLevel: Int,
    val notificationStatus: String,
    val selectedDate: String,
    val imageUri: String?
) : Parcelable
