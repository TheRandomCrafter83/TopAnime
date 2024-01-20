package com.coderzf1.topanime

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coderzf1.topanime.api.TopAnimeRetrofitInstance
import com.coderzf1.topanime.repository.models.Data
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    val animeList = MutableStateFlow<List<Data>>(emptyList())
    private var job: Job? = null

    fun getTopAnime(){
        job?.cancel()
        job = viewModelScope.launch(Dispatchers.IO) {
            val response = TopAnimeRetrofitInstance.api.getTopAnime()
            if (response.isSuccessful) {
                withContext(Dispatchers.IO) {
                    animeList.value = response.body()?.data ?: emptyList()
                }
            }
        }
    }
}