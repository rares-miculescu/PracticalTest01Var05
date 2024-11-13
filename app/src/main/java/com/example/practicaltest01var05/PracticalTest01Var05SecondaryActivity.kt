package com.example.practicaltest01var05

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var05SecondaryActivity : AppCompatActivity() {

    private lateinit var textMain: TextView
    private lateinit var verify: Button
    private lateinit var cancel: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)

        textMain = findViewById(R.id.textMain)
        cancel = findViewById(R.id.cancel)
        verify = findViewById(R.id.verify)

        textMain.text = intent.getStringExtra("textShow").toString()

        verify.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }

        cancel.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }

    }
}