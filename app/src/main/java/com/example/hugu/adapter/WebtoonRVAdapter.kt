package com.example.hugu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.hugu.data.Webtoon
import com.example.hugu.databinding.ItemWebtoonBinding

class WebtoonRVAdapter(private val wtList: ArrayList<Webtoon>): RecyclerView.Adapter<WebtoonRVAdapter.ViewHolder>() {

    inner class ViewHolder(val viewBinding: ItemWebtoonBinding): RecyclerView.ViewHolder(viewBinding.root) {
        fun bind (Webtoon: Webtoon) {
            viewBinding.ivTitle.setImageResource(Webtoon.img)
            viewBinding.tvTitle.text = Webtoon.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemWebtoonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(wtList[position])

        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
    }

    override fun getItemCount(): Int = wtList.size

    override fun getItemViewType(position: Int): Int {
        return position
    }

    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }

    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }

    private lateinit var itemClickListener : OnItemClickListener

}