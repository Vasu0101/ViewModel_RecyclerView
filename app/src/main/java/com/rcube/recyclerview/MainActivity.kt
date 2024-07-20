package com.rcube.recyclerview

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rcube.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: PersonViewModel
    private lateinit var adapter: PersonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModel = ViewModelProvider(this)[PersonViewModel::class.java]
        adapter = PersonAdapter(viewModel)

        binding.btnSubmit.setOnClickListener {

            Log.i("appCheck", "Submit Button Clicked");

            val name = binding.etName.text.toString()
            val phone = binding.etPhone.text.toString()
            val about = binding.etBio.text.toString()

            viewModel.addItem(name, phone, about);
        }

        viewModel.items.observe(this, Observer {
            Log.i("appCheck", "View Model Observer, data Changed");
            adapter.notifyDataSetChanged()
        })
    }
}