package com.example.roshambill

import android.content.Intent
import android.os.Bundle
import android.support.annotation.IntegerRes
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_players.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.content_players.*

class PlayersActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_players)
        setSupportActionBar(toolbar)

        var editTextNumberOfPlayers = findViewById<EditText>(R.id.editText_numberOfPlayers)
        var buttonNext = findViewById<Button>(R.id.buttonPlayers)

        editTextNumberOfPlayers.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if (editTextNumberOfPlayers.toString() != null)
                buttonNext.setOnClickListener {
                    passNumberOfPlayers()
                }

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                buttonNext.isEnabled == false
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                buttonNext.isEnabled == true

            }

        })

        setTitle("Players")

    }



    private fun passNumberOfPlayers() {

        val numberOfPlayers = findViewById(R.id.editText_numberOfPlayers) as EditText
        val convertedToInt = numberOfPlayers.text.toString().toInt()
        if (convertedToInt > 1 && convertedToInt <= 50) {
            val intent = Intent(this, PickNumberActivity::class.java)
            intent.putExtra("NumberOfPlayers", convertedToInt)
            startActivity(intent)

        }

        if (convertedToInt < 2 || convertedToInt > 50) {
            Toast.makeText(this, "ENTER A NUMBER BETWEEN 2 AND 50", Toast.LENGTH_LONG).show()
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
