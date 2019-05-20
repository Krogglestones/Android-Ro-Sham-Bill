package com.example.roshambill

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_players.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.content_players.*

class PlayersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_players)
        setSupportActionBar(toolbar)

        buttonPlayers.setOnClickListener {view ->
            val intent = Intent(this, PickNumberActivity::class.java)
            startActivity(intent)
        }

    }

}
