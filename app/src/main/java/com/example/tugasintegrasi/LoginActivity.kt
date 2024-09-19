package com.example.tugasintegrasi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.tugasintegrasi.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the data passed from RegisterActivity
        val receivedUsername = intent.getStringExtra("username")
        val receivedEmail = intent.getStringExtra("email")
        val receivedPhone = intent.getStringExtra("phone")
        val receivedGender = intent.getStringExtra("gender")
        val receivedPassword = intent.getStringExtra("password")  // Retrieve the password

        binding.btnLogin.setOnClickListener {
            val email = binding.etLoginEmail.text.toString()
            val password = binding.etLoginPassword.text.toString()

            // Check if entered email and password match the registered ones
            if (email == receivedEmail && password == receivedPassword) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()

                // Send data to ProfileActivity using Intent
                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra("username", receivedUsername)
                intent.putExtra("email", receivedEmail)
                intent.putExtra("phone", receivedPhone)
                intent.putExtra("gender", receivedGender)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Invalid Email or Password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
