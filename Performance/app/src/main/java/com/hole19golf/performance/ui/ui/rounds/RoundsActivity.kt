package com.hole19golf.performance.ui.ui.rounds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import com.hole19golf.performance.R
import com.hole19golf.performance.data.data.model.Round
import com.hole19golf.performance.ui.ui.utils.RoundAdapter
import kotlinx.android.synthetic.main.activity_rounds.*

class RoundsActivity : AppCompatActivity(),
    RoundsPresenter.View {

    private lateinit var roundsPresenter: RoundsPresenter
    private lateinit var rounds_adapter : RoundAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rounds)
        roundsPresenter =
            RoundsPresenter()
        roundsPresenter.onViewAttached(this)
        setActionBarTitle()
        inicializeRecyclerView()
        roundsPresenter.onCreate()

    }

    fun setActionBarTitle(){
        val strRoundsNumber: Int = 0
        // Set up ActionBar
        val actionBar = supportActionBar
        // Set ActionBar's Title
        actionBar!!.title = "$strRoundsNumber Rounds"
        // Set the back button on the ActionBar
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    override fun inicializeRecyclerView(){
        // Inicialize view
        roundsRv.setHasFixedSize(true)
        roundsRv.layoutManager = LinearLayoutManager(this)
        rounds_adapter = RoundAdapter()
        roundsRv.adapter = rounds_adapter
    }

    override fun displayRounds(rounds: List<Round>) {

        val roundsProgressBar: ProgressBar = this.progressBar2
        // Visibility
        roundsProgressBar.visibility = View.GONE
        roundsRv.visibility = View.VISIBLE
        rounds_adapter.setItems(rounds.toMutableList())
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
