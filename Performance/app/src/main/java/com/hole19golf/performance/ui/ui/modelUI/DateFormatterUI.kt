package com.hole19golf.performance.ui.ui.modelUI

import android.annotation.SuppressLint
import java.text.SimpleDateFormat

object DateFormatterUI {
    // How i want to show
    @SuppressLint("SimpleDateFormat")
    val offsetDateFormat: SimpleDateFormat = SimpleDateFormat("MMMM yyyy")
    // How i receive
    @SuppressLint("SimpleDateFormat")
    val dateFormatter: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss'Z'")
}