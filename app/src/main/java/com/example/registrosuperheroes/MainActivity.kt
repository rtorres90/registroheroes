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
            val hero = Superhero(superHeroName, alterEgo, bio, power)
            openDetailActivity(hero)
        }
    }

    private fun openDetailActivity(hero: Superhero) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.SUPERHERO_KEY, hero)
        startActivity(intent)
    }
}