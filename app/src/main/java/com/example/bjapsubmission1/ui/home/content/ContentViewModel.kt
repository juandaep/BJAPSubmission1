package com.example.bjapsubmission1.ui.home.content

import androidx.lifecycle.ViewModel
import com.example.bjapsubmission1.model.DataModel
import com.example.bjapsubmission1.utils.DataDummy

class ContentViewModel : ViewModel() {

    fun getListMovie(): List<DataModel> = DataDummy.generateMovies()

    fun getListTv() : List<DataModel> = DataDummy.generateTv()
}