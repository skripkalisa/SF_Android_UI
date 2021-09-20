package com.example.filmsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonMenu = findViewById<Button>(R.id.button_menu)
        val buttonFavs = findViewById<Button>(R.id.button_favs)
        val buttonLater = findViewById<Button>(R.id.button_later)
        val buttonCollections = findViewById<Button>(R.id.button_collections)
        val buttonSettings = findViewById<Button>(R.id.button_settings)

        buttonMenu.setOnClickListener {
            Toast.makeText(this, "Main menu", Toast.LENGTH_SHORT).show()
        }
        buttonFavs.setOnClickListener {
            Toast.makeText(this, "Add to favorites", Toast.LENGTH_SHORT).show()
        }
        buttonLater.setOnClickListener {
            Toast.makeText(this, "Watch later", Toast.LENGTH_SHORT).show()
        }
        buttonCollections.setOnClickListener {
            Toast.makeText(this, "Open your collections", Toast.LENGTH_SHORT).show()
        }
        buttonSettings.setOnClickListener {
            Toast.makeText(this, "Open settings", Toast.LENGTH_SHORT).show()
        }


    }
}