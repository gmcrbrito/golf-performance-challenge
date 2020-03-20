package com.hole19golf.performance.ui.ui.rounds

import android.util.Log
import android.widget.ProgressBar
import com.hole19golf.performance.data.data.api.RoundsService
import com.hole19golf.performance.data.data.api.ServiceBuilder
import com.hole19golf.performance.data.data.model.Round
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RoundsPresenter {

    private lateinit var roundsProgressDialog: ProgressBar
    private lateinit var view: View
    internal lateinit var roundsApi: RoundsService
    var compositeDisposable = CompositeDisposable()

    fun onViewAttached(view: RoundsActivity) {
        this.view = view
    }

    fun onCreate(){
        inicializeApi()
        fetchData()
    }

    interface View {
        fun inicializeRecyclerView()
        fun displayRounds(rounds: List<Round>)
    }

    fun inicializeApi(){
        // Inicialize API
        val retrofit = ServiceBuilder.instance
        roundsApi = retrofit.create(RoundsService::class.java)
    }

    fun fetchData() {
        compositeDisposable.add(roundsApi.rounds
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({rounds->view.displayRounds(rounds.rounds)},
                {t: Throwable ->  Log.e(RoundsActivity::class.java.simpleName, t.message)})
        )
    }

}