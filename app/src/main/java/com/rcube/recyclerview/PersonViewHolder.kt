package com.rcube.recyclerview

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.rcube.recyclerview.databinding.SinglePersonRecordBinding

class PersonViewHolder(private val binding: SinglePersonRecordBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PersonData?) {

        Log.i("appCheck","View Holder Fun bind called");

        item?.let {
            binding.tvName.text = it.name
            binding.tvPhone.text = it.phone
            binding.tvBio.text = it.about
        }
    }

}