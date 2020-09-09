package com.sundayamuke.leaderboard.network

import com.sundayamuke.leaderboard.model.IQLeader
import com.sundayamuke.leaderboard.model.LearningLeader
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://gadsapi.herokuapp.com/"

val retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    // .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface BoardAPIService {

    @GET("/api/hours")
    fun getLearningLeaders() : Call<List<LearningLeader>>

    @GET("/api/skilliq")
    fun getSkillIQLeaders() : Call<List<IQLeader>>
}

object boardAPI {
    val retrofitService : BoardAPIService by lazy {
        retrofit.create(BoardAPIService::class.java)
    }
}