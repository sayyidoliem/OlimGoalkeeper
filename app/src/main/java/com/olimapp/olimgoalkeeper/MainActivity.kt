package com.olimapp.olimgoalkeeper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity(R.layout.menu) {
//    private lateinit var button: Button
    //bikin alert dialog
//    private lateinit var builder:AlertDialog.Builder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu)

        val button = findViewById<Button>(R.id.button_play)
//        builder = AlertDialog.Builder(this)
        button.setOnClickListener(){
            val intent = Intent(this, RuleActivity::class.java)
            startActivity(intent)
        }
    }

//    builder.setTitle("Alert")
//    .setMessage("Do YOu want ?")
//    .setCancelable(true)//dialog di cancel
//    //set positif button
//    //ambil dua parameter dialog interface
//    .setPositiveButton("Yes"){dialogInterface,it ->
//        val detailIntent = Intent(this@MainActivity, GamePlayActivity::class.java)
//        startActivity(detailIntent)
//    }
//    .setNegativeButton("No"){dialogInterface,it ->
//        dialogInterface.cancel()//dialog batal
//    }
//    .setNeutralButton("Help"){dialogInterface,it ->
//        Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show()
//    }
//    .show()//menampilkan builder
}