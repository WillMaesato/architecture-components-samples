package com.example.data.api

import com.google.gson.annotations.SerializedName

data class AccessTokenParameter(
    @SerializedName("client_id")
    val clientId: String,
    @SerializedName("client_secret")
    val clientSecret: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("redirect_uri")
    val redirectUri: String? = null,
    @SerializedName("state")
    val state: String? = null
)
