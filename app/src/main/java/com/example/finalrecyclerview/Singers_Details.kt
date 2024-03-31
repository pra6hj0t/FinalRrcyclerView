package com.example.finalrecyclerview

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import de.hdodenhof.circleimageview.CircleImageView

class Singers_Details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        setContentView(R.layout.activity_singers_details)

        val name = findViewById<TextView>(R.id.name_details)
        val image = findViewById<CircleImageView>(R.id.singer_image_details)
        val about = findViewById<TextView>(R.id.singer_about_details)

        val getname = intent.getStringExtra("name")
        val getimage = intent.getIntExtra("image",R.drawable.sidhu1)
        val getabout = intent.getStringExtra("about")

        name.text = getname
        image.setImageResource(getimage)
        about.text = getabout

    }
}