package com.example.roshambill

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.content_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        setSupportActionBar(toolbar)

        val gameId = intent.getCharSequenceExtra("gameId")
        textView_gameId.text = gameId.toString()

        val randomNumberOfPlayers = (1..50).random()
        val randomServerNumber = (1..500).random()

        textView_number_of_players.text = randomNumberOfPlayers.toString()
        textView_server_number.text = randomServerNumber.toString()

        listDetails.layoutManager = LinearLayoutManager(this)

        listDetails.adapter = DetailsRecyclerAdapter(this, DataManager.turns)

        setTitle("Details")

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
