package com.example.baitaptuan1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_onboaring_three.*

class onboaring_three : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboaring_three)
        nextOn3.setOnClickListener{
            val intent = Intent(this, Welcome::class.java)
            startActivity(intent)
        }
    }
}