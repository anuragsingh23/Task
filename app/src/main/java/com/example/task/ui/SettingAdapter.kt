package com.example.task.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.task.databinding.ItemRecyclerviewBinding
import com.example.task.model.response.Role

class SettingAdapter(private val list : List<Role>) : RecyclerView.Adapter<SettingAdapter.SettingViewHolder>(){



    inner class SettingViewHolder(private val binding : ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root){
            fun bindItem(role : Role){
                binding.apply {
                    tvName.text = role.name
                    ivRole.load(role.getImageUrl())
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingViewHolder {
        return SettingViewHolder(ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context),parent,false
        ))
    }

    override fun onBindViewHolder(holder: SettingViewHolder, position: Int) {
        val role = list[position]
        holder.bindItem(role)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}


