package com.example.moviesapp

import android.content.Context
import com.example.moviesapp.retrofit.MovieServiceExample
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

  private val BASE_URL = "https://api.themoviedb.org"


  @Singleton
  @Provides
  fun provideEngine(
    @ApplicationContext context : Context,
    @Named("Owner") owner : String
  ) : Engine{
    return Engine(context, owner)
  }


  @Singleton
  @Provides
  @Named("String1")
  fun suaraMobil()="Mbrrrrrr"


  @Singleton
  @Provides
  @Named("Owner")
  fun provideOwner()="Arung"


  @Singleton
  @Provides
  fun provideRepository(service : MovieServiceExample) : IMovieRepository{
    return MovieRepository(service)
  }

  @Singleton
  @Provides
  fun getApiServiceInstance(retrofit: Retrofit):MovieServiceExample{
    return retrofit.create(MovieServiceExample::class.java)
  }

  @Singleton
  @Provides
  fun getRetrofitInstance(): Retrofit {
    return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
  }


}