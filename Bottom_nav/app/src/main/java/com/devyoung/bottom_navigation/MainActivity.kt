package com.devyoung.bottom_navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.devyoung.bottom_navigation.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var mBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        //네이게이션을 담는 호스트
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.my_nav_host) as NavHostFragment

        // 네이게이션 컨트롤러
        val navController = navHostFragment.navController

        // 바텀 네비게이션 뷰와 네이게이션을 묶어준다
        NavigationUI.setupWithNavController(mBinding.navBottom, navController)
    }

}