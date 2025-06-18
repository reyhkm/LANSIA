package com.example.lansiahelper.model

import androidx.compose.ui.graphics.vector.ImageVector

data class Medication(
    val id: Int,
    val name: String,
    val time: String,
    val dosage: String
)

data class Contact(
    val id: Int,
    val name: String,
    val phoneNumber: String
)

data class HomeMenuItem(
    val title: String,
    val icon: ImageVector,
    val route: String
)
