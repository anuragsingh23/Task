package com.example.task.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.repository.Repository
import com.example.task.databinding.ActivityMainBinding
import com.example.task.model.response.Role
import com.example.task.utils.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var  viewModel : MainViewModel



    private lateinit var binding: ActivityMainBinding
    private lateinit var myAdapter: SettingAdapter
    private var list = ArrayList<Role>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
           binding = ActivityMainBinding.inflate(layoutInflater)
           setContentView(binding.root)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory )[MainViewModel::class.java]

        viewModel.myResponse.observe(this) { it ->
            it?.let {
                list.addAll(it)
                recyclerView(list)
            }
        }
    }

    fun recyclerView(list : ArrayList<Role>){
        myAdapter = SettingAdapter(list)
        binding.recyclerView.layoutManager =
            GridLayoutManager(applicationContext,
                2 ,GridLayoutManager.VERTICAL
                ,false)

        binding.recyclerView.adapter = myAdapter
    }

}


