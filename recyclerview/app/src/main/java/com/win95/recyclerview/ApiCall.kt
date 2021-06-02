package com.win95.recyclerview

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

var BASE_URL = "https://api.github.com/"
interface ApiCall {
    @GET("users")
    fun getUsers() : Call<List<UserData>>
}

object fetchUser{
    val apiCall : ApiCall
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiCall = retrofit.create(ApiCall::class.java)
    }
}