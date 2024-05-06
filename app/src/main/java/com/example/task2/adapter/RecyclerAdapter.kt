package com.example.task2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.task2.R

class RecyclerAdapter(
    var titleList: ArrayList<String>,
    var imageList: ArrayList<Int>,
    var descriptionList: ArrayList<String>
) : RecyclerView.Adapter<RecyclerAdapter.FruitsViewHolder>() {

    class FruitsViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var title : TextView = view.findViewById(R.id.textViewTitle)
        var descrription : TextView = view.findViewById(R.id.textViewDescription)
        var images : ImageView = view.findViewById(R.id.imageView2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitsViewHolder {
        var view : View = LayoutInflater.from(parent.context).inflate(R.layout.sample_recycler_view_1,parent,false)

        return FruitsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return titleList.size
    }

    override fun onBindViewHolder(holder: FruitsViewHolder, position: Int) {
        holder.title.text = titleList[position]
        holder.descrription.text = descriptionList[position]
        holder.images.setImageResource(imageList[position])
    }


}