package com.example.recyclerviewbasic

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewbasic.databinding.ItemViewBinding

class NumberListAdapterV3(var data: List<Int>):
    ListAdapter<Int, NumberListAdapterV3.IntViewHolder>(NumberListAdapterV3.RowItemCallback())
{
    class IntViewHolder(val binding: ItemViewBinding):
    RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): IntViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemViewBinding.inflate(
                    layoutInflater,
                    parent, false
                )
                return IntViewHolder(binding)
            }
        }
    }
    class RowItemCallback : DiffUtil.ItemCallback<Int>(){
        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NumberListAdapterV3.IntViewHolder {
        return IntViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: NumberListAdapterV3.IntViewHolder, position: Int) {
        holder.binding.number.text = data.get(position).toString() + " v3 "
        holder.binding.number.setOnClickListener{
            Toast.makeText(holder.binding.number.context, data.get(position).toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}