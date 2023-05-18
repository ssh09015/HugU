package com.example.hugu.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hugu.databinding.FragmentHelpRankBinding


class HelpRankFragment : Fragment(){
    lateinit var viewBinding: FragmentHelpRankBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHelpRankBinding.inflate(inflater, container, false)

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.btnJoin.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://bit.ly/3ASKo9e"))
            startActivity(intent)
        }
    }

}
