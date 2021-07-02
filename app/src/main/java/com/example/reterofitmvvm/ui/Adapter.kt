package com.example.reterofitmvvm.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.reterofitmvvm.databinding.UniItemBinding
import com.example.reterofitmvvm.modal.data.University

class Adapter: ListAdapter<University,  Adapter.UniversityViewHolder>(GIRLS_COMPARATOR)
{
    class UniversityViewHolder (var binding: UniItemBinding) : RecyclerView.ViewHolder(binding.root)
    companion object {
        val GIRLS_COMPARATOR = object : DiffUtil.ItemCallback<University>() {
            override fun areItemsTheSame(oldItem: University, newItem: University): Boolean {
                println(" item same ")
                return oldItem == newItem;
            }

            override fun areContentsTheSame(oldItem: University, newItem: University): Boolean {
                print(" Content same ")
                return oldItem.name.equals(newItem.name)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityViewHolder
    {
        println("On view create ")
        val inflater = LayoutInflater.from(parent.context)
        val binding = UniItemBinding.inflate(inflater)
        return UniversityViewHolder(binding)
         }

    override fun onBindViewHolder(holder: UniversityViewHolder, position: Int)
    {
        println("On view bind"+getItem(position).name)
        holder.binding.uni= getItem(position)
        holder.binding.executePendingBindings()
    }


}