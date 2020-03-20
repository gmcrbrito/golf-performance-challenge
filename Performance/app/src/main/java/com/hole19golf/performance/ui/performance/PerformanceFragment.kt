package com.hole19golf.performance.ui.performance

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.hole19golf.performance.R
import com.hole19golf.performance.RoundsActivity
import kotlinx.android.synthetic.main.fragment_performance.*
import kotlinx.android.synthetic.main.fragment_performance.view.*

class PerformanceFragment : Fragment(), PerformancePresenter.View {

    private lateinit var performancePresenter: PerformancePresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        performancePresenter = PerformancePresenter()
        performancePresenter.attachView(this)
        val view = inflater.inflate(R.layout.fragment_performance, container, false)

        // OnClick on the Rounds container
        view.container_rounds.setOnClickListener {
            performancePresenter.onRoundsClick()
        }
        return view
    }

    override fun goToRoundsList() {
        // Open the Rounds Activity and send the number of rounds with putExtra
        val intent = Intent(context, RoundsActivity::class.java)
        intent.putExtra("roundsNumber", getRoundsNumber())
        startActivity(intent)
    }


    override fun onStart() {
        super.onStart()
        performancePresenter.onStart()
    }

    private fun getRoundsNumber(): String {
        return tv_number_rounds.text.toString()
    }

    override fun setRoundsNumber(roundsNumber: String) {
        tv_number_rounds.text = roundsNumber
    }
}