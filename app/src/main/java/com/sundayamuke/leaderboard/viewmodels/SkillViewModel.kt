package com.sundayamuke.leaderboard.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sundayamuke.leaderboard.model.SkillLeader
import com.sundayamuke.leaderboard.network.BoardAPI
import kotlinx.coroutines.*
import java.lang.Exception

class SkillViewModel: ViewModel() {

    private val _list = MutableLiveData<List<SkillLeader>>()
    val list: LiveData<List<SkillLeader>>
        get() = _list

    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        viewModelScope.launch {
            loadSkillIQLeaders()
        }
    }

    private suspend fun loadSkillIQLeaders() {
        withContext(Dispatchers.IO) {
            val service = BoardAPI.retrofitService.getSkillIQLeaders()

            try {
                val listResult: List<SkillLeader> = service.await()

                _list.postValue(listResult)
            } catch (e: Exception) {
                Log.i("SkillViewModel", "Error occurred")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}