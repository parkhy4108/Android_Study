package com.devyoung.viewmodel

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.devyoung.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val userviewmodel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        //databinding 연결
        binding.userviewModel = userviewmodel
        // layout의 viewModel 변수를 viewModel과 바인딩
        Log.d(TAG,"시작")
        binding.lifecycleOwner = this
        userviewmodel.currentValue.observe(this, Observer {
            binding.inputNum.text = it.toString()
        })
    }




}