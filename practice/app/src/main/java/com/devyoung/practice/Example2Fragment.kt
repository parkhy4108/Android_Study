package com.devyoung.practice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devyoung.practice.databinding.Example2FragmentBinding

class Example2Fragment : Fragment() {
    private var mbinding : Example2FragmentBinding? = null

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        val binding = Example2FragmentBinding.inflate(inflater,container,false)
        mbinding = binding
        return mbinding!!.root
    }

    override fun onDestroyView() {
        mbinding = null
        super.onDestroyView()
    }
}