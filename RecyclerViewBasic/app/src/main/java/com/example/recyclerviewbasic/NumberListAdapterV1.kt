package com.example.recyclerviewbasic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class NumberListAdapterV1(var data: List<Int>):
    RecyclerView.Adapter<NumberListAdapterV1.IntViewHolder>()
{
    class IntViewHolder(val row: View): RecyclerView.ViewHolder(row) {
        val textView = row.findViewById<TextView>(R.id.number)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        return IntViewHolder(layout)

    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: IntViewHolder, position: Int) {
        holder.textView.text = data.get(position).toString()

        holder.row.setOnClickListener {
            Toast.makeText(holder.row.context, data.get(position).toString(), Toast.LENGTH_SHORT).show()
        }
    }
}