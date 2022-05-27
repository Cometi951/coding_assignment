package com.example.codingassignment.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.codingassignment.Greeting
import com.example.codingassignment.android.model.Data
import com.shuhart.stickyheader.StickyHeaderItemDecorator


fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    val list = ArrayList<Data>()
    val gridImage = ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv: RecyclerView = findViewById(R.id.rv_gridItem1)

        val dividerDecorator = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        rv.addItemDecoration(dividerDecorator)


        val adapter = com.example.codingassignment.android.adapter.Adapter(list)
        rv.adapter = adapter

        val decorator = StickyHeaderItemDecorator(adapter)
        decorator.attachToRecyclerView(rv)

        setData()
        rv.adapter?.notifyDataSetChanged()
    }

    private fun setData(){
        gridImage.add(R.drawable.flower)
        gridImage.add(R.drawable.image1)
        gridImage.add(R.drawable.natural)
        for (i in 0..10){
            list.add(Data("Section $i"))
            list.add(Data(firstItem = gridImage))
        }
    }
}
