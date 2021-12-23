package com.example.registrosuperheroes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.registrosuperheroes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.saveButton.setOnClickListener {
            openDetailActivity()
        }
    }

    private fun openDetailActivity(){
        val intent = Intent(this, DetailActivity::class.java)
        startActivity(intent)
    }
}