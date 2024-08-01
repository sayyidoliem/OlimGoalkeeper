package com.olimapp.olimgoalkeeper

import android.content.ClipData
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class RuleActivity : AppCompatActivity(R.layout.rule_goalkeeper) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val radioGroup = findViewById<RadioGroup>(R.id.button_radio_group)
        val easy = findViewById<Button>(R.id.button_easy)
        val medium = findViewById<Button>(R.id.button_medium)
        val hard = findViewById<Button>(R.id.button_hard)
//        val play = findViewById<Button>(R.id.button_play)
//        val tingkat = listOf<ItemOrder>(easy, medium, hard)


        easy.setOnClickListener(){
            val durasi = 160_000L
            val totalKiper = 1
            val intent = Intent(this, GamePlayActivity::class.java)
            intent.putExtra("durasi",durasi)
            intent.putExtra("totalKiper",totalKiper)
            startActivity(intent)
        }

        medium.setOnClickListener(){
            val durasi = 90_000L
            val totalKiper = 2
            val intent = Intent(this, GamePlayActivity::class.java)
            intent.putExtra("durasi",durasi)
            intent.putExtra("totalKiper",totalKiper)
            startActivity(intent)
        }

        hard.setOnClickListener(){
            val durasi = 30_000L
            val totalKiper = 3
            val intent = Intent(this, GamePlayActivity::class.java)
            intent.putExtra("durasi",durasi)
            intent.putExtra("totalKiper",totalKiper)
            startActivity(intent)
        }

        val buttonBack = findViewById<ImageView>(R.id.button_back)

        buttonBack.setOnClickListener(){
            finish()
        }
    }
}