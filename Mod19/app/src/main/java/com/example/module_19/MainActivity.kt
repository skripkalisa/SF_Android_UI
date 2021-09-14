package com.example.module_19


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val root: ViewGroup = findViewById(R.id.main)

//        val view: View = layoutInflater.inflate(R.layout.item, root, false)
        val view: View = layoutInflater.inflate(R.layout.constrained, root, false)
//        val view: View = layoutInflater.inflate(R.layout.chained, root, false)
        root.addView(view)
//
//        val view1 = layoutInflater.inflate(R.layout.item, root, false)
//        view1.visibility = View.INVISIBLE
//        root.addView(view1)
//
//        val view2 = layoutInflater.inflate(R.layout.item, root, false)
//        view2.isEnabled = false
//        root.addView(view2)
//
//        val view3 = layoutInflater.inflate(R.layout.item, root, false)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            view3.setBackgroundColor(resources.getColor(R.color.teal_200, theme))
//        }
//        view3.setOnClickListener{}
//        root.addView(view3)


    }
}