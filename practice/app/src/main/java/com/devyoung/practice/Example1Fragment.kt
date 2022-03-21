package com.devyoung.practice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import com.devyoung.practice.databinding.Example1FragmentBinding

class Example1Fragment : Fragment() {
    private var mbinding : Example1FragmentBinding? = null

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        val binding = Example1FragmentBinding.inflate(inflater,container,false)
        mbinding = binding
        return mbinding!!.root
    }

    override fun onDestroyView() {
        mbinding = null
        super.onDestroyView()
    }
}