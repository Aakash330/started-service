package com.example.startedservice

class SimpleData {
    companion object{
        fun getSong() :MutableList<String>{
          val mutableList= mutableListOf<String>()
            mutableList.add("har dil jo")
            mutableList.add("mera dil ")
            mutableList.add("tum jo ho")
            mutableList.add("khushi jab bhi me gam")
            mutableList.add("zindgi dubra")
            return mutableList
        }
    }
}