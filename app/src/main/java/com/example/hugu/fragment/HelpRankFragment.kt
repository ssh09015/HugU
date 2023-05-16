package com.example.hugu.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.hugu.databinding.FragmentHelpRankBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HelpRankFragment : Fragment(){
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var viewbinding:FragmentHelpRankBinding
    private var cnt = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        viewbinding = FragmentHelpRankBinding.inflate(inflater, container, false)
//        viewbinding.shareButton.setOnClickListener {
//            Toast.makeText(activity, "공유하기", Toast.LENGTH_SHORT).show()
//        }
//        viewbinding.join.setOnClickListener {
//            Toast.makeText(activity, "서명운동 참여하기", Toast.LENGTH_SHORT).show()
//        }
        return viewbinding.root
    }



    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HelpRankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
