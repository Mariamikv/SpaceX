package com.example.spacex.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<BD: ViewBinding>
    (private val inflate: Inflate<BD>): Fragment() {

    private var _binding:BD? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (_binding == null){
            _binding = inflate.invoke(inflater,container,false)
            startCreating(inflater,container)
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    abstract fun startCreating(inflater: LayoutInflater, container: ViewGroup?)

}