package com.udacity.shoestore

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivityViewModelFactory private constructor() :
    ViewModelProvider.Factory {

    companion object {
        @Volatile
        private var instance: MainActivityViewModelFactory? = null

        fun getInstance(context: Context): MainActivityViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: MainActivityViewModelFactory()
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(MainActivityViewModel::class.java) -> {
                MainActivityViewModel() as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}