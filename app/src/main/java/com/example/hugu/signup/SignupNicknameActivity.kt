package com.example.hugu.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hugu.databinding.ActivitySignupNicknameBinding

class SignupNicknameActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivitySignupNicknameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySignupNicknameBinding.inflate(layoutInflater)


        viewBinding.signupOkBtn.setOnClickListener {
            val intent = Intent(this, SignupCampusActivity::class.java)
            this.startActivity(intent)
            overridePendingTransition(0, 0)
        }

        setContentView(viewBinding.root)
    }
}