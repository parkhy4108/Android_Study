package com.devyoung.retrofit.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devyoung.retrofit.Content
import com.devyoung.retrofit.databinding.ItemNoticeBinding

class NoticeAdapter : RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder>(){
    private var items = ArrayList<Content>()

    inner class NoticeViewHolder(private val binding: ItemNoticeBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(notice : Content){
            binding.tvTitle.text = notice.title
            binding.tvDate.text = notice.data.substring(0,10)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemNoticeBinding.inflate(layoutInflater,parent,false)
        return NoticeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun  setList(notice : ArrayList<Content>){
        items = notice
    }
}