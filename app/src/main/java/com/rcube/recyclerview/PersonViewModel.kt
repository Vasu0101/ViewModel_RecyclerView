package com.rcube.recyclerview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PersonViewModel: ViewModel() {
    private val _items = MutableLiveData<List<PersonData>>()
    val items: LiveData<List<PersonData>> = _items

    init {
        _items.value = emptyList()
    }

    fun addItem(name: String, phone: String, about: String) {

        Log.i("appCheck", "ViewModel Add Item Called");
        Log.i("appCheck", "Name: $name");
        Log.i("appCheck", "Phone: $phone");
        Log.i("appCheck", "About: $about");


        val newItem = PersonData(name, phone, about)
        val currentItems = _items.value?: emptyList()
        _items.value = currentItems + newItem

        Log.i("appCheck", "Items: ${_items.value}")
    }
}