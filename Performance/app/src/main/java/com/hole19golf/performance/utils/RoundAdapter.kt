package com.hole19golf.performance.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hole19golf.performance.R
import com.hole19golf.performance.model.Round

class RoundAdapter(internal var context: Context, internal var roundsList:List<Round>)
    : RecyclerView.Adapter<RoundViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoundViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.rounds_layout, parent, false)
        return RoundViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return roundsList.size
    }

    override fun onBindViewHolder(holder: RoundViewHolder, position: Int) {
        holder.round_date.text = roundsList[position].started_at
        holder.course_name.text = roundsList[position].course_name
        holder.count_holes.text = roundsList[position].holes_played_count.toString()
        holder.score.text = roundsList[position].score.toString()
        holder.subscore.text = roundsList[position].sub_score.toString()
    }

}