package com.example.bjapsubmission1.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.bjapsubmission1.R
import com.example.bjapsubmission1.model.DataModel
import com.example.bjapsubmission1.utils.Helper.TYPE_MOVIE
import com.example.bjapsubmission1.utils.Helper.TYPE_TV
import com.example.bjapsubmission1.utils.Helper.setGlideImg
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var result: DataModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

        supportActionBar?.title = resources.getString(R.string.now_showing)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val data = intent.getStringExtra(EXTRA_DATA)
        val type = intent.getStringExtra(EXTRA_TYPE)

        if (type.equals(TYPE_MOVIE, ignoreCase = true)) {
            data?.let { viewModel.setMovieId(it) }
            result = viewModel.getDetailMovieById()
        } else if (type.equals(TYPE_TV, ignoreCase = true)) {
            data?.let { viewModel.setTvId(it) }
            result = viewModel.getDetailTvById()
        }

        setGlideImg(this, result.imgPoster, img_poster)
        tv_title.text = result.title
        tv_release.text = result.release
        tv_genre.text = result.genre
        tv_description.text = result.description

    }
}