package com.example.bjapsubmission1.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataModel (
    var id: String,
    var title: String,
    var description: String,
    var genre: String,
    var release: String,
    var imgPoster: Int,
) : Parcelable