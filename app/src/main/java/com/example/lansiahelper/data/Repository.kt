package com.example.lansiahelper.data

import com.example.lansiahelper.model.Contact
import com.example.lansiahelper.model.Medication

object Repository {

    // Nomor darurat, idealnya disimpan di SharedPreferences
    const val EMERGENCY_NUMBER = "112"

    fun getMedications(): List<Medication> {
        return listOf(
            Medication(1, "Obat Jantung", "08:00", "1 Pil"),
            Medication(2, "Vitamin D", "08:00", "1 Tablet"),
            Medication(3, "Obat Darah Tinggi", "12:00", "1 Pil"),
            Medication(4, "Obat Lambung", "18:00", "1 Tablet")
        )
    }

    fun getContacts(): List<Contact> {
        return listOf(
            Contact(1, "Anak Pertama", "081234567890"),
            Contact(2, "Anak Kedua", "081209876543"),
            Contact(3, "Dokter Budi", "085611223344"),
            Contact(4, "Perawat Siti", "087755667788")
        )
    }
}
