package com.hole19golf.performance.data.data.model

import com.google.gson.annotations.SerializedName
import com.hole19golf.performance.ui.ui.modelUI.DateFormatterUI
import java.io.Serializable

class Round: Serializable{
    @SerializedName("started_at") var startedAt : String = ""
    @SerializedName("course_name") var courseName : String = ""
    @SerializedName("holes_played_count") var holesPlayedCount : Int = 0
    var score : Int = 0
    @SerializedName("sub_score") var subScore : Int = 0
    var finalDate: String = ""
}

