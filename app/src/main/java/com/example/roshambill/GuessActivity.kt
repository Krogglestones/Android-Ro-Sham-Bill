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
import com.example.roshambill.DataManager.currentPlayer
import com.example.roshambill.DataManager.numberOfPlayers

import kotlinx.android.synthetic.main.activity_guess.*
import kotlinx.android.synthetic.main.content_guess.*
import kotlinx.android.synthetic.main.content_players.*
import java.util.function.IntConsumer

class GuessActivity : AppCompatActivity() {

    val numberOfPlayers by lazy { intent.getIntExtra("NumberOfPlayers2", 2) }
    val serverNumber by lazy { intent.getIntExtra("ServerNumber", 244) }
    //    var currentPlayer = 1
    val guesses = ArrayList<Int>()
    var gameNumber = DataManager.gameNumber
//    var num = numberOfPlayers

    private val viewModel by lazy { ViewModelProviders.of(this)[GuessActivityViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess)
        setSupportActionBar(toolbar)

        buttonGuess.setOnClickListener {

            handleGuess()
        }

        val vm = viewModel


        startGame()

        setTitle("Guess")

    }

    private fun startGame() {
//        Toast.makeText(this, numberOfPlayers.toString(), Toast.LENGTH_LONG).show()
//        Toast.makeText(this, serverNumber.toString(), Toast.LENGTH_LONG).show()
        var lowNumber = DataManager.lowNum
        var highNumber = DataManager.highNum
        var currentPlayer = currentPlayer
        textView_PlayerNumber.setText(currentPlayer.toString())
        textView_LowNumber.setText(lowNumber.toString())
        textView_HighNumber.setText(highNumber.toString())
    }

    private fun handleGuess() {
        var lowNumber = DataManager.lowNum
        var highNumber = DataManager.highNum
        var theGuess = findViewById<EditText>(R.id.editText_playerGuess)
        var guessAsInt = theGuess.text.toString().toInt()

        if (guessAsInt == serverNumber) {
            saveGuesses()
            val intent = Intent(this, WinnerActivity::class.java)
            startActivity(intent)
            saveNumberOfPlayers()
            createNewHistory()
            saveServerNumber()
            DataManager.gameNumber++
            DataManager.currentPlayer = 1
            DataManager.lowNum = 1
            DataManager.highNum = 500
        }

        if (guessAsInt > highNumber || guessAsInt < lowNumber) {
            Toast.makeText(this, "You picked out of range.", Toast.LENGTH_LONG).show()
            theGuess.getText().clear()
            return
        }




        if (serverNumber < guessAsInt) {
            Toast.makeText(this, "LOWER", Toast.LENGTH_SHORT).show()
            theGuess.getText().clear()
            highNumber = guessAsInt
            DataManager.highNum = guessAsInt
            textView_HighNumber.setText(highNumber.toString())

//            Toast.makeText(this, "${highNumber}", Toast.LENGTH_LONG).show()
            DataManager.turns.add(TurnInfo(currentPlayer, guessAsInt))


            if (currentPlayer <= numberOfPlayers) {
                DataManager.currentPlayer++
            }
            if (currentPlayer == numberOfPlayers + 1) {
                currentPlayer = 1
            }

            guesses += guessAsInt
            Toast.makeText(this, "$guesses", Toast.LENGTH_SHORT).show()

            textView_PlayerNumber.setText(DataManager.currentPlayer.toString())
            return
        }




        if (serverNumber > guessAsInt) {
            Toast.makeText(this, "HIGHER", Toast.LENGTH_SHORT).show()
            theGuess.getText().clear()
            lowNumber = guessAsInt
            DataManager.lowNum = guessAsInt

            DataManager.turns.add(TurnInfo(currentPlayer, guessAsInt))

            if (currentPlayer <= numberOfPlayers) {
                DataManager.currentPlayer++
            }

            if (currentPlayer == numberOfPlayers + 1) {
                currentPlayer = 1
            }



            textView_LowNumber.setText(lowNumber.toString())

//            DataManager.currentPlayer++
            guesses += guessAsInt
            Toast.makeText(this, "$guesses", Toast.LENGTH_SHORT).show()

            textView_PlayerNumber.setText(currentPlayer.toString())
            return
        }


    }



    private fun createNewHistory() {
        DataManager.games.add(GameInfo(gameNumber, numberOfPlayers, serverNumber))
    }

    private fun saveGuesses() {
        DataManager.guesses.add(Guesses(guesses))
    }

    private fun saveNumberOfPlayers() {
        DataManager.numberOfPlayers = numberOfPlayers
    }

    private fun saveServerNumber() {
        DataManager.serverNumber = serverNumber
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
