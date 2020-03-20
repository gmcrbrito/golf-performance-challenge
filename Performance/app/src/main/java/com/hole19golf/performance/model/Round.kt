package com.hole19golf.performance.model

class Round {
    var user_id : Int = 0
    var started_at : String = ""
    var course_name : String = ""
    var holes_played_count : Int = 0
    var tags : List<String> = listOf()
    var score : Int = 0
    var sub_score : Int = 0
}