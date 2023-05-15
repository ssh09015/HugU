package com.example.hugu.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hugu.databinding.ActivitySignupEmailBinding
import com.example.hugu.databinding.ActivitySignupPwdBinding

class SignupPwdActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivitySignupPwdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySignupPwdBinding.inflate(layoutInflater)

        viewBinding.signupOkBtn.setOnClickListener {
            val intent = Intent(this, SignupPwdActivity::class.java)
            this.startActivity(intent)
            overridePendingTransition(0, 0)
        }


        setContentView(viewBinding.root)
    }
}