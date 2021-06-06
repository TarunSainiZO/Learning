package com.win95.rec

import com.win95.recyclerview.UserData
import com.win95.recyclerview.fetchUser
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
     val list: MutableLiveData<List<UserData>> = MutableLiveData(arrayListOf())
    fun fetchData() {
        if (list.value?.isEmpty() == true) {
            Log.d("debug","make new call")
            val users: Call<List<UserData>> = fetchUser.apiCall.getUsers()
            users.enqueue(object : Callback<List<UserData>> {
                override fun onResponse(
                    call: Call<List<UserData>>,
                    response: Response<List<UserData>>
                ) {
                    val userDataList: List<UserData> = response.body()!!
                    print("after data")
                    for(i in userDataList){
                        Log.d("debug","data = ${i.avatarUrl}")
                    }
                    list.value = userDataList
                }
                override fun onFailure(call: Call<List<UserData>>, t: Throwable) {
                    print("error")
                }
            })
        }
    }
}