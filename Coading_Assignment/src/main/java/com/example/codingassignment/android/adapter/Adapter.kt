package com.example.codingassignment.android.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.LayoutInflater.from
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codingassignment.android.R
import com.example.codingassignment.android.adapter.viewholder.HeaderViewHolder
import com.example.codingassignment.android.adapter.viewholder.OneViewHolder
import com.example.codingassignment.android.model.Data
import com.shuhart.stickyheader.StickyAdapter

class Adapter(private val list: ArrayList<Data>):StickyAdapter<RecyclerView.ViewHolder, RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 1){
            HeaderViewHolder(from(parent.context).inflate(R.layout.heading_section_layout, parent, false))
        }else {
            OneViewHolder(from(parent.context).inflate(R.layout.one_part_item_layout, parent,false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderViewHolder -> {
                holder.bind(list[position])
            }
            is OneViewHolder -> {
                holder.bind(list[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (list[position].header != null){
            1
        }else{
            2
        }
    }

    override fun getHeaderPositionForItem(itemPosition: Int): Int {
        return itemPosition / 2
    }

    @SuppressLint("SetTextI18n")
    override fun onBindHeaderViewHolder(holder: RecyclerView.ViewHolder?, headerPosition: Int) {
        (holder as HeaderViewHolder).heading.text = "Section $headerPosition"
    }

    override fun onCreateHeaderViewHolder(parent: ViewGroup?): RecyclerView.ViewHolder {
        return createViewHolder(parent!!, 1);
    }
}