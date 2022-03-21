package com.devyoung.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.devyoung.practice.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val example1Fragment = Example1Fragment()
        val example2Fragment = Example2Fragment()
        val fragmentManager = supportFragmentManager


        supportFragmentManager.commit {
            add(R.id.fragment_container, example2Fragment)
            add(R.id.fragment_container, example1Fragment)
        }

        binding.button1.setOnClickListener {
            supportFragmentManager.commit {
                hide(example2Fragment)
                show(example1Fragment)
            }
        }
        binding.button2.setOnClickListener {
            supportFragmentManager.commit {
                hide(example1Fragment)
                show(example2Fragment)
            }

        }

    }

}