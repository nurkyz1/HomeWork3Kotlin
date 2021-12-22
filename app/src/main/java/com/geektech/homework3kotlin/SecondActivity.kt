package com.geektech.homework3kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geektech.homework3kotlin.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val list = intent.getIntegerArrayListExtra("image")
        adapter = MainAdapter(list!!, null)
        binding.rvImages.adapter = adapter
    }
}