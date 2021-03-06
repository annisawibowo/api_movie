package com.example.readjson.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.readjson.R
import com.example.readjson.model.Movie
import kotlinx.android.synthetic.main.item_list.view.*

class MovieAdapter(val movies : ArrayList<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies.get(position))
    }

    override fun getItemCount() = movies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MovieViewHolder(view)
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private var view : View = itemView
        private var movie : Movie? = null

        override fun onClick(p0: View?) {
            Toast.makeText(view.context, "Item diklik", Toast.LENGTH_LONG).show()
        }

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(movie: Movie) {
            this.movie = movie
            val imageUrl = StringBuilder()
            imageUrl.append(view.context.getString(R.string.poster)).append(movie.posterPath)
            view.mvTitle.setText(movie.originalTitle)
            Glide.with(view.context).load(imageUrl.toString()).into(view.mvPoster)
        }
    }
}