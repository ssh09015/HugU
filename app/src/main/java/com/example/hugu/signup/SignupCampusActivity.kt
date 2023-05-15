package com.example.hugu.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hugu.databinding.ActivitySignupCampusBinding

class SignupCampusActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivitySignupCampusBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySignupCampusBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}