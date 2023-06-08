package com.example.hugu.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hugu.R
import com.example.hugu.WebtoonActivity
import com.example.hugu.adapter.WebtoonRVAdapter
import com.example.hugu.data.Webtoon
import com.example.hugu.databinding.FragmentHomeWebtoonBinding

var webIndex: Int = 0

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

        adapter.setItemClickListener(object: WebtoonRVAdapter.OnItemClickListener {
            override fun onClick(v: View, position: Int) {
                val wIntent = Intent(requireActivity(), WebtoonActivity::class.java)
                webIndex = position
                startActivity(wIntent)
            }
        })

        viewBinding.btnWeb.setOnClickListener {
            val intent = Intent(requireActivity(), WebtoonActivity::class.java)
            startActivity(intent)
        }

        viewBinding.ibW1.setOnClickListener {
            val msg = Intent(Intent.ACTION_SEND)

            msg.addCategory(Intent.CATEGORY_DEFAULT)
            msg.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=hugu")
            msg.putExtra(Intent.EXTRA_TITLE, "제목")
            msg.type = "text/plain"
            startActivity(Intent.createChooser(msg, "앱을 선택해 주세요"))
        }

    }
}