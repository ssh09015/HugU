package com.example.hugu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.hugu.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySplashBinding.inflate(layoutInflater)
        // postDelayed : 일정 시간 후 함수 실행 가능
        // Looper.getMainLooper() : 에러 방지
        Handler(Looper.getMainLooper()).postDelayed({

            startActivity(Intent(this, StartActivity::class.java)) // MainActivity로 이동
            finish(); // 현재 Activity 닫기

        }, 1000) // 지연시간 1초

        setContentView(viewBinding.root)
    }
}