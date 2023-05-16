package com.example.hugu.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBindings
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.hugu.R
import com.example.hugu.adapter.PagerFragmentStateAdapter
import com.example.hugu.databinding.FragmentHelpBinding
import com.example.hugu.databinding.FragmentHomeBinding
import com.example.hugu.databinding.FragmentHomeQuizBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class HomeFragment : Fragment() {
    lateinit var viewbinding: FragmentHomeBinding
    lateinit var viewbinding_Quiz: FragmentHomeQuizBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        viewbinding = FragmentHomeBinding.inflate(inflater, container, false)
        return viewbinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pagerAdapter = PagerFragmentStateAdapter(requireActivity())
        pagerAdapter.addFragment(HomeQuizFragment())
        pagerAdapter.addFragment(HomeCampaignFragment())
        pagerAdapter.addFragment(HomeWebtoonFragment())
        pagerAdapter.addFragment(HomeCampaignTipFragment())
        viewbinding.viewPager.adapter=pagerAdapter

        //val otherLayout = LayoutInflater.from(context).inflate(R.layout.fragment_home_campaign, null)
        //var tip = otherLayout.findViewById<ImageView>(R.id.tip)

        viewbinding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.e("HelpFragment", "Page ${position+1}")
            }
        })

        TabLayoutMediator(viewbinding.tabLayout, viewbinding.viewPager) { tab, position ->
            when(position){
                0-> tab.text="퀴즈"
                1-> tab.text="캠페인"
                2-> tab.text="웹툰"
            }
        }.attach()
        /*tip.setOnClickListener {
            var current = viewbinding.viewPager.currentItem
            Log.e("Click!!!!!!!!!", "Page ${1}")
                viewbinding.viewPager.setCurrentItem(2, false)
        }*/
    }
    /*private fun setTabItemMargin(tabLayout: TabLayout, marginEnd: Int = 20) {
        for(i in 0 until 3) {
            val tabs = tabLayout.getChildAt(0) as ViewGroup
            for(i in 0 until tabs.childCount) {
                val tab = tabs.getChildAt(i)
                val lp = tab.layoutParams as LinearLayout.LayoutParams
                lp.marginEnd = marginEnd
                tab.layoutParams = lp
                tabLayout.requestLayout()
            }
        }
    }*/
}