package com.example.numbertrivia

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.numbertrivia.databinding.ActivityMainBinding
import java.util.Collections.shuffle


class MainActivity : AppCompatActivity() {

    private lateinit var imageViews: List<ImageView>
    private lateinit var imageId: List<Pair<Int, Int>>
    private lateinit var binding: ActivityMainBinding
    private var prev = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            imageViews = listOf(
                imageView1, imageView2, imageView3,
                imageView4, imageView5, imageView6,
                imageView7, imageView8, imageView9
            )
            imageId = listOf(
                Pair(1, R.drawable.image1), Pair(2, R.drawable.image2), Pair(3, R.drawable.image3),
                Pair(4, R.drawable.image4), Pair(5, R.drawable.image5), Pair(6, R.drawable.image6),
                Pair(7, R.drawable.image7), Pair(8, R.drawable.image8), Pair(9, R.drawable.image9),
            )
        }

        shuffleImages()
        binding.shuffle.setOnClickListener { shuffleImages() }

        binding.start.setOnClickListener { startGame() }

        binding.gameOver.setOnClickListener {
            navigateUpTo(Intent(this@MainActivity, MainActivity::class.java))
            startActivity(intent)
        }
    }

    private fun startGame() {
        for (imageView in imageViews) {
            imageView.setImageResource(R.drawable.white)
        }
        binding.apply {
            shuffle.visibility = View.GONE
            start.visibility = View.GONE
            gameOver.visibility = View.VISIBLE
        }

        for (imageView in imageViews){
            imageView.setOnClickListener{ getImage(imageView) }
        }
    }

    private fun getImage(it: View) {
        binding.apply {
            when (it.id) {
                R.id.imageView1 -> {
                    imageView1.setImageResource(imageId[0].second)
                    if (imageId[0].first-prev != 1){
                        Toast.makeText(this@MainActivity, "You LOOSE", Toast.LENGTH_LONG).show()
                    }
                    prev = imageId[0].first
                    if (prev == 9)  Toast.makeText(this@MainActivity, "You Won", Toast.LENGTH_LONG).show()
                }
                R.id.imageView2 -> {
                    imageView2.setImageResource(imageId[1].second)
                    if (imageId[1].first-prev != 1){
                        Toast.makeText(this@MainActivity, "You LOOSE", Toast.LENGTH_LONG).show()
                    }
                    prev = imageId[1].first
                    if (prev == 9)  Toast.makeText(this@MainActivity, "You Won", Toast.LENGTH_LONG).show()
                }
                R.id.imageView3 -> {
                    imageView3.setImageResource(imageId[2].second)
                    if (imageId[2].first-prev != 1){
                        Toast.makeText(this@MainActivity, "You LOOSE", Toast.LENGTH_LONG).show()
                    }
                    prev = imageId[2].first
                    if (prev == 9)  Toast.makeText(this@MainActivity, "You Won", Toast.LENGTH_LONG).show()
                }
                R.id.imageView4 -> {
                    imageView4.setImageResource(imageId[3].second)
                    if (imageId[3].first-prev != 1){
                        Toast.makeText(this@MainActivity, "You LOOSE", Toast.LENGTH_LONG).show()
                    }
                    prev = imageId[3].first
                    if (prev == 9)  Toast.makeText(this@MainActivity, "You Won", Toast.LENGTH_LONG).show()
                }
                R.id.imageView5 -> {
                    imageView5.setImageResource(imageId[4].second)
                    if (imageId[4].first-prev != 1){
                        Toast.makeText(this@MainActivity, "You LOOSE", Toast.LENGTH_LONG).show()
                    }
                    prev = imageId[4].first
                    if (prev == 9)  Toast.makeText(this@MainActivity, "You Won", Toast.LENGTH_LONG).show()
                }
                R.id.imageView6 -> {
                    imageView6.setImageResource(imageId[5].second)
                    if (imageId[5].first-prev != 1){
                        Toast.makeText(this@MainActivity, "You LOOSE", Toast.LENGTH_LONG).show()
                    }
                    prev = imageId[5].first
                    if (prev == 9)  Toast.makeText(this@MainActivity, "You Won", Toast.LENGTH_LONG).show()
                }
                R.id.imageView7 -> {
                    imageView7.setImageResource(imageId[6].second)
                    if (imageId[6].first-prev != 1){
                        Toast.makeText(this@MainActivity, "You LOOSE", Toast.LENGTH_LONG).show()
                    }
                    prev = imageId[6].first
                    if (prev == 9)  Toast.makeText(this@MainActivity, "You Won", Toast.LENGTH_LONG).show()
                }
                R.id.imageView8 -> {
                    imageView8.setImageResource(imageId[7].second)
                    if (imageId[7].first-prev != 1){
                        Toast.makeText(this@MainActivity, "You LOOSE", Toast.LENGTH_LONG).show()
                    }
                    prev = imageId[7].first
                    if (prev == 9)  Toast.makeText(this@MainActivity, "You Won", Toast.LENGTH_LONG).show()
                }
                else -> {
                    imageView9.setImageResource(imageId[8].second)
                    if (imageId[8].first-prev != 1){
                        Toast.makeText(this@MainActivity, "You LOOSE", Toast.LENGTH_LONG).show()
                    }
                    prev = imageId[8].first
                    if (prev == 9)  Toast.makeText(this@MainActivity, "🏆 You Won 🏆", Toast.LENGTH_LONG).show()
                }
            }
        }
    }


    private fun shuffleImages() {
        shuffle(imageId)
        imageViews.zip(imageId).forEach { pair ->
            pair.component1().setImageResource(pair.component2().second)
        }
    }


}