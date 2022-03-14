package com.devyoung.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.devyoung.livedata.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    //activity_main의 ViewBinding을 만들기 위해 binding 선언

    private var liveText : MutableLiveData<String> = MutableLiveData()
    // LiveData는 abstract class 이므로 LiveData class를 상속받은 MutableLiveData()를 사용
    // livedate is abstract class so use mutableLiveData() overriding LiveData class

    private var num = 0
    // init num (click button num for counting)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        // layout inflate activity_main now we can connect to xml main for binding
        setContentView(binding.root)
        //set content view to binding.root
        liveText.observe(this, Observer {
            binding.textTest.text = it
        })
        binding.btnChange.setOnClickListener{
            liveText.value = "View Binding Test ${++num}"
        }
       
    }

}