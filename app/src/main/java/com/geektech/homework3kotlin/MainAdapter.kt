package com.geektech.homework3kotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.homework3kotlin.databinding.SheepItemBinding


    class MainAdapter(private var list: ArrayList<Int>, private val onItemClick: OnItemClick?) :
        RecyclerView.Adapter<MainAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                SheepItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.onBind(list[position])
        }

        override fun getItemCount(): Int = list.size

        inner class ViewHolder(private var binding: SheepItemBinding) :
            RecyclerView.ViewHolder(binding.root) {
            fun onBind(image: Int) {
                binding.ivSheep.setImageResource(image)

                binding.ivSheep.setOnClickListener {
                    if (binding.ivSheep.colorFilter == null) {
                        binding.ivSheep.setColorFilter(R.color.black60)
                        onItemClick?.onClick(image)
                    } else {
                        binding.ivSheep.colorFilter = null
                        onItemClick?.onDeleteClick(image)
                    }
                }
            }
        }

        interface OnItemClick {
            fun onClick(image: Int)
            fun onDeleteClick(image: Int)
        }
    }

