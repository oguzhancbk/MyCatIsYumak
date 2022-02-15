package com.oguzh.mycatisyumak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun start (view : View){

        val intent = Intent(this,OyunActivity::class.java)
        finish()
        startActivity(intent)
    }

    fun how(view : View){
        Toast.makeText(this,"Our cat named Yumak will appear on the screen and you will get points by tapping.\n" +
                "Your time is 15 seconds.\n" +
                "Good games.", Toast.LENGTH_LONG).show()
    }

    fun quit(view : View) {
        var alert = AlertDialog.Builder(this)
        alert.setMessage("Do you want to exit the game?")
        alert.setNegativeButton("No") { dialog, which ->

        }
        alert.setPositiveButton("Yes") { dialog, which ->
            finish()
        }
        alert.show()
    }



}