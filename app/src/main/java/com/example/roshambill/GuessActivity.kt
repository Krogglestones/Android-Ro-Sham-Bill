package com.example.roshambill

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_guess.*
import kotlinx.android.synthetic.main.content_guess.*
import kotlinx.android.synthetic.main.content_players.*

class GuessActivity : AppCompatActivity() {

    val numberOfPlayers by lazy { intent.getIntExtra("NumberOfPlayers2", 2) }
    val serverNumber by lazy { intent.getIntExtra("ServerNumber", 244) }
    var currentPlayer = 1


    private val viewModel by lazy {ViewModelProviders.of(this)[GuessActivityViewModel::class.java]}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess)
        setSupportActionBar(toolbar)

        startGame()

        buttonGuess.setOnClickListener {
            handleGuess()

        }

        val vm = viewModel

        setTitle("Guess")

    }

    private fun startGame() {
//        Toast.makeText(this, numberOfPlayers.toString(), Toast.LENGTH_LONG).show()
//        Toast.makeText(this, serverNumber.toString(), Toast.LENGTH_LONG).show()
        var lowNumber = 1
        var highNumber = 500
        textView_PlayerNumber.setText(currentPlayer.toString())
        textView_LowNumber.setText(lowNumber.toString())
        textView_HighNumber.setText(highNumber.toString())
    }

    private fun handleGuess() {
        var lowNumber = 1
        var highNumber = 500
        var theGuess = findViewById<EditText>(R.id.editText_playerGuess)
        var guessAsInt = theGuess.text.toString().toInt()

        if (guessAsInt == serverNumber) {
            val intent = Intent(this, WinnerActivity::class.java)
            startActivity(intent)
        }

        if (guessAsInt > 500 || guessAsInt < 1) {
            Toast.makeText(this, "You picked out of range.", Toast.LENGTH_LONG).show()
            return
        }

        if (serverNumber < guessAsInt) {
            Toast.makeText(this, "LOWER", Toast.LENGTH_LONG).show()
            highNumber = guessAsInt
            textView_HighNumber.setText(highNumber.toString())
            currentPlayer++
            textView_PlayerNumber.setText(currentPlayer.toString())
        }

        if (serverNumber > guessAsInt) {
            Toast.makeText(this, "HIGHER", Toast.LENGTH_LONG).show()
            lowNumber = guessAsInt
            textView_LowNumber.setText(lowNumber.toString())
            currentPlayer++
            textView_PlayerNumber.setText(currentPlayer.toString())
        }
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            R.id.action_home -> {
                goHome()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun goHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}
