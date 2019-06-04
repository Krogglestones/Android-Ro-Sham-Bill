package com.example.roshambill

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.text.FieldPosition

class DetailsRecyclerAdapter(private val context: Context, private val turns: List<TurnInfo>) :
    RecyclerView.Adapter<DetailsRecyclerAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.item_details_list, parent, false )
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return turns.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val turn = turns[position]
        holder.textPlayerNumber?.text = turn.playerNumber.toString()
        holder.textNumberGuessed?.text = turn.numberPicked.toString()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textPlayerNumber = itemView?.findViewById<TextView?>(R.id.textView_player_number)
        val textNumberGuessed = itemView?.findViewById<TextView?>(R.id.textView_player_guess)
    }
}