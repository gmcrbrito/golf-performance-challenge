package com.hole19golf.performance.ui.ui.modelUI

import com.google.gson.annotations.SerializedName

enum class CategoryId (){
    @SerializedName("driving_accuracy") DRIVING_ACCURACY,
    @SerializedName("putting") PUTTING,
    @SerializedName("recovery") RECOVERY,
    @SerializedName("gir") GIR,
    @SerializedName("scoresbypar") SCORES_BY_PAR,
    @SerializedName("scoring") SCORING;
}