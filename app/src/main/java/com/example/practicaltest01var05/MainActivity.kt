package com.example.practicaltest01var05

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var secondActivity: Button
    private lateinit var center: Button
    private lateinit var topLeft: Button
    private lateinit var topRight: Button
    private lateinit var bottomRight: Button
    private lateinit var bottomLeft: Button
    private lateinit var textShow: TextView
    private var count = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
        secondActivity = findViewById(R.id.secondActivity)
        center = findViewById(R.id.center)
        topLeft = findViewById(R.id.topLeft)
        topRight = findViewById(R.id.topRight)
        bottomRight = findViewById(R.id.bottomRight)
        bottomLeft = findViewById(R.id.bottomLeft)
        textShow = findViewById(R.id.textShow)

        topLeft.setOnClickListener {
            val text = textShow.text.toString()
            textShow.text = text + ", " + topLeft.text
            count += 1
        }

        topRight.setOnClickListener {
            val text = textShow.text.toString()
            textShow.text = text + ", " + topRight.text
            count++
        }

        center.setOnClickListener {
            val text = textShow.text.toString()
            textShow.text = text + ", " + center.text
            count++
        }

        bottomLeft.setOnClickListener {
            val text = textShow.text.toString()
            textShow.text = text + "," + bottomLeft.text
            count++
        }

        bottomRight.setOnClickListener {
            val text = textShow.text.toString()
            textShow.text = text + ", " + bottomRight.text
            count++
        }

        val activityResults = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if (result.resultCode == Activity.RESULT_OK){
                Toast.makeText(this, "The activity returned with result OK", Toast.LENGTH_LONG).show()
            } else if (result.resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "The activity returned CANCELED", Toast.LENGTH_LONG).show()
            }
            textShow.text = ""
            count = 0
        }

        secondActivity.setOnClickListener {
            val intent = Intent(this, PracticalTest01Var05SecondaryActivity::class.java)
            intent.putExtra("textShow", textShow.text.toString())
            activityResults.launch(intent)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("textShow", textShow.text.toString())
        outState.putString("count", count.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        if (savedInstanceState.containsKey("textShow")) {
            textShow.setText(savedInstanceState.getString("textShow"))
            count = savedInstanceState.getString("count").toString().toInt()
        }
        Toast.makeText(this, "count = ${count}", Toast.LENGTH_LONG).show()
    }

}