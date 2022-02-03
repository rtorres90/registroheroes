package com.example.registrosuperheroes

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import com.example.registrosuperheroes.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var heroImage: ImageView
    private var heroBitmap: Bitmap? = null
    private var picturePath = ""

    val getContent =
        registerForActivityResult(ActivityResultContracts.TakePicture()) { success ->
            if (success && picturePath.isNotEmpty()) {
                heroBitmap = BitmapFactory.decodeFile(picturePath)
                heroImage.setImageBitmap(heroBitmap!!)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.saveButton.setOnClickListener {
            val superHeroName = binding.heroNameEdit.text.toString()
            val alterEgo = binding.alterEgoEdit.text.toString()
            val bio = binding.bioEdit.text.toString()
            val power = binding.poderBar.rating
            val hero = Superhero(superHeroName, alterEgo, bio, power)
            openDetailActivity(hero)
        }
        heroImage = binding.heroImage
        binding.heroImage.setOnClickListener {
            openCamera()
        }
    }

    private fun openCamera() {
        val file = createImageFile()
        val uri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            FileProvider.getUriForFile(
                this,
                "$packageName.provider",
                file
            )
        } else {
            Uri.fromFile(file)
        }
        getContent.launch(uri)
    }

    private fun createImageFile(): File {
        val fileName = "superhero_image"
        val fileDirectory = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val file = File.createTempFile(fileName, ".jpg", fileDirectory)
        picturePath = file.absolutePath
        return file
    }

    private fun openDetailActivity(hero: Superhero) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.SUPERHERO_KEY, hero)
        intent.putExtra(DetailActivity.BITMAP_KEY, picturePath)
        startActivity(intent)
    }

}