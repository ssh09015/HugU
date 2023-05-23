package com.example.hugu.fragment

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.viewpager2.widget.ViewPager2
import com.example.hugu.MainActivity
import com.example.hugu.R
import com.example.hugu.adapter.PagerFragmentStateAdapter
import com.example.hugu.databinding.FragmentHomeBinding
import com.example.hugu.databinding.FragmentHomeCampaignBinding


class HomeCampaignFragment : Fragment() {
    lateinit var viewbinding: FragmentHomeCampaignBinding
    lateinit var viewbinding2: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewbinding = FragmentHomeCampaignBinding.inflate(inflater, container, false)
        viewbinding2 = FragmentHomeBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_campaign, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var campaign_option = view.findViewById<ImageView>(R.id.campaign)
        var tip_option = view.findViewById<ImageView>(R.id.tip)
        var policy_option = view.findViewById<ImageView>(R.id.policy)
        var meta_option = view.findViewById<ImageView>(R.id.meta)

        val otherLayout = LayoutInflater.from(context).inflate(R.layout.fragment_home, null)
        val viewPager = otherLayout.findViewById<ViewPager2>(R.id.viewPager)

        val pagerAdapter = PagerFragmentStateAdapter(requireActivity())
        pagerAdapter.addFragment(HomeCampaignFragment())
        pagerAdapter.addFragment(HomeCampaignTipFragment())
        viewPager.adapter=pagerAdapter

        val activity = activity as MainActivity

        tip_option.setOnClickListener {
            var current = viewPager.currentItem
            Log.e("Click!!!!!!!!!", "Page ${current}")
            viewPager.setCurrentItem(1, false)
            activity.changeFragment(1)
        }
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.e("PageSelected", "Page $position")
                //왜 바뀌지는 않지?? ->여기 다시 보기
            }
        })

    }
    fun showDialog2(context: Context) {
        val dialog1 = Dialog(context)
        dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE) // 타이틀바 없애기
        dialog1.setContentView(R.layout.fragment_home_campaign_tip) // 레이아웃 설정

        // 팝업창 크기 설정
        dialog1.window?.let {
            it.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            it.setBackgroundDrawable(ColorDrawable(Color.WHITE))
        }

        dialog1.show() // 팝업창 보이기
    }
}
