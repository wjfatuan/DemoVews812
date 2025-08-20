package co.edu.uan.demovews812

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var numLeft = (0..100).random()
    var numRight = (0..100).random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnLeft = findViewById<Button>(R.id.btnLeft)
        val btnRight = findViewById<Button>(R.id.btnRight)

        btnLeft.setOnClickListener {
            if(numLeft >= numRight)
                Toast.makeText(this, "Ganaste :)", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, "Perdiste :(", Toast.LENGTH_LONG).show()
            numLeft = (0..100).random()
            numRight = (0..100).random()
        }

        btnRight.setOnClickListener {
            if(numLeft <= numRight)
                Toast.makeText(this, "Ganaste :)", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, "Perdiste :(", Toast.LENGTH_LONG).show()
            numLeft = (0..100).random()
            numRight = (0..100).random()
        }

    }
}