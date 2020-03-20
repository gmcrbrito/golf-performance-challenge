package com.hole19golf.performance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hole19golf.performance.api.RoundsService
import com.hole19golf.performance.api.ServiceBuilder
import com.hole19golf.performance.model.Round
import com.hole19golf.performance.utils.RoundAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_rounds.*

class RoundsActivity : AppCompatActivity() {

    internal lateinit var jsonApi: RoundsService
    var compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rounds)

        // Get String for the previous activity
        val strRoundsNumber: String? = intent.getStringExtra("roundsNumber")
        // Set up ActionBar
        val actionBar = supportActionBar
        // Set ActionBar's Title
        actionBar!!.title = "$strRoundsNumber Rounds"
        // Set the back button on the ActionBar
        actionBar.setDisplayHomeAsUpEnabled(true)

        // Inicialize API
        val retrofit = ServiceBuilder.instance
        jsonApi = retrofit.create(RoundsService::class.java)

        // Inicialize view
        rv_rounds.setHasFixedSize(true)
        rv_rounds.layoutManager = LinearLayoutManager(this)
        fetchData()
    }

    private fun fetchData() {
        compositeDisposable.add(jsonApi.rounds
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{rounds->displayData(rounds)}
        )
    }

    private fun displayData(rounds: List<Round>?) {

        val rounds_adapter = RoundAdapter(this, rounds!!)
        rv_rounds.adapter = rounds_adapter
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
