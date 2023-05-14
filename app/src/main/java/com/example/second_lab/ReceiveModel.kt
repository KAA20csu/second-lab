package com.example.second_lab

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ReceiveModel(
    @SerializedName("img")
    @Expose
    val img: String? = null,
    @SerializedName("title")
    @Expose
    val title: String? = null,
    @SerializedName("subtitle")
    @Expose
    val subtitle: String? = null,
    @SerializedName("hasBag")
    @Expose
    val hasBag: String? = null,
    @SerializedName("isCircle")
    @Expose
    val isCircle: Boolean? = null) {

}
