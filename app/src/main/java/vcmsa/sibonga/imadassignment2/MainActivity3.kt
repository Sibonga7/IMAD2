package vcmsa.sibonga.imadassignment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val score = intent.getIntExtra("score", 0)
        val scoreText = findViewById<TextView>(R.id.scoreText)
        val feedbackText = findViewById<TextView>(R.id.feedbackText)

        scoreText.text = "You scored $score out of 5"
        feedbackText.text = if (score >= 3) "Great job!" else "Keep practising!"

        findViewById<Button>(R.id.button5).setOnClickListener {
            startActivity(Intent(this, MainActivity3::class.java))
        }

        findViewById<Button>(R.id.button5).setOnClickListener {
            finishAffinity() // Closes all activities
        }

    }
}