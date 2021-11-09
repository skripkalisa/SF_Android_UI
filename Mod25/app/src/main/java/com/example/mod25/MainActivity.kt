package com.example.mod25

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, OneFragment())
            .addToBackStack(null)
            .commit()
    }
    fun startSecondFragment(imageButton: ImageView) {
        supportFragmentManager
            .beginTransaction()
            .addSharedElement(imageButton, "transition1")
            .addToBackStack(null)
            .replace(R.id.container, TwoFragment())
            .commit()
    }
}