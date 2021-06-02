package com.win95.recyclerview

import com.google.gson.annotations.SerializedName

data class UserData (

    @SerializedName("login") var login : String,
    @SerializedName("id") var id : Int,
)