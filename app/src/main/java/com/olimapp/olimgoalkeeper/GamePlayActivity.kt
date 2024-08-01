package com.olimapp.olimgoalkeeper

import android.media.Image
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlin.random.Random

class GamePlayActivity: AppCompatActivity(R.layout.game_play) {

    private lateinit var timer : CountDownTimer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val buttonBack = findViewById<ImageView>(R.id.button_back)
        buttonBack.setOnClickListener(){
            finish()
        }


        val bolaKiri = findViewById<ImageView>(R.id.ball_left)
        val bolaKanan = findViewById<ImageView>(R.id.ball_right)



        val kiperKiri = findViewById<ImageView>(R.id.kiper_left)
        val kiperKanan = findViewById<ImageView>(R.id.kiper_right)
        val kiperKiriAtas = findViewById<ImageView>(R.id.kiper_left_top)
        val kiperKananAtas = findViewById<ImageView>(R.id.kiper_right_top)
        val kiperKiriBawah = findViewById<ImageView>(R.id.kiper_left_bottom)
        val kiperKananBawah = findViewById<ImageView>(R.id.kiper_right_bottom)

        val golKiri = findViewById<ImageView>(R.id.ball_computer_left)
        val golKanan = findViewById<ImageView>(R.id.ball_computer_right)
        val golKiriAtas = findViewById<ImageView>(R.id.ball_computer_left_top)
        val golKananAtas = findViewById<ImageView>(R.id.ball_computer_right_top)
        val golKiriBawah = findViewById<ImageView>(R.id.ball_computer_left_bottom)
        val golKananBawah = findViewById<ImageView>(R.id.ball_computer_right_bottom)

        val textMenangKalah = findViewById<TextView>(R.id.text_win_loose)
        val textScore = findViewById<TextView>(R.id.text_score)
        var score = 0

        val duration = intent.getLongExtra("durasi",300_000)
        val time = findViewById<TextView>(R.id.text_time)
        timer = object : CountDownTimer(duration,1){
            override fun onTick(millisUntilFinished: Long) {
                val sec = millisUntilFinished / 1000
                time.text = sec.toString()
            }

            override fun onFinish() {
                time.text = "OUT!!!"
                AlertDialog.Builder(this@GamePlayActivity)
                    .setTitle("Congratulations!!!")
                    .setMessage("You got score at $score")
                    .setNeutralButton("Cancel") { dialog, which ->
                        // Respond to neutral button press
                    }
                    .setNegativeButton("Back") { dialog, which ->
                        // Respond to negative button press
                        finish()
                    }
                    .setPositiveButton("Again") { dialog, which ->
                        // Respond to positive button press
                        recreate()
                    }
                    .show()
            }

        }
        val buttonStart = findViewById<Button>(R.id.button_start)
        buttonStart.setOnClickListener(){
            timer.start()
            buttonStart.isVisible = false
        }

        val totalKiper = intent.getIntExtra("totalKiper",0)
        when (totalKiper){
            1 -> {
                bolaKiri.setOnClickListener(){
                    val random = Random.nextInt(2)
                    if (random == 0){
                        golKiri.isVisible = true
                        kiperKiri.isVisible = false
                        golKanan.isVisible = false
                        kiperKanan.isVisible = true
                        textMenangKalah.isVisible = true
                        textMenangKalah.text = "Menang"
                        score = score + 5
                    }else {
                        golKiri.isVisible = true
                        kiperKiri.isVisible = true
                        golKanan.isVisible = false
                        kiperKanan.isVisible = false
                        textMenangKalah.isVisible = true
                        textMenangKalah.text = "Kalah"
                        score = score - 5
                    }
                    textScore.text = score.toString()
                }

                bolaKanan.setOnClickListener(){
                    val random = Random.nextInt(2)
                    if (random == 0){
                        golKiri.isVisible = false
                        kiperKiri.isVisible = true
                        golKanan.isVisible = true
                        kiperKanan.isVisible = false
                        textMenangKalah.isVisible = true
                        textMenangKalah.text = "Menang"
                        score = score + 5
                    }else {
                        golKiri.isVisible = false
                        kiperKiri.isVisible = false
                        golKanan.isVisible = true
                        kiperKanan.isVisible = true
                        textMenangKalah.isVisible = true
                        textMenangKalah.text = "Kalah"
                        score = score - 5
                    }
                    textScore.text = score.toString()
                }
            }
            2 -> {
                bolaKiri.setOnClickListener(){
                    val random = Random.nextInt(4)
                    if (random == 0){
                        golKiri.isVisible = true
                        kiperKiri.isVisible = false
                        golKanan.isVisible = false
                        kiperKanan.isVisible = true


                        golKiriAtas.isVisible = false
                        kiperKiriAtas.isVisible = false
                        golKananAtas.isVisible = false
                        kiperKananAtas.isVisible = false

                        textMenangKalah.isVisible = true
                        textMenangKalah.text = "Menang"
                        score = score + 5
                    }else if (random == 1) {
                        golKiri.isVisible = true
                        kiperKiri.isVisible = true
                        golKanan.isVisible = false
                        kiperKanan.isVisible = false

                        golKiriAtas.isVisible = false
                        kiperKiriAtas.isVisible = false
                        golKananAtas.isVisible = false
                        kiperKananAtas.isVisible = false

                        textMenangKalah.isVisible = true
                        textMenangKalah.text = "Kalah"
                        score = score - 5
                    }else if (random == 2) {
                        golKiri.isVisible = false
                        kiperKiri.isVisible = false
                        golKanan.isVisible = false
                        kiperKanan.isVisible = false

                        golKiriAtas.isVisible = true
                        kiperKiriAtas.isVisible = false
                        golKananAtas.isVisible = false
                        kiperKananAtas.isVisible = true

                        textMenangKalah.isVisible = true
                        textMenangKalah.text = "Menang"
                        score = score - 5
                    }else if (random == 3) {
                        golKiri.isVisible = false
                        kiperKiri.isVisible = false
                        golKanan.isVisible = false
                        kiperKanan.isVisible = false

                        golKiriAtas.isVisible = false
                        kiperKiriAtas.isVisible = true
                        golKananAtas.isVisible = true
                        kiperKananAtas.isVisible = false

                        textMenangKalah.isVisible = true
                        textMenangKalah.text = "Kalah"
                        score = score - 5
                    }
                    textScore.text = score.toString()
                }

                bolaKanan.setOnClickListener(){
                    val random = Random.nextInt(2)
                    if (random == 0){
                        golKiri.isVisible = false
                        kiperKiri.isVisible = true
                        golKanan.isVisible = true
                        kiperKanan.isVisible = false
                        textMenangKalah.isVisible = true
                        textMenangKalah.text = "Menang"
                        score = score + 5
                    }else {
                        golKiri.isVisible = false
                        kiperKiri.isVisible = false
                        golKanan.isVisible = true
                        kiperKanan.isVisible = true
                        textMenangKalah.isVisible = true
                        textMenangKalah.text = "Kalah"
                        score = score - 5
                    }
                    textScore.text = score.toString()
                }
            }
            3 -> {
                bolaKiri.setOnClickListener(){
                    val random = Random.nextInt(2)
                    if (random == 0){
                        golKiri.isVisible = true
                        kiperKiri.isVisible = false
                        golKanan.isVisible = false
                        kiperKanan.isVisible = true
                        textMenangKalah.isVisible = true
                        textMenangKalah.text = "Menang"
                        score = score + 5
                    }else {
                        golKiri.isVisible = true
                        kiperKiri.isVisible = true
                        golKanan.isVisible = false
                        kiperKanan.isVisible = false
                        textMenangKalah.isVisible = true
                        textMenangKalah.text = "Kalah"
                        score = score - 5
                    }
                    textScore.text = score.toString()
                }

                bolaKanan.setOnClickListener(){
                    val random = Random.nextInt(2)
                    if (random == 0){
                        golKiri.isVisible = false
                        kiperKiri.isVisible = true
                        golKanan.isVisible = true
                        kiperKanan.isVisible = false
                        textMenangKalah.isVisible = true
                        textMenangKalah.text = "Menang"
                        score = score + 5
                    }else {
                        golKiri.isVisible = false
                        kiperKiri.isVisible = false
                        golKanan.isVisible = true
                        kiperKanan.isVisible = true
                        textMenangKalah.isVisible = true
                        textMenangKalah.text = "Kalah"
                        score = score - 5
                    }
                    textScore.text = score.toString()
                }
            }
        }
//        bolaKiri.setOnClickListener(){
//            val random = Random.nextInt(2)
//            if (random == 0){
//                golKiri.isVisible = true
//                kiperKiri.isVisible = false
//                golKanan.isVisible = false
//                kiperKanan.isVisible = true
//                textMenangKalah.isVisible = true
//                textMenangKalah.text = "Menang"
//                score = score + 5
//            }else {
//                golKiri.isVisible = true
//                kiperKiri.isVisible = true
//                golKanan.isVisible = false
//                kiperKanan.isVisible = false
//                textMenangKalah.isVisible = true
//                textMenangKalah.text = "Kalah"
//                score = score - 5
//            }
//            textScore.text = score.toString()
//        }
//
//        bolaKanan.setOnClickListener(){
//            val random = Random.nextInt(2)
//            if (random == 0){
//                golKiri.isVisible = false
//                kiperKiri.isVisible = true
//                golKanan.isVisible = true
//                kiperKanan.isVisible = false
//                textMenangKalah.isVisible = true
//                textMenangKalah.text = "Menang"
//                score = score + 5
//            }else {
//                golKiri.isVisible = false
//                kiperKiri.isVisible = false
//                golKanan.isVisible = true
//                kiperKanan.isVisible = true
//                textMenangKalah.isVisible = true
//                textMenangKalah.text = "Kalah"
//                score = score - 5
//            }
//            textScore.text = score.toString()
//        }
    }
//    override fun onStart() {
//        super.onStart()
//
//    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }
}