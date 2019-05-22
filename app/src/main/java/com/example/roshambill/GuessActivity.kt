package com.example.roshambill

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_guess.*
import kotlinx.android.synthetic.main.content_guess.*
import kotlinx.android.synthetic.main.content_players.*

class GuessActivity : AppCompatActivity() {

    val numberOfPlayers by lazy { intent.getIntExtra("NumberOfPlayers2", 2) }
    val serverNumber by lazy { intent.getIntExtra("ServerNumber", 244) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess)
        setSupportActionBar(toolbar)

        startGame()

        buttonGuess.setOnClickListener {
            handleGuess()

        }

    }

    private fun startGame() {
        Toast.makeText(this, numberOfPlayers.toString(), Toast.LENGTH_LONG).show()
        Toast.makeText(this, serverNumber.toString(), Toast.LENGTH_LONG).show()
        var lowNumber = 1
        var highNumber = 500
        var currentPlayer = 1
        textView_PlayerNumber.setText(currentPlayer.toString())
        textView_LowNumber.setText(lowNumber.toString())
        textView_HighNumber.setText(highNumber.toString())
    }

    private fun handleGuess() {
        var lowNumber = 1
        var highNumber = 500
        var currentPlayer  = 1
        var theGuess = findViewById<EditText>(R.id.editText_playerGuess)
        var guessAsInt = theGuess.text.toString().toInt()

        if (guessAsInt == serverNumber) {
            Toast.makeText(this, "WINNER!!!", Toast.LENGTH_LONG).show()
        }

        if (guessAsInt > 500 || guessAsInt < 1) {
            Toast.makeText(this, "You picked out of range.", Toast.LENGTH_LONG).show()
            return
        }

        if (serverNumber < guessAsInt) {
            Toast.makeText(this, "LOWER", Toast.LENGTH_LONG).show()
            highNumber = guessAsInt
            textView_HighNumber.setText(highNumber.toString())
//            currentPlayer++
//            textView_PlayerNumber.setText(currentPlayer.toString())
        }

        if (serverNumber > guessAsInt) {
            Toast.makeText(this, "HIGHER", Toast.LENGTH_LONG).show()
            lowNumber = guessAsInt
            textView_LowNumber.setText(lowNumber.toString())
//            currentPlayer++
//            textView_PlayerNumber.setText(currentPlayer.toString())
        }
    }



}
