package com.example.hugu.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hugu.R
import com.example.hugu.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}