package com.hole19golf.performance.ui.ui.performance

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.hole19golf.performance.R
import com.hole19golf.performance.ui.ui.modelUI.CategoryId
import com.hole19golf.performance.ui.ui.modelUI.StatisticsUI
import com.hole19golf.performance.ui.ui.rounds.RoundsActivity
import kotlinx.android.synthetic.main.fragment_performance.*
import kotlinx.android.synthetic.main.fragment_performance.view.*


@Suppress("PLUGIN_WARNING")
class PerformanceFragment : Fragment(),
    PerformancePresenter.View {

    private lateinit var performancePresenter: PerformancePresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        performancePresenter =
            PerformancePresenter()
        performancePresenter.attachView(this)
        val view = inflater.inflate(R.layout.fragment_performance, container, false)

        // OnClick on the Rounds container
        view.containerRounds.setOnClickListener {
            performancePresenter.onRoundsClick()
        }
        return view
    }

    override fun onStart() {
        super.onStart()
        performancePresenter.onStart()
    }

    override fun goToRoundsList() {
        // Open the Rounds Activity and send the number of rounds with putExtra
        val intent = Intent(context, RoundsActivity::class.java)
        intent.putExtra("roundsNumber", getRoundsNumber())
        startActivity(intent)
    }

    private fun getRoundsNumber(): String {
        return roundsNumberTv.text.toString()
    }

    override fun displayStatistics(statisticsUI: StatisticsUI) {

        val statisticsProgressBar: ProgressBar = this.progressBar1
        val containerOverallStatistics: LinearLayout = this.containerOverallStatistics

        // Visibility
        statisticsProgressBar.visibility = View.GONE
        containerOverallStatistics.visibility = View.VISIBLE

        when(statisticsUI.categoryIdUI){
            CategoryId.DRIVING_ACCURACY -> customStatistics1.setDrivingAccuracy(statisticsUI)
            CategoryId.PUTTING -> customStatistics3.setPutting(statisticsUI)
            CategoryId.RECOVERY -> customStatistics5.setRecovery(statisticsUI)
            CategoryId.GIR -> customStatistics2.setGIR(statisticsUI)
            CategoryId.SCORES_BY_PAR -> customStatistics4.setScoresByPar(statisticsUI)
            CategoryId.SCORING -> customStatistics6.setScoring(statisticsUI)
        }
    }
}