package com.devyoung.practice_adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devyoung.practice_adapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    //
    var datalist = ArrayList<RecyclerData>()
    private lateinit var customAdapter :CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        for (i in 0..10){
            val recyclerData = RecyclerData(name = "박하영 $i")
            this.datalist.add(recyclerData)
        }

        //어댑터 인스턴스 생성
        customAdapter = CustomAdapter()

        customAdapter.submitList(this.datalist)

        binding.Recyclerview.apply {
            binding.Recyclerview.layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
            binding.Recyclerview.adapter = customAdapter
        }
    }
}