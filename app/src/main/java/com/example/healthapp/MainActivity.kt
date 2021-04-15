package com.example.healthapp

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.time.Duration


class MainActivity : AppCompatActivity() {
    var mProgressBar: ProgressBar? = null
    var mCountDownTimer: CountDownTimer? = null
    var startButton:Button?=null
    var textView: TextView? = null
    var i = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUp()


        mCountDownTimer = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                Log.v("Log_tag", "Tick of Progress$i$millisUntilFinished")
                i -= 10
                mProgressBar!!.progress = i
                textView!!.text = (i / 10).toString();
            }

            override fun onFinish() {
                startButton!!.text = "Finished"
                i=100
            }
        }
        startButton!!.setOnClickListener{
            mCountDownTimer!!.start()
        }
    }

    fun setUp() {
        textView = findViewById(R.id.text_view_progress)
        startButton=findViewById(R.id.button)
        mProgressBar = findViewById(R.id.progress_bar)
        mProgressBar!!.setProgress(i)
        textView!!.text= (i/10).toString();
    }
}