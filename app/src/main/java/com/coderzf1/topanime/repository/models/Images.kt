package com.coderzf1.topanime.repository.models


import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("jpg")
    val jpg: Jpg,
    @SerializedName("webp")
    val webp: Webp
)