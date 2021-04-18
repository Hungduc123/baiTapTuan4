package com.example.baitaptuan1

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Onboarding_one : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_one)

        val imgNextOnboaringOne=findViewById<ImageView>(R.id.imgNextOnboaringOne);
        imgNextOnboaringOne.setOnClickListener{
            val intent = Intent(this, onboaring_two::class.java)
            startActivity(intent)
        }



    }
}