package com.pankti.webservicewithretrofit.domain.entities

import com.google.gson.annotations.SerializedName

data class PostDataModel(
    var userId: Int = 0,
    var id: Int = 0,
    var title: String = "",
    @SerializedName("body")var description: String = "",
    var errorMessage : String = ""
) {}