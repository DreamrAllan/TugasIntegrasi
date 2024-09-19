package com.example.tugasintegrasi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasintegrasi.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data dari Intent
        val username = intent.getStringExtra("username")
        val email = intent.getStringExtra("email")
        val phone = intent.getStringExtra("phone")
        val gender = intent.getStringExtra("gender")

        // Menampilkan data di TextView
        binding.tvUsername.text = "Username: $username"
        binding.tvEmail.text = "Email: $email"
        binding.tvPhone.text = "Phone: $phone"
        binding.tvGender.text = "Gender: $gender"
    }
}

