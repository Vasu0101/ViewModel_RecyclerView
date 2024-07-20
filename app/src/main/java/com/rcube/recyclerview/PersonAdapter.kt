package com.rcube.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.rcube.recyclerview.databinding.SinglePersonRecordBinding

class PersonAdapter(private val viewModel: PersonViewModel) : RecyclerView.Adapter<PersonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_person_record, parent, false)
        val binding = SinglePersonRecordBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PersonViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return viewModel.items.value?.size?: 0
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {

        Log.i("appCheck", "on Bind View Holder")

        val item = viewModel.items.value?.get(position)
        holder.bind(item)
    }
}