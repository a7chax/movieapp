package com.example.moviesapp

import android.content.Context

class Engine(private val context:Context, private val  owner : String) {
  fun startEngine(){
    println("${context.getString(R.string.engineStarted)} by owner")
  }
}