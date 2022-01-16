package com.example.moviesapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (private  val repository: IMovieRepository) : ViewModel() {
  private var _movies = MutableLiveData<List<MovieItem>>();
  val movies : LiveData<List<MovieItem>> = _movies;



  init {
    getMovies()
  }

  private fun getMovies(){
    repository.getMovies({movies ->
      _movies.value = movies
    }, {errorMessage ->
      print(errorMessage)
    })
  }




}