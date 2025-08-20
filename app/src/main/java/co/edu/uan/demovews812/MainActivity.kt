package co.edu.uan.demovews812

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val numLeft = 10
    val numRight = 20

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
        }

        btnRight.setOnClickListener {
            if(numLeft <= numRight)
                Toast.makeText(this, "Ganaste :)", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, "Perdiste :(", Toast.LENGTH_LONG).show()
        }

    }
}