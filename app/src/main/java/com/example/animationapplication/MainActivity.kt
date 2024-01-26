package com.example.animationapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fb = findViewById<ImageView>(R.id.fb)
        val player = findViewById<ImageView>(R.id.pl)
        val goalbox = findViewById<ImageView>(R.id.goalbox)
        val msg = findViewById<TextView>(R.id.msg)

       fb.bringToFront()
        val an = AnimationUtils.loadAnimation(this,R.anim.football)
        val banim = AnimationUtils.loadAnimation(this,R.anim.ballrotate)
        val animationset = AnimationSet(false)
        animationset.addAnimation(banim)
        animationset.addAnimation(an)

        startbtn.setOnClickListener {


            val pan = AnimationUtils.loadAnimation(this,R.anim.player)
            player.startAnimation(pan)
            fb.startAnimation(animationset)




            an.setAnimationListener(object :Animation.AnimationListener {
                override fun onAnimationRepeat(p0: Animation?) {

                }

                override fun onAnimationStart(p0: Animation?) {

                }
                override fun onAnimationEnd(animation: Animation?) {
                    msg.isVisible = true
                }
            })
        }


    }
}
