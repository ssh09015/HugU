package com.example.hugu.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hugu.databinding.FragmentWebtoon2Binding

class Webtoon2Fragment: Fragment() {
    lateinit var viewBinding: FragmentWebtoon2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentWebtoon2Binding.inflate(inflater, container, false)

        return viewBinding.root
    }
}