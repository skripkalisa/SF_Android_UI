package com.example.mod20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
//import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val text = findViewById<TextView>(R.id.textView2)
//        text.text = "New text here!"
//        textView2.text = "More text"

//
//        val root: ViewGroup = findViewById(R.id.main)

//        val view = layoutInflater.inflate(R.layout.unit1, root, false)
//        root.addView(view)
        val buttonToast = findViewById<Button>(R.id.btn_main)

        buttonToast.setOnClickListener {
            Toast.makeText(this, "Popup message",Toast.LENGTH_SHORT).show()
        }

    }

//    fun onClickToast(view: View) {
//        Toast.makeText(this, "Popup message", Toast.LENGTH_SHORT).show()
//
//    }

}