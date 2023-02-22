package com.example.multiviewtyperecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.multiviewtyperecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

//    private var dataAdapter: DataAdapter? = null

    private val dataAdapter by lazy { DataAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        dataAdapter = DataAdapter()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = dataAdapter
        }
        dataAdapter.setItems(mockData())
    }

    private fun mockData(): List<DataModel> = listOf(
        DataModel.Header("header 1"),
        DataModel.Item("title 1", "description 1"),
        DataModel.Item("title 2", "description 2"),
        DataModel.Item("title 3", "description 3"),
        DataModel.Item("title 4", "description 4"),
        DataModel.Item("title 5", "description 5"),
        DataModel.Item("title 6", "description 6"),
        DataModel.Item("title 7", "description 7"),
        DataModel.Item("title 8", "description 8"),
        DataModel.Header("header 2"),
        DataModel.Item("title 9", "description 9"),
        DataModel.Item("title 10", "description 10"),
        DataModel.Item("title 11", "description 11"),
        DataModel.Header("header 3"),
        DataModel.Item("title 12", "description 12"),
        DataModel.Item("title 13", "description 13"),
        DataModel.Item("title 14", "description 14"),
        DataModel.Item("title 15", "description 15"),
    )
}