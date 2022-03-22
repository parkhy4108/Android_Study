package com.devyoung.practice_adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapterHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val textView : TextView = view.findViewById(R.id.textView)

    fun bind(data : RecyclerData){
        textView.text = data.name
    }
}