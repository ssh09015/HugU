package com.example.hugu.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hugu.databinding.FragmentHelpBinding

class HelpFragment : Fragment() {
    lateinit var viewbinding: FragmentHelpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewbinding = FragmentHelpBinding.inflate(inflater, container, false)

        return viewbinding.root
    }
}