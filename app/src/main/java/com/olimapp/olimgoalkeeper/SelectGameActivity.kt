package com.olimapp.olimgoalkeeper

import android.content.Intent
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SelectGameActivity : AppCompatActivity(R.layout.select_game) {
    override fun startActivity(intent: Intent?) {
        super.startActivity(intent)

        val buttonGoalKeeper = findViewById<Button>(R.id.button_goalkeeper)
        val buttonBack = findViewById<ImageView>(R.id.button_back)

        buttonGoalKeeper.setOnClickListener(){
            val intent = Intent(this, GamePlayActivity::class.java)
            startActivity(intent)
        }

        buttonBack.setOnClickListener(){
            finish()
        }
    }
}