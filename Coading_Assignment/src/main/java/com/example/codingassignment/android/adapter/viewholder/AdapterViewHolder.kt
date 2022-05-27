package com.example.codingassignment.android.adapter.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.codingassignment.android.R
import com.example.codingassignment.android.model.Data

class HeaderViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
    internal val heading: TextView = itemView.findViewById(R.id.tv_section)

    fun bind(item : Data){
        heading.text = item.header
    }
}

class OneViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

    private val image1: ImageView = itemView.findViewById(R.id.img1)
    private val image2 : ImageView= itemView.findViewById(R.id.img2)
    private val image3: ImageView = itemView.findViewById(R.id.iv_img3)

    fun bind(item : Data){
        image1.setImageResource(item.firstItem?.get(0)!!)
        image2.setImageResource(item.firstItem[1])
        image3.setImageResource(item.firstItem[2])
    }
}