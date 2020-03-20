package com.hole19golf.performance.ui.performance

class PerformancePresenter() {

    private lateinit var view: View

    fun attachView(view: View){
        this.view = view
    }

    fun onStart() {
      view.setRoundsNumber("42")

    }

    fun onRoundsClick() {
        view.goToRoundsList()
    }

    interface View {
        fun setRoundsNumber(text:String)
        fun goToRoundsList()
    }
}