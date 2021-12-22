package com.geektech.homework3kotlin

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geektech.homework3kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: MainAdapter

    private var list = arrayListOf<Int>()
    private var secondList = arrayListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createList()
        initRv()
        send()
    }

    private fun send() {
        binding.btnSend.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("image", secondList)
            startActivity(intent)
        }
    }

    private fun createList() : ArrayList<Int> {
        for (i in 1..40){
            list.add(R.drawable.img)
            list.add(R.drawable.img_1)
            list.add(R.drawable.img_2)
        }
        return list
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initRv() {
        adapter = MainAdapter(createList(), object : MainAdapter.OnItemClick{
            override fun onClick(image: Int) {
                secondList.add(image)
            }
            override fun onDeleteClick(image: Int) {
                secondList.remove(image)
            }
        })
        binding.rvImages.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}