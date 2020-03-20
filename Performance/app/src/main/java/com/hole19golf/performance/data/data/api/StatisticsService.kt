package com.hole19golf.performance.data.data.api

import com.hole19golf.performance.data.data.modelAPI.StatisticsApiResponse
import io.reactivex.Single
import retrofit2.http.GET

interface StatisticsService {
    @get: GET("statistics")
    val statistics: Single<StatisticsApiResponse>

}