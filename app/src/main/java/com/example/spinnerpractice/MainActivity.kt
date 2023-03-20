package com.example.spinnerpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.ViewParent
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.spinnerpractice.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    var spinnerArray = arrayListOf("Male", "Female","Other")
    lateinit var spinnerAdapter : ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    spinnerAdapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,spinnerArray)
   binding.spinnerArray.adapter=spinnerAdapter
        binding.spinnerXML.onItemSelectedListener =object :
            AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity, "clicked item $position  $id", Toast.LENGTH_LONG)
                    .show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        binding.btnGetValue.setOnClickListener {
            System.out.println("spinner first value ${binding.spinnerXML.selectedItem}")
            System.out.println("spinner second value ${binding.spinnerArray.selectedItem}")
            System.out.println("other value ${binding.etOtherGender.text.toString()}")
        }
    }
}