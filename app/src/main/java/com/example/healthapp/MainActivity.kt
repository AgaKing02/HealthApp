package com.example.healthapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    var mProgressBar: ProgressBar? = null
    var textView: TextView? = null
    var image: ImageView? = null
    var i = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUp()


        val first = mProgressBar?.let {
            textView?.let { it1 ->
                image?.let { it2 ->
                    Exercise(
                        30000, 1000, it, it1,
                        it2,R.drawable.ic_push_up
                    )
                }
            }
        }


        val firstRest = mProgressBar?.let {
            textView?.let { it1 ->
                image?.let { it2 ->
                    Exercise(
                        10000, 1000, it, it1,
                        it2,null
                    )
                }
            }
        }
        val second = mProgressBar?.let {
            textView?.let { it1 ->
                image?.let { it2 ->
                    Exercise(
                        30000, 1000, it, it1,
                        it2,R.drawable.ic_jumping_jacks
                    )
                }
            }
        }


        val secondRest = mProgressBar?.let {
            textView?.let { it1 ->
                image?.let { it2 ->
                    Exercise(
                        10000, 1000, it, it1,
                        it2,null
                    )
                }
            }
        }

        val third = mProgressBar?.let {
            textView?.let { it1 ->
                image?.let { it2 ->
                    Exercise(
                        30000, 1000, it, it1,
                        it2,R.drawable.ic_abdominal_crunch
                    )
                }
            }
        }

        setUpActivities(Arrays.asList(first, firstRest, second, secondRest, third))
        first!!.startWithImage()


    }


    fun setUpActivities(activities: List<Exercise?>) {
        var count = 0;
        while (count != activities.size - 1) {
            activities.get(count)!!.nextExercise = activities.get(count + 1)
            count++;
        }
    }

    fun setUp() {
        textView = findViewById(R.id.text_view_progress)
        mProgressBar = findViewById(R.id.progress_bar)
        image = findViewById(R.id.picture)
        mProgressBar!!.setProgress(i)
        textView!!.text = (i / 10).toString();
    }
}