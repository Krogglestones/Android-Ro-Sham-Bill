package com.example.roshambill

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_pick_number.*
import kotlinx.android.synthetic.main.content_pick_number.*
import kotlinx.android.synthetic.main.content_players.*

class PickNumberActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_number)
        setSupportActionBar(toolbar)

        buttonPickNumber.setOnClickListener {view ->
            val intent = Intent(this, GuessActivity::class.java)
            startActivity(intent)
        }

    }

}
