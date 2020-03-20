package com.hole19golf.performance.ui.ui.performance

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.hole19golf.performance.R
import com.hole19golf.performance.R.drawable
import com.hole19golf.performance.ui.ui.modelUI.StatisticsUI
import kotlinx.android.synthetic.main.view_statistics.view.*

class StatisticsView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.view_statistics, this, true)
    }

    fun setDrivingAccuracy(statisticsUI: StatisticsUI){
        // Driving accuracy setup
        containerImg.setBackgroundResource(drawable.circle_img_da)
        categoryImg.setImageDrawable(
            context?.let {
                ContextCompat.getDrawable(
                    it,
                    drawable.ic_driving_accuracy
                )
            }
        )
        percentageCategoryTv.text = statisticsUI.valueUi
        categoryNameTv.text = statisticsUI.categoryNameUi
        categoryDescripitonTv.text = statisticsUI.categoryDescriptionUi
    }

    fun setPutting(statisticsUI: StatisticsUI){
        // Driving accuracy setup
        containerImg.setBackgroundResource(drawable.circle_img_putting)
        categoryImg.setImageDrawable(
            context?.let {
                ContextCompat.getDrawable(
                    it,
                    drawable.ic_putting
                )
            }
        )
        percentageCategoryTv.text = statisticsUI.valueUi
        categoryNameTv.text = statisticsUI.categoryNameUi
        categoryDescripitonTv.text = statisticsUI.categoryDescriptionUi
    }

    fun setRecovery(statisticsUI: StatisticsUI){
        // Driving accuracy setup
        containerImg.setBackgroundResource(drawable.circle_img_recovery)
        categoryImg.setImageDrawable(
            context?.let {
                ContextCompat.getDrawable(
                    it,
                    drawable.ic_recovery
                )
            }
        )
        percentageCategoryTv.text = statisticsUI.valueUi
        categoryNameTv.text = statisticsUI.categoryNameUi
        categoryDescripitonTv.text = statisticsUI.categoryDescriptionUi
    }

    fun setGIR(statisticsUI: StatisticsUI){
        // Driving accuracy setup
        containerImg.setBackgroundResource(drawable.circle_img_gir)
        categoryImg.setImageDrawable(
            context?.let {
                ContextCompat.getDrawable(
                    it,
                    drawable.ic_gir
                )
            }
        )
        percentageCategoryTv.text = statisticsUI.valueUi
        categoryNameTv.text = statisticsUI.categoryNameUi
        categoryDescripitonTv.text = statisticsUI.categoryDescriptionUi
    }

    fun setScoresByPar(statisticsUI: StatisticsUI){
        // Driving accuracy setup
        containerImg.setBackgroundResource(drawable.circle_img_sbp)
        categoryImg.setImageDrawable(
            context?.let {
                ContextCompat.getDrawable(
                    it,
                    drawable.ic_scores_bp
                )
            }
        )
        percentageCategoryTv.text = statisticsUI.valueUi
        categoryNameTv.text = statisticsUI.categoryNameUi
        categoryDescripitonTv.text = statisticsUI.categoryDescriptionUi
    }

    fun setScoring(statisticsUI: StatisticsUI){
        // Driving accuracy setup
        containerImg.setBackgroundResource(drawable.circle_img_scoring)
        categoryImg.setImageDrawable(
            context?.let {
                ContextCompat.getDrawable(
                    it,
                    drawable.ic_scoring
                )
            }
        )
        percentageCategoryTv.text = statisticsUI.valueUi
        categoryNameTv.text = statisticsUI.categoryNameUi
        categoryDescripitonTv.text = statisticsUI.categoryDescriptionUi
    }
}