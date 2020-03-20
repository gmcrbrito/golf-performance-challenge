package com.hole19golf.performance.ui.ui.utils

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.hole19golf.performance.R
import com.hole19golf.performance.data.data.model.Round
import com.hole19golf.performance.ui.ui.modelUI.DateFormatterUI
import com.hole19golf.performance.ui.ui.modelUI.DateFormatterUI.dateFormatter
import com.hole19golf.performance.ui.ui.modelUI.DateFormatterUI.offsetDateFormat
import kotlinx.android.synthetic.main.rounds_header.view.*
import kotlinx.android.synthetic.main.rounds_layout.view.*
import java.time.format.DateTimeFormatter


@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class RoundAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var roundsList: MutableList<Round> = mutableListOf()

    fun setItems(newList: MutableList<Round>) {
        roundsList.addAll(newList)
        notifyDataSetChanged()
    }

    class RoundViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val roundDate = itemView.roundDateTv
        val courseName = itemView.courseNameTv
        val countHoles = itemView.holesNumberTv
        val score = itemView.scoreTv
        val subScore = itemView.subScoreTv
    }

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateRounds = itemView.headerDateTv
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            Constant.TYPE_ROUND -> {
                val view: View =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.rounds_layout, parent, false)
                return RoundViewHolder(view)
            }
            Constant.TYPE_DATE -> {
                val view: View =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.rounds_header, parent, false)
                return DataViewHolder(view)
            }
            else -> {
                val view: View =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.rounds_header, parent, false)
                return DataViewHolder(view)}
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position % 2 * 2
    }

    override fun getItemCount(): Int {
        return roundsList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return when (holder.itemViewType) {
            Constant.TYPE_ROUND -> {
                val roundViewHolder: RoundViewHolder = holder as RoundViewHolder
                roundViewHolder.roundDate.text = roundsList[position].startedAt.take(10)
                holder.courseName.text = roundsList[position].courseName
                holder.countHoles.text = roundsList[position].holesPlayedCount.toString() + " HOLES"
                holder.score.text = roundsList[position].score.toString()
                holder.subScore.text = roundsList[position].subScore.toString()
            }
            Constant.TYPE_DATE -> {
                val dataViewHolder: DataViewHolder = holder as DataViewHolder
                roundsList[position].finalDate = offsetDateFormat.format(dateFormatter.parse(roundsList[position].startedAt))
                dataViewHolder.dateRounds.text = roundsList[position].finalDate
            }
            else -> {}
        }
    }

}