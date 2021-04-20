package com.example.healthapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class StartActivity: AppCompatActivity() {
    //comment
    var startButton: Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_activity)

        startButton=findViewById(R.id.start_button)

        startButton!!.setOnClickListener{
            val i = Intent(this@StartActivity, MainActivity::class.java)
            startActivity(i)
        }

    }

}