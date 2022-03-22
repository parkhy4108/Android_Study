package com.devyoung.retrofit.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.devyoung.retrofit.CompletionListener
import com.devyoung.retrofit.Data
import com.devyoung.retrofit.R
import com.devyoung.retrofit.databinding.ActivityMainBinding
import com.devyoung.retrofit.repository.BaeminRepository

class MainActivity : AppCompatActivity() , CompletionListener {

    private lateinit var binding : ActivityMainBinding // binding 선언
    private lateinit var noticeAdapter: NoticeAdapter //어뎁터 클래스 선언
    private var baeminRepository = BaeminRepository() //클래스 선언
    private var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) //
        setContentView(binding.root)
        
        binding.rvBaeminNotice.apply {
            binding.rvBaeminNotice.layoutManager = LinearLayoutManager(context)
            noticeAdapter = NoticeAdapter()
            binding.rvBaeminNotice.adapter = noticeAdapter
        }
        baeminRepository.loadBaeminNotice(page,this) // 첫페이지

        binding.btnLoadNextPage.setOnClickListener {
            baeminRepository.loadBaeminNotice(++page, this) //다음페이지 로드
        }
    }

    // 성공적으로 로드한 경우

    override fun loadComplete(data: Data) {
        noticeAdapter.setList(data.content)
        noticeAdapter.notifyItemRangeChanged(0,9)
    }

    // 응답에 문제가 있는 경우
    override fun responseIsNotSuccessful(code: Int) {
        Toast.makeText(this,"사이트가 응답하지 않습니다", Toast.LENGTH_SHORT)
            .show()
        Log.v("로그", code.toString())
    }

    // 로드에 실패한 경우
    override fun loadFail() {
        Toast.makeText(this, "인터넷 연결을 확인하세요", Toast.LENGTH_SHORT)
            .show()
    }
}