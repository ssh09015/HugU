package com.example.hugu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hugu.databinding.ActivityWebtoonBinding
import com.example.hugu.fragment.*

class WebtoonActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityWebtoonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityWebtoonBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        showWebtoon(webIndex)
    }

    fun showWebtoon(index: Int) {
        when (index) {
            0 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.web_con, Webtoon1Fragment())
                    .commitAllowingStateLoss()
                viewBinding.tvTitle.text = "1화 프롤로그1"
            }
            1 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.web_con, Webtoon2Fragment())
                    .commitAllowingStateLoss()
                viewBinding.tvTitle.text = "2화 프롤로그2"
            }
            else -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.web_con, Webtoon1Fragment())
                    .commitAllowingStateLoss()
                viewBinding.tvTitle.text = "1화 프롤로그1"
            }
        }
    }
}