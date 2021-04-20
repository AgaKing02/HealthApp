package com.example.healthapp

import android.os.CountDownTimer
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class Exercise(
    millisInFuture: Long, countDownInterval: Long, var mProgressBar: ProgressBar,
    var textView: TextView, var image: ImageView, private var resource: Int?
) :
    CountDownTimer(millisInFuture, countDownInterval) {

    val interval: Int = ((100000 / millisInFuture).toInt());
    var nextExercise: Exercise? = null
    var overAll: Int = 100;


    override fun onTick(millisUntilFinished: Long) {
        overAll -= interval
        mProgressBar.progress = overAll
        textView.text = (millisUntilFinished / 1000).toString()
    }

    override fun onFinish() {
        nextExercise?.startWithImage()
    }

    fun startWithImage() {
        if(resource==null){
          image.setImageResource(R.drawable.main)
        }else{
           image.setImageResource(resource!!)
        }

        this.start()
    }
}