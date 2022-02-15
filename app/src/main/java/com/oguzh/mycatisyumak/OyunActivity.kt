package com.oguzh.mycatisyumak

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_oyun.*
import java.util.Random
class OyunActivity : AppCompatActivity() {
    var score = 0
    var imageArray = ArrayList<ImageView>()
    var handler = Handler()
    var runnable = Runnable {  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oyun)

        imageArray.add(imageView)
        imageArray.add(imageView2)
        imageArray.add(imageView3)
        imageArray.add(imageView4)
        imageArray.add(imageView5)
        imageArray.add(imageView6)
        imageArray.add(imageView7)
        imageArray.add(imageView8)
        imageArray.add(imageView9)
        imageArray.add(imageView10)
        imageArray.add(imageView11)
        imageArray.add(imageView12)
        yumakhareket()

        object : CountDownTimer(15500,1000){
            override fun onTick(p0: Long) {
                time.text="Time: " +p0/1000
            }

            override fun onFinish() {
                time.text="Time: 0"
                handler.removeCallbacks(runnable)
                for(image in imageArray){
                    image.visibility=View.INVISIBLE
                }
                val alert = AlertDialog.Builder(this@OyunActivity)
                alert.setTitle("Game Over")
                alert.setMessage("Score: $score\n" +
                        "Restart The Game?")
                alert.setPositiveButton("Yes"){dialog,which->
                    val intent = Intent(this@OyunActivity,MainActivity::class.java)
                    startActivity(intent)
                }
                alert.setNegativeButton("No"){dialog,which->
                    finish()
                }
                alert.show()
            }
        }.start()

    }
    fun basılı(view : View){
        score++
    }

    fun yumakhareket() {
        runnable = object : Runnable{
            override fun run() {
                for(image in imageArray){
                    image.visibility=View.INVISIBLE
                }
                val random = Random()
                val randomIndex = random.nextInt(12)
                imageArray[randomIndex].visibility=View.VISIBLE

                handler.postDelayed(runnable,500)
            }
        }
        handler.post(runnable)

    }




}