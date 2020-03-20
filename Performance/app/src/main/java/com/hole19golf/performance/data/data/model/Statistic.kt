package com.hole19golf.performance.data.data.model

import com.google.gson.annotations.SerializedName
import com.hole19golf.performance.ui.ui.modelUI.CategoryId

class Statistic {
    @SerializedName("value") var value : String = ""
    @SerializedName("category_id") var categoryId : CategoryId? = null
    @SerializedName("category_name") var categoryName : String = ""
    @SerializedName("category_description") var categoryDescription : String = ""
}