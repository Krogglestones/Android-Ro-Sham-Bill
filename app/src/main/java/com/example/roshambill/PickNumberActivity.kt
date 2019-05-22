package com.example.roshambill

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_pick_number.*
import kotlinx.android.synthetic.main.content_pick_number.*
import kotlinx.android.synthetic.main.content_players.*
import java.lang.Exception
import kotlin.math.absoluteValue

class PickNumberActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_number)
        setSupportActionBar(toolbar)

        val noOfPlayers: Int = intent.getIntExtra("NumberOfPlayers", 2)


        buttonPickNumber.setOnClickListener { view ->
            val serverNumber = findViewById(R.id.editText_serverNumber) as EditText
            val convertedToInt2 = serverNumber.text.toString().toInt()
            val intent = Intent(this, GuessActivity::class.java)
            intent.putExtra("ServerNumber", convertedToInt2)
            intent.putExtra("NumberOfPlayers2", noOfPlayers)
            startActivity(intent)

        }

    }
}
