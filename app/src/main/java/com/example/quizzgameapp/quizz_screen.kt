package com.example.quizzgameapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class QuestionActivity : AppCompatActivity() {

    // Flashcard questions and answers
    private val questions = arrayOf(
        "The American Civil War ended in 1865",
        "The Berlin Wall fell in 1989",
        "The French Revolution occurred before the American Revolution",
        "The Cold War ended in 1991",
        "The Roman Empire was located in what is now present-day Italy"
    )

    private val answers = arrayOf(true, false, false, true, false)

    private var index = 0
    private var score = 0

    private lateinit var questionText: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var feedbackText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_screen2)


        questionText = findViewById(R.id.txtQuestion)
        trueButton = findViewById(R.id.btnTrue)
        falseButton = findViewById(R.id.btnFalse)
        nextButton = findViewById(R.id.btnNext)
        feedbackText = findViewById(R.id.txtFeedback)

        loadQuestion()

        trueButton.setOnClickListener { checkAnswer(true) }
        falseButton.setOnClickListener { checkAnswer(false) }
        nextButton.setOnClickListener {
            index++
            if (index < questions.size) {
                loadQuestion()
            } else {
                // Go to score screen
                val intent = Intent(this, QuestionActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("questions", questions)
                intent.putExtra("answers", answers.toBooleanArray())
                startActivity(intent)
                finish()
            }
        }
    }

    private fun loadQuestion() {
        questionText.text = questions[index]
        feedbackText.text = ""
        trueButton.isEnabled = true
        falseButton.isEnabled = true
        nextButton.isEnabled = false
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = answers[index]
        if (userAnswer == correctAnswer) {
            feedbackText.text = "Correct!"
            score++
        } else {
            feedbackText.text = "Incorrect!"
        }

        // Disable answer buttons and enable next
        trueButton.isEnabled = false
        falseButton.isEnabled = false
        nextButton.isEnabled = true
    }
}