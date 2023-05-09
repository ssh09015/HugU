package com.example.hugu.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hugu.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var viewbinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewbinding = FragmentHomeBinding.inflate(inflater, container, false)

        return viewbinding.root
    }
}