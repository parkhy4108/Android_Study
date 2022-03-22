package com.devyoung.practice_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter : RecyclerView.Adapter<CustomAdapterHolder>() {

    private var dataList = ArrayList<RecyclerData>()

    //뷰홀더가 생성 되었을때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapterHolder {

        // 연결할 레이아웃 설정
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_recyclerview, parent, false)

        return CustomAdapterHolder(view)
    }

    //뷰홀더에
    override fun onBindViewHolder(holder: CustomAdapterHolder, position: Int) {
        holder.bind(this.dataList[position])
    }

    override fun getItemCount() = dataList.size

    fun submitList(dataList : ArrayList<RecyclerData>){
        this.dataList = dataList
    }

}