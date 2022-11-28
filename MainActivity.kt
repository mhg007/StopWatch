package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    val myTimer = Timer()
    lateinit var thread:Thread
    lateinit var textTime : TextView
    var flag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textTime = findViewById(R.id.timer)

        thread = Thread {
            while(true){
                if(flag){
                    textTime.post{
                        textTime.text = myTimer.getTime()
                    }
                    Thread.sleep(1000)
                }
            }
        }
        thread.start()
    }
    fun start(view: View){
        flag = true
    }
    fun stop(view:View){
        flag = false
    }
    fun reset(view:View){
        myTimer.reset()
        textTime.text = myTimer.getTime()
    }
}