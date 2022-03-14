package com.devyoung.databinding

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.devyoung.databinding.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    var text = "TEST" // xml에 Textview의 text={@main.text}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.main = this // xml에서 정의한 data의 name
        binding.btnChange.setOnClickListener{
            text = "CHANGE"
            binding.invalidateAll() // invalidateAll() : data가 변한 후 연결된 view들에 변화를 알려주는 메소드
        }

    }
}