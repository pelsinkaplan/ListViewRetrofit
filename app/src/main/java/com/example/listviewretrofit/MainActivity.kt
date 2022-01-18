package com.example.listviewretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.listviewretrofit.databinding.ActivityMainBinding
import com.example.listviewretrofit.model.Movie
import com.example.listviewretrofit.view.MovieAdapter
import com.example.listviewretrofit.viewmodel.MovieViewModel
import com.example.listviewretrofit.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MovieViewModel

    private val retrofitService = RetrofitService.getInstance()
    private var adapter: MovieAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, ViewModelFactory(RetrofitRepository(retrofitService))).get(MovieViewModel::class.java)


        viewModel.movieList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter = MovieAdapter(this, it)
            binding.movieListView.adapter = adapter
        })

        viewModel.errorMessage.observe(this, Observer {

        })
        viewModel.getAllMovies()
    }
}


