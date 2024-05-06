package com.example.task2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task2.adapter.RecyclerAdapter

class DashBoard : AppCompatActivity() {
    lateinit var recyclerview : RecyclerView
    var titleList =ArrayList<String>()
    var imageList =ArrayList<Int>()
    var descriptionList =ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dash_board)

        recyclerview = findViewById(R.id.recycleview)

        titleList.add("Rodri")
        titleList.add("Haaland")
        titleList.add("De Bryune")

        imageList.add(R.drawable.rodri)
        imageList.add(R.drawable.haalad)
        imageList.add(R.drawable.kdb)

        descriptionList.add("Machine")
        descriptionList.add("Warrior")
        descriptionList.add("Best in the world")

        var adapter = RecyclerAdapter(titleList, imageList, descriptionList)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = adapter
    }
}