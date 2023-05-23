package com.example.hugu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hugu.databinding.ActivityMainBinding
import com.example.hugu.fragment.*

class MainActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_con, HomeFragment())
            .commitAllowingStateLoss()

        viewBinding.navi.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fl_con, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.help -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fl_con, HelpFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.comm -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fl_con, CommFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.page -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fl_con, PageFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                else -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fl_con, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
        }
    }

    fun changeFragment(index: Int) {
        when (index) {
            1 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fl_con, HomeCampaignTipFragment())
                    .commitAllowingStateLoss()
            }
            else -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fl_con, HomeFragment())
                    .commitAllowingStateLoss()
            }
        }
    }
}