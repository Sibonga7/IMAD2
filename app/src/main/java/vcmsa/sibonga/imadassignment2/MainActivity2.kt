package vcmsa.sibonga.imadassignment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        //  Declare these at the class level so they can be accessed anywhere in this class
         val questions = arrayOf(
            "Nelson Mandela was the president in 1994",
            "The Berlin Wall fell in 1989",
            "The Roman Empire fell in 100 AD",
            "World War II ended in 1945",
            "The Great Wall of China is visible from space"
        )

         val answers = booleanArrayOf(true, true, false, true, false)
         var index = 0
         var score = 0

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // UI elements
        val questionText = findViewById<TextView>(R.id.questionText)
        val feedbackText = findViewById<TextView>(R.id.feedbackText)
        val trueBtn = findViewById<Button>(R.id.trueButton)
        val falseBtn = findViewById<Button>(R.id.falseButton)
        val nextBtn = findViewById<Button>(R.id.nextButton)

        // Show the first question
        questionText.text = questions[index]

        // Handle answer selection
        trueBtn.setOnClickListener {
            checkAnswer(true, feedbackText)
        }

        falseBtn.setOnClickListener {
            checkAnswer(false, feedbackText)
        }

        // Handle next button click
        nextBtn.setOnClickListener {
            index++
            if (index < questions.size) {
                questionText.text = questions[index]
                feedbackText.text = ""
            } else {
                // Move to score screen
                val intent = Intent(this, MainActivity3::class.java)
                intent.putExtra("score", score)
                startActivity(intent)
                finish()
            }
        }
    }

    //  This function now correctly accesses 'index', 'score', and 'answers'
    private fun checkAnswer(userAnswer: Boolean, feedbackText: TextView) {
        if (userAnswer == answers[index]) {
            score++
            feedbackText.text = "Correct!"
        } else {
            feedbackText.text = "Incorrect"
        }
        }
    }
