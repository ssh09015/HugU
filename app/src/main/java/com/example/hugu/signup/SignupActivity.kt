package com.example.hugu.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hugu.R
import com.example.hugu.databinding.ActivityLoginBinding
import com.example.hugu.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

    }
}