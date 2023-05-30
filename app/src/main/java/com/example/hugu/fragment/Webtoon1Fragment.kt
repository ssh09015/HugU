package com.example.hugu.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hugu.databinding.FragmentWebtoon1Binding

class Webtoon1Fragment: Fragment() {
    lateinit var viewBinding: FragmentWebtoon1Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentWebtoon1Binding.inflate(inflater, container, false)

        return viewBinding.root
    }
}