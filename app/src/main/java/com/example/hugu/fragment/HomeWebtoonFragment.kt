package com.example.hugu.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hugu.R
import com.example.hugu.adapter.WebtoonRVAdapter
import com.example.hugu.data.Webtoon
import com.example.hugu.databinding.FragmentHomeWebtoonBinding

class HomeWebtoonFragment : Fragment() {
    lateinit var viewBinding: FragmentHomeWebtoonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHomeWebtoonBinding.inflate(inflater, container, false)

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val wtList: ArrayList<Webtoon> = arrayListOf()
        val adapter = WebtoonRVAdapter(wtList)

        wtList.apply {
            add(Webtoon(R.drawable.webtoon_title, "1화 프로토콜1"))
            add(Webtoon(R.drawable.webtoon_title, "2화 프로토콜2"))
        }

        viewBinding.rvWeb.layoutManager = LinearLayoutManager(context)
        viewBinding.rvWeb.adapter = adapter

    }
}