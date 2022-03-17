package com.example.irlix_course4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.irlix_course4.databinding.ActivityMainBinding
import com.example.irlix_course4.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val button2 = binding.button2
        val button3 = binding.button3
        val button4 = binding.button4

        button2.setOnClickListener {
            setResult(1)
            finish()
        }

        button3.setOnClickListener {
            setResult(2)
            finish()
        }

        button4.setOnClickListener {
            setResult(3)
            finish()
        }




    }
}