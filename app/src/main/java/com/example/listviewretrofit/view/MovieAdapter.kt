package com.example.listviewretrofit.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.listviewretrofit.databinding.ItemMovieBinding
import com.example.listviewretrofit.model.Movie
import com.squareup.picasso.Picasso
import android.R

import android.widget.TextView

import android.app.Activity

import android.widget.ArrayAdapter
import android.widget.ImageView


class MovieAdapter(
    private val context: Context,
    private val list: List<Movie>
) : BaseAdapter() {
    private lateinit var binding: ItemMovieBinding

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val movie = list[position]
        binding.movieName.text = movie.name
        binding.movieDesc.text = movie.desc
        Picasso.get().load(movie.imageUrl).centerCrop().resize(100, 200).into(binding.movieImageview)
        return binding.root
    }
}

