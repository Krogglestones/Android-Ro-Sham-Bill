package com.example.roshambill

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
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
            if (convertedToInt2 > 0 && convertedToInt2 <= 500) {
                val intent = Intent(this, GuessActivity::class.java)
                intent.putExtra("ServerNumber", convertedToInt2)
                intent.putExtra("NumberOfPlayers2", noOfPlayers)
                startActivity(intent)
            }
            if (convertedToInt2 < 1 || convertedToInt2 > 500) {
                Toast.makeText(this, "PICK A NUMBER BETWEEN 1 AND 500", Toast.LENGTH_LONG).show()

            }
        }

        setTitle("Server Number")

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
