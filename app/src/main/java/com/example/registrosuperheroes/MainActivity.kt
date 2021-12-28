package com.example.registrosuperheroes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registrosuperheroes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.saveButton.setOnClickListener {
            var superHeroName = binding.heroNameEdit.text.toString()
            var alterEgo = binding.alterEgoEdit.text.toString()
            var bio = binding.bioEdit.text.toString()
            var power = binding.poderBar.rating
            openDetailActivity(superHeroName, alterEgo, bio, power)
        }
    }

    private fun openDetailActivity(
        superHeroName: String,
        alterEgo: String,
        bio: String,
        power: Float
    ) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.SUPERHERO_NAME_KEY, superHeroName)
        intent.putExtra(DetailActivity.ALTER_EGO_KEY, alterEgo)
        intent.putExtra(DetailActivity.BIO_KEY, bio)
        intent.putExtra(DetailActivity.POWER_KEY, power)
        startActivity(intent)
    }
}