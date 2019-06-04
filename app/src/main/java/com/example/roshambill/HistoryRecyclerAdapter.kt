package com.example.roshambill

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class HistoryRecyclerAdapter(private val context : Context, private val games: List<GameInfo>) :
    RecyclerView.Adapter<HistoryRecyclerAdapter.ViewHolder>()  {



    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemView = layoutInflater.inflate(R.layout.item_game_list, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return games.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var game = games[position]
        holder.textGameId?.text = game.gameId.toString()

        var numberOfPlayers = DataManager.numberOfPlayers[position]


    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textGameId = itemView?.findViewById<TextView?>(R.id.textGameId)
//        val textNumOfPlayers = itemView?.findViewById<TextView?>(R.id.)
//        var num = DataManager.numberOfPlayers

        init {
            itemView?.setOnClickListener {
                val intent = Intent(context, DetailsActivity::class.java)
                intent.putExtra("gameId", textGameId?.text.toString().toInt())
//                intent.putExtra("numOfPlayers", num)
                context.startActivity(intent)
            }
        }

    }
}
