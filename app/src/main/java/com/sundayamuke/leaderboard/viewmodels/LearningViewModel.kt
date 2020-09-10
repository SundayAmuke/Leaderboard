package com.sundayamuke.leaderboard.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sundayamuke.leaderboard.model.LearningLeader
import com.sundayamuke.leaderboard.network.BoardAPI
import kotlinx.coroutines.*
import java.lang.Exception

class LearningViewModel: ViewModel() {

    private val _list = MutableLiveData<List<LearningLeader>>()
    val list: LiveData<List<LearningLeader>>
        get() = _list

    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        viewModelScope.launch {
            loadLearningLeaders()
        }
    }

    private suspend fun loadLearningLeaders() {
        withContext(Dispatchers.IO) {
            val service = BoardAPI.retrofitService.getLearningLeaders()

            try {
                val listResult: List<LearningLeader> = service.await()
                _list.postValue(listResult)
            } catch (e: Exception) {
                Log.i("LearningViewModel", "Error occurred")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}