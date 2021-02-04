package com.example.bjapsubmission1.ui.home.content

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class ContentViewModelTest {

    private lateinit var viewModel: ContentViewModel

    @Before
    fun setUp() {
        viewModel = ContentViewModel()
    }

    @Test
    fun getListMovie() {
        val movie = viewModel.getListMovie()
        assertNotNull(movie)
        assertEquals(10, movie.size)
    }

    @Test
    fun getListTv() {
        val tv = viewModel.getListTv()
        assertNotNull(tv)
        assertEquals(10, tv.size)
    }
}