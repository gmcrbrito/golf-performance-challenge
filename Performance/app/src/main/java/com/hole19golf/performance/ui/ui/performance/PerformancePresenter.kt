package com.hole19golf.performance.ui.ui.performance

import android.util.Log
import com.hole19golf.performance.data.data.api.ServiceBuilder
import com.hole19golf.performance.data.data.api.StatisticsService
import com.hole19golf.performance.ui.ui.modelUI.StatisticsUI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class PerformancePresenter() {

    private lateinit var view: View
    internal lateinit var statisticsApi: StatisticsService
    var compositeDisposable = CompositeDisposable()

    fun attachView(view: View){
        this.view = view
    }

    fun onStart() {
        inicializeApi()
        fetchData()
    }

    fun onRoundsClick() {
        view.goToRoundsList()
    }

    interface View {
        fun goToRoundsList()
        fun displayStatistics(statisticsUI: StatisticsUI)
    }

    fun inicializeApi(){
        // Inicialize API
        val retrofit = ServiceBuilder.instance
        statisticsApi = retrofit.create(StatisticsService::class.java)
    }

    fun fetchData() {
        compositeDisposable.add(statisticsApi.statistics
            .subscribeOn(Schedulers.io())
            .map { statisticsApi ->
                val statistics = mutableListOf<StatisticsUI>()
                for (statistic in statisticsApi.statistics) {
                    val statisticsUI = StatisticsUI().apply {
                        categoryIdUI = statistic.categoryId
                        valueUi = statistic.value
                        categoryNameUi = statistic.categoryName
                        categoryDescriptionUi = statistic.categoryDescription
                    }
                    statistics.add(statisticsUI)
                }
                statistics
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ uiStatistics ->
                for (statistic in uiStatistics) {
                    view.displayStatistics(statistic)
                }
            },
                { t: Throwable -> Log.e(PerformanceFragment::class.java.simpleName, t.message) })
        )
    }
}