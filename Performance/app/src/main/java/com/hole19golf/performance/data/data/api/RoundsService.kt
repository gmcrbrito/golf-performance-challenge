package com.hole19golf.performance.data.data.api

import com.hole19golf.performance.data.data.modelAPI.RoundsApiResponse
import io.reactivex.Single
import retrofit2.http.GET

interface RoundsService {
    @get: GET("rounds")
    val rounds: Single<RoundsApiResponse>
}