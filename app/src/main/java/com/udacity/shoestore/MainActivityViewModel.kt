package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MainActivityViewModel() : ViewModel() {

    private var shoeList = listOf<Shoe>()

    private val _shoeListLiveData = MutableLiveData<List<Shoe>>()
    val shoeListLiveData: LiveData<List<Shoe>> get() = _shoeListLiveData


    init {
        fillTheList()
    }

    private fun fillTheList() {
        for (i in 1..28) {
            shoeList = shoeList.plus(
                Shoe(
                    "Shoe $i",
                    i + 8.toDouble(),
                    "C$i Company",
                    "This is Shoe $i description"
                )
            )
        }
        _shoeListLiveData.postValue(shoeList)
    }

    private val TAG = "ShoeListViewModel"
    fun add(shoe: Shoe) {
        Log.d(TAG, "add: $shoe.name $shoe.size $shoe.company $shoe.description")
        _shoeListLiveData.postValue(shoeList.plus(shoe))
        _shoeListLiveData.postValue(shoeList.plus(shoe))
    }
}