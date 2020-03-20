package com.hole19golf.performance.api

import com.hole19golf.performance.model.Round
import io.reactivex.Observable
import retrofit2.http.GET

interface RoundsService {

    @get: GET("rounds")
    val rounds: Observable<List<Round>>
}