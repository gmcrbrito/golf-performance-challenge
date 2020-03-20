package com.hole19golf.performance.utils

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rounds_layout.view.*

class RoundViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
{
    val round_date = itemView.tv_round_date
    val course_name = itemView.tv_course_name
    val count_holes = itemView.tv_number_holes
    val score = itemView.tv_score
    val subscore = itemView.tv_subscore
}