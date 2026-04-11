package com.example.projectku

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {

    private lateinit var etNamaLengkap: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPhone: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var rgGender: RadioGroup
    private lateinit var btnDaftar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)


        etNamaLengkap = findViewById(R.id.etNamaLengkap)
        etEmail = findViewById(R.id.etEmail)
        etPhone = findViewById(R.id.etPhone)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        rgGender = findViewById(R.id.rgGender)
        btnDaftar = findViewById(R.id.btnDaftar)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.register_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        btnDaftar.setOnClickListener {
            val nama = etNamaLengkap.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val confirmPassword = etConfirmPassword.text.toString().trim()
            val selectedGenderId = rgGender.checkedRadioButtonId


            if (nama.isEmpty() || email.isEmpty() || phone.isEmpty() || 
                password.isEmpty() || confirmPassword.isEmpty() || selectedGenderId == -1) {
                
                Toast.makeText(this, "tolong mengisi field yang kosong", Toast.LENGTH_SHORT).show()
            } 

            else if (password != confirmPassword) {
                Toast.makeText(this, "Password dan Konfirmasi Password harus sama!", Toast.LENGTH_SHORT).show()
            } 

            else {
                Toast.makeText(this, "Pendaftaran berhasil", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
