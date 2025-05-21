package com.example.quizzgameapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var startButton: Button? = null
    private var exitButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        startButton = findViewById(R.id.StartBtn)
        exitButton = findViewById(R.id.ExitBtn)

        val startButton = findViewById<Button>(R.id.StartBtn)
        val exitButton = findViewById<Button>(R.id.ExitBtn)

        startButton.setOnClickListener {
            startButton
        }

        exitButton.setOnClickListener {
            exitButton
        }

        fun exit () {
            finish()

        }
        fun start() {
            val intent = Intent(this,QuestionActivity ::class.java)
            startActivity(intent)
        }
    }

}
