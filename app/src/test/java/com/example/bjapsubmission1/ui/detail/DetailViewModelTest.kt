package com.example.bjapsubmission1.ui.detail

import com.example.bjapsubmission1.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateMovies()[0]
    private val dummyTv = DataDummy.generateTv()[0]
    private val movieId = dummyMovie.id
    private val tvId = dummyTv.id

    @Before
    fun setUp() {
        viewModel = DetailViewModel()
        viewModel.setMovieId(movieId)
        viewModel.setTvId(tvId)
    }

    @Test
    fun getDetailMovieById() {
        val movie = viewModel.getDetailMovieById()
        assertNotNull(movie)
        assertEquals(dummyMovie.title, movie.title)
        assertEquals(dummyMovie.release, movie.release)
        assertEquals(dummyMovie.genre, movie.genre)
        assertEquals(dummyMovie.description, movie.description)
        assertEquals(dummyMovie.imgPoster, movie.imgPoster)
    }

    @Test
    fun getDetailTvById() {
        val tv = viewModel.getDetailTvById()
        assertNotNull(tv)
        assertEquals(dummyTv.title, tv.title)
        assertEquals(dummyTv.release, tv.release)
        assertEquals(dummyTv.genre, tv.genre)
        assertEquals(dummyTv.description, tv.description)
        assertEquals(dummyTv.imgPoster, tv.imgPoster)
    }
}