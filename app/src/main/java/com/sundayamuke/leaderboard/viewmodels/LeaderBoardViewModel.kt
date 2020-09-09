package com.sundayamuke.leaderboard.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sundayamuke.leaderboard.model.LearningLeader
import com.sundayamuke.leaderboard.network.boardAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LeaderBoardViewModel: ViewModel() {

    private val _list = MutableLiveData<List<LearningLeader>>()
    val list: LiveData<List<LearningLeader>>
        get() = _list


    init {
        val service = boardAPI.retrofitService.getLearningLeaders()

        service.enqueue(object : Callback<List<LearningLeader>> {
            override fun onResponse(call: Call<List<LearningLeader>>, response: Response<List<LearningLeader>>) {
                _list.value = response.body()
            }

            override fun onFailure(call: Call<List<LearningLeader>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}