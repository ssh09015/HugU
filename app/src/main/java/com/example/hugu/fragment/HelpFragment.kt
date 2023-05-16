package com.example.hugu.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBindings
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.hugu.adapter.PagerFragmentStateAdapter
import com.example.hugu.databinding.FragmentHelpBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HelpFragment : Fragment() {
    lateinit var viewbinding: FragmentHelpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        viewbinding = FragmentHelpBinding.inflate(inflater, container, false)
        return viewbinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pagerAdapter = PagerFragmentStateAdapter(requireActivity())

        pagerAdapter.addFragment(HelpRankFragment())
        pagerAdapter.addFragment(HelpSupportFragment())

        viewbinding.viewPager.setOnClickListener {

        }
        viewbinding.viewPager.adapter=pagerAdapter

        viewbinding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.e("HelpFragment", "Page ${position+1}")
            }
        })

        TabLayoutMediator(viewbinding.tabLayout, viewbinding.viewPager) { tab, position ->
            when(position){
                0-> tab.text="서명운동"
                1-> tab.text="후원하기"
            }
        }.attach()
    }

}