  package com.example.moviesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.retrofit.MovieServiceExample
import com.example.moviesapp.retrofit.RetrofitClient
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

  @AndroidEntryPoint
  class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

//    @Inject
//    lateinit var engine : Engine

//
//    @Inject
//    lateinit var string : String

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val movieList : RecyclerView =  findViewById(R.id.list_movie)
//    val retrofit = RetrofitClient().getRetrofitInstance()
//    val serviceMovie = retrofit?.create(MovieServiceExample::class.java)
//    val repository = MovieRepository(service = serviceMovie)
//    val vm = ViewModelProvider(this, MainViewModel.Factory(repository)).get(MainViewModel::class.java)


//    engine.startEngine()

//    println(string)

    viewModel.movies.observe(this, {movies ->
      Log.d("MOVIESNYA",movies.toString())
      movieList.apply {
        adapter = MovieCardAdapter(movies.toTypedArray())
      }

    })


  }

  }


