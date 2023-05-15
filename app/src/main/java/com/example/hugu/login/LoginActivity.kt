package com.example.hugu.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hugu.databinding.ActivityLoginBinding
import com.example.hugu.signup.SignupEmailActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityLoginBinding.inflate(layoutInflater)


        viewBinding.signUpBtn.setOnClickListener {
            val intent = Intent(this, SignupEmailActivity::class.java)
            this.startActivity(intent)
            overridePendingTransition(0, 0)
          }

        setContentView(viewBinding.root)
    }
}