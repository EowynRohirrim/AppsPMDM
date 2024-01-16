package com.patri.appspmdm.VideoGameApp

import com.google.gson.annotations.SerializedName
import com.patri.appspmdm.SuperheroApp.Biography
import com.patri.appspmdm.SuperheroApp.PowerStatsResponse
import com.patri.appspmdm.SuperheroApp.SuperheroImageDetailResponse

data class VideoGameDetailResponse(
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: SuperheroImageDetailResponse)
