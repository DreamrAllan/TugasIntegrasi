package com.example.tugasintegrasi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.tugasintegrasi.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener {
            val username = binding.editTextFullname.text.toString()
            val email = binding.editTextEmail.text.toString()
            val phone = binding.editTextPhone.text.toString()
            val gender = binding.editTextGender.text.toString()
            val password = binding.editTextPassword.text.toString()

            if (username.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty() && gender.isNotEmpty() && password.isNotEmpty()) {
                // Tampilkan pesan sukses
                Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()

                // Kirim data ke LoginActivity menggunakan Intent (including password)
                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("username", username)
                intent.putExtra("email", email)
                intent.putExtra("phone", phone)
                intent.putExtra("gender", gender)
                intent.putExtra("password", password)  // Pass the password as well
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

