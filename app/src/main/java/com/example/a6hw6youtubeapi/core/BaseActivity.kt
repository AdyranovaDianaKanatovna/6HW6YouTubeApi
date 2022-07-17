package com.example.a6hw6youtubeapi.core

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    protected lateinit var binding: VB
    protected abstract fun inflateViewBinding(): VB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateViewBinding()
        setContentView(binding.root)
        checkInternet()
        setUI()
        initViewModel()
        initClickListener()
    }

    abstract fun initViewModel()

    abstract fun checkInternet()

    abstract fun initClickListener()

    abstract fun setUI()
}