package com.example.hugu.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ScrollView
import androidx.core.widget.NestedScrollView
import com.example.hugu.MainActivity
import com.example.hugu.R

class HomeCampaignTipFragment : Fragment() {
    private lateinit var inflater: LayoutInflater
    private lateinit var container: ViewGroup
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.inflater= inflater
        this.container = container!!
        return inflater.inflate(R.layout.fragment_home_campaign_tip, container, false)
    }
    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var backBtn = view.findViewById<ImageView>(R.id.back_btn)
        var moneyBtn = view.findViewById<ImageView>(R.id.money_btn)
        var phoneBtn = view.findViewById<ImageView>(R.id.phone_btn)
        var homeBtn = view.findViewById<ImageView>(R.id.home_btn)
        var passBtn = view.findViewById<ImageView>(R.id.pass_btn)
        var lightBtn = view.findViewById<ImageView>(R.id.light_btn)
        var schoolBtn = view.findViewById<ImageView>(R.id.school_btn)

        backBtn.setOnClickListener {
        //뒤로가기 만들어야함
        }
        moneyBtn.setOnClickListener {
            // 기존 레이아웃을 제거합니다.
            container.removeAllViews()

            // 새로운 레이아웃을 추가합니다.
            val newLayout = inflater.inflate(R.layout.fragment_home_campaign_tip_money, container, false)
            container.addView(newLayout)

            var upBtn = newLayout.findViewById<ImageView>(R.id.money_up_btn)
            val scrollView = newLayout.findViewById<NestedScrollView>(R.id.ns_sign)

            upBtn.setOnClickListener {
                scrollView.post {
                    scrollView.fullScroll(ScrollView.FOCUS_UP)
                }
            }
        }
        phoneBtn.setOnClickListener {
            // 기존 레이아웃을 제거합니다.
            container.removeAllViews()

            // 새로운 레이아웃을 추가합니다.
            val newLayout = inflater.inflate(R.layout.fragment_home_campaign_tip_phone, container, false)
            container.addView(newLayout)
        }
        homeBtn.setOnClickListener {
            // 기존 레이아웃을 제거합니다.
            container.removeAllViews()

            // 새로운 레이아웃을 추가합니다.
            val newLayout = inflater.inflate(R.layout.fragment_home_campaign_tip_home, container, false)
            container.addView(newLayout)
        }
        passBtn.setOnClickListener {
            // 기존 레이아웃을 제거합니다.
            container.removeAllViews()

            // 새로운 레이아웃을 추가합니다.
            val newLayout = inflater.inflate(R.layout.fragment_home_campaign_tip_passport, container, false)
            container.addView(newLayout)

            var upBtn = newLayout.findViewById<ImageView>(R.id.passport_up_btn)
            val scrollView = newLayout.findViewById<NestedScrollView>(R.id.ns_sign)

            upBtn.setOnClickListener {
                scrollView.post {
                    scrollView.fullScroll(ScrollView.FOCUS_UP)
                }
            }
        }
        lightBtn.setOnClickListener {
            // 기존 레이아웃을 제거합니다.
            container.removeAllViews()

            // 새로운 레이아웃을 추가합니다.
            val newLayout = inflater.inflate(R.layout.fragment_home_campaign_tip_light, container, false)
            container.addView(newLayout)
        }
        schoolBtn.setOnClickListener {
            // 기존 레이아웃을 제거합니다.
            container.removeAllViews()

            // 새로운 레이아웃을 추가합니다.
            val newLayout = inflater.inflate(R.layout.fragment_home_campaign_tip_school, container, false)
            container.addView(newLayout)
        }
    }

    override fun onPause() {
        super.onPause()

        removeView()
    }

    fun removeView(){
        container.removeAllViews()
        val newLayout = inflater.inflate(R.layout.transprant, container, false)
        container.addView(newLayout)
    }
}