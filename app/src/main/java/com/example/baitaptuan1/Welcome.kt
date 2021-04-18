package com.example.baitaptuan1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val tvSigninWelcome = findViewById<TextView>(R.id.tvSigninWelcome)
        val imgStartEmailPhone = findViewById<ImageView>(R.id.imgStartEmailPhone)
        val tvStartEmailPhone = findViewById<TextView>(R.id.tvStartEmailPhone)

        tvSigninWelcome.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
        imgStartEmailPhone.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
        tvStartEmailPhone.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

    }
}