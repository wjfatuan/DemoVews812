package co.edu.uan.demovews812

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var numLeft = 0
    var numRight = 0
    var score = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        initNumbers()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnLeft = findViewById<Button>(R.id.btnLeft)
        val btnRight = findViewById<Button>(R.id.btnRight)

        btnLeft.setOnClickListener {
            mostrarMensajes(numLeft, numRight)
            initNumbers()
        }

        btnRight.setOnClickListener {
            mostrarMensajes(numRight, numLeft)
            initNumbers()
        }

    }

    fun initNumbers() {
        numLeft = (0..100).random()
        numRight = (0..100).random()
    }

    fun mostrarMensajes(greater: Int, less:Int) {
        if(greater >= less) {
            Toast.makeText(this, "Ganaste :)", Toast.LENGTH_LONG).show()
            score += 3
        }
        else {
            Toast.makeText(this, "Perdiste :(", Toast.LENGTH_LONG).show()
            score -= 3
        }
        val textScore = findViewById<TextView>(R.id.txtScore)
        textScore.text = "Score: $score"

    }

}