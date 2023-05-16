package com.example.hugu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hugu.databinding.ActivityStartBinding
import com.example.hugu.login.LoginActivity

class StartActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityStartBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        viewBinding.loginBtn2.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            this.startActivity(intent)
        }

        viewBinding.btnMain.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            this.startActivity(intent)
        }
    }
}