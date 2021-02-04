package com.example.bjapsubmission1.ui.detail

import androidx.lifecycle.ViewModel
import com.example.bjapsubmission1.model.DataModel
import com.example.bjapsubmission1.utils.DataDummy

class DetailViewModel : ViewModel() {

    private lateinit var movieId: String
    private lateinit var tvId: String

    private fun getMovies(): ArrayList<DataModel> =
        DataDummy.generateMovies() as ArrayList<DataModel>

    private fun getTv(): ArrayList<DataModel> =
        DataDummy.generateTv() as ArrayList<DataModel>

    fun setMovieId(id: String) {
        this.movieId = id
    }

    fun setTvId(id: String) {
        this.tvId = id
    }

        fun getDetailMovieById(): DataModel {
            lateinit var result: DataModel
            val listMovies = getMovies()
            for (movie in listMovies) {
                if (movie.id == movieId) {
                    result = movie
                    break
                }
            }
            return result
    }

    fun getDetailTvById(): DataModel {
        lateinit var result: DataModel
        val listTv = getTv()
        for (tv in listTv) {
            if (tv.id == tvId) {
                result = tv
                break
            }
        }
        return result
    }
}