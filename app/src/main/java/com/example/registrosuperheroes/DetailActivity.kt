package com.example.registrosuperheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registrosuperheroes.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    companion object{
        const val SUPERHERO_KEY = "superhero"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras!!
        val superHero = bundle.getParcelable<Superhero>(SUPERHERO_KEY)!!

        binding.heroName.text = superHero.name
        binding.alterEgoText.text = superHero.alterEgo
        binding.bioText.text = superHero.bio
        binding.detailPoderBar.rating = superHero.power
    }
}