package com.example.moviesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso


class MovieCardAdapter(private val dataSet: Array<MovieItem>) :
  RecyclerView.Adapter<MovieCardAdapter.ViewHolder>() {

  /**
   * Provide a reference to the type of views that you are using
   * (custom ViewHolder).
   *
   *
   */

  class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val title: TextView
    val image : ImageView

    init {
      // Define click listener for the ViewHolder's View.
      title = view.findViewById(R.id.title)
      image = view.findViewById(R.id.img)
    }
  }

  // Create new views (invoked by the layout manager)
  override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
    // Create a new view, which defines the UI of the list item
    val view = LayoutInflater.from(viewGroup.context)
      .inflate(R.layout.movie_item, viewGroup, false)

    return ViewHolder(view)
  }

  // Replace the contents of a view (invoked by the layout manager)
  override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {


    // Get element from your dataset at this position and replace the
    // contents of the view with that element
    viewHolder.title.text = dataSet[position].title
    Picasso.get()
      .load("https://image.tmdb.org/t/p/w500/${dataSet[position].image}")
      .placeholder(R.drawable.maskgroup)
      .networkPolicy(NetworkPolicy.OFFLINE)
        .into(viewHolder.image)

  }

  // Return the size of your dataset (invoked by the layout manager)
  override fun getItemCount() = dataSet.size

}
