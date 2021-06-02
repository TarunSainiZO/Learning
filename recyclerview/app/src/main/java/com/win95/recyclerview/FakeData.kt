package com.win95.recyclerview

class FakeData {
    val data : MutableList<UserData>
    init{
        data = arrayListOf()
        for(i in 1..100){
            data.add(UserData("user $i",i))
        }
    }
}