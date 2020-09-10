package com.sundayamuke.leaderboard.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.sundayamuke.leaderboard.model.SkillLeader
import com.sundayamuke.leaderboard.model.LearningLeader
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://gadsapi.herokuapp.com/"

val retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface BoardAPIService {

    @GET("/api/hours")
    fun getLearningLeaders() : Deferred<List<LearningLeader>>

    @GET("/api/skilliq")
    fun getSkillIQLeaders() : Deferred<List<SkillLeader>>
}

object BoardAPI {
    val retrofitService : BoardAPIService by lazy {
        retrofit.create(BoardAPIService::class.java)
    }
}