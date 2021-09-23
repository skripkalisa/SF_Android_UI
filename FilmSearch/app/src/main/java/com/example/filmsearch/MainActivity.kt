package com.example.filmsearch

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val topAppBar = findViewById<MaterialToolbar>(R.id.topAppBar)
        topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.settings -> {
                    Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener() {

            when (it.itemId) {
                R.id.favorites -> {
                    Toast.makeText(this, "Favorites", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.watch_later -> {
                    Toast.makeText(this, "Watch later", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.selections -> {
                    Toast.makeText(this, "Collections", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        val buttonNight = findViewById<Button>(R.id.button_night_mode)
        buttonNight.setOnClickListener{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }



//        val buttonMenu = findViewById<Button>(R.id.button_menu)
//        val buttonFavs = findViewById<Button>(R.id.button_favs)
//        val buttonLater = findViewById<Button>(R.id.button_later)
//        val buttonCollections = findViewById<Button>(R.id.button_collections)
//        val buttonSettings = findViewById<Button>(R.id.button_settings)
//
//        buttonMenu.setOnClickListener {
//            Toast.makeText(this, "Main menu", Toast.LENGTH_SHORT).show()
//        }
//        buttonFavs.setOnClickListener {
//            Toast.makeText(this, "Add to favorites", Toast.LENGTH_SHORT).show()
//        }
//        buttonLater.setOnClickListener {
//            Toast.makeText(this, "Watch later", Toast.LENGTH_SHORT).show()
//        }
//        buttonCollections.setOnClickListener {
//            Toast.makeText(this, "Open your collections", Toast.LENGTH_SHORT).show()
//        }
//        buttonSettings.setOnClickListener {
//            Toast.makeText(this, "Open settings", Toast.LENGTH_SHORT).show()
//        }


    }
}

private operator fun Any.invoke(value: () -> Boolean) {

}
