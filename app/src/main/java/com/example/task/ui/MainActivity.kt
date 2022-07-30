package com.example.task.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.repository.Repository
import com.example.task.R
import com.example.task.utils.MainViewModelFactory

class MainActivity : AppCompatActivity() {

  private lateinit var  viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory )[MainViewModel::class.java]

        viewModel.getPost()

        viewModel.myResponse.observe(this , Observer{ response ->
            Log.d("Response" , response.name)
            Log.d("Response" , response.url)

        })
    }

}