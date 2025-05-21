package com.example.quizzgameapp

import android.app.AlertDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ScoreScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)


        val score = intent.getIntExtra("score", 0)
        val questions = intent.getStringArrayExtra("questions") ?: arrayOf()
        val answers = intent.getBooleanArrayExtra("answers") ?: booleanArrayOf()

        val txtScore: TextView = findViewById(R.id.txtScore)
        val btnReview: Button = findViewById(R.id.btnReview)
        val btnExit: Button = findViewById(R.id.btnExit)

        txtScore.text = "Your score: $score / ${questions.size}"

        val feedback = if (score >= 3) "Great job!" else "Keep practising!"
        Toast.makeText(this, feedback, Toast.LENGTH_LONG).show()

        btnReview.setOnClickListener {
            val review = StringBuilder()
            for (i in questions.indices) {
                review.append("Q${i + 1}: ${questions[i]} - Answer: ${answers[i]}\n")
            }

            AlertDialog.Builder(this)
                .setTitle("Review Answers")
                .setMessage(review.toString())
                .setPositiveButton("OK", null)
                .show()
        }

        btnExit.setOnClickListener {
            finishAffinity() // Closes the app
        }
    }
}