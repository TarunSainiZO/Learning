package com.win95.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.internal.ContextUtils.getActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.rvUsers)
        val re : List<UserData> = arrayListOf(
            UserData("kjs","2342"),
            UserData("kjs","2342"),
            UserData("kjs","2342"),
            UserData("kjs","2342"),
            UserData("kjs","2342"),
            UserData("kjs","2342"),
            UserData("kjs","2342"),
            UserData("kjs","2342"),
            UserData("kjs","2342"),
            UserData("kjs","2342"),
            UserData("kjs","2342")
        )
        println(re.toString())
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.adapter = MyAdapter(re)
    }

    private fun getData(recyclerView: RecyclerView) {
        val users: Call<List<UserData>> = fetchUser.apiCall.getUsers()
        users.enqueue(object : Callback<List<UserData>> {
            override fun onResponse(
                call: Call<List<UserData>>,
                response: Response<List<UserData>>
            ) {
                val userDataList : List<UserData> = response.body()!!

            }

            override fun onFailure(call: Call<List<UserData>>, t: Throwable) {
                println("-------------------------------------" +
                        "----------------failure-----------------" +
                        "-------------------------------------")
                println("-------------------------------------" +
                        "----------------failure-----------------" +
                        "-------------------------------------")
                println("-------------------------------------" +
                        "----------------failure-----------------" +
                        "-------------------------------------")
            }

        })
    }
}