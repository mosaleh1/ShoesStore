package com.udacity.shoestore.models

import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
    @Bindable
    var name: String,
    @Bindable
    var size: Double,
    @Bindable
    var company: String,
    @Bindable
    var description: String,

    val images: List<String> = mutableListOf()
) : Parcelable, BaseObservable()