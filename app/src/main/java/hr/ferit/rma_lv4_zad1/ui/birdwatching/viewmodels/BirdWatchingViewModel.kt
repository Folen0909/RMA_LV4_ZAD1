package hr.ferit.rma_lv4_zad1.ui.birdwatching.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hr.ferit.rma_lv4_zad1.model.BirdCounter

class BirdWatchingViewModel(private val birdCounter: BirdCounter): ViewModel() {

    private val _birdCount = MutableLiveData(birdCounter)
    val birdCount: LiveData<BirdCounter> = _birdCount

    fun birdSpotted(color: String) {
        birdCounter.birdSpotted(color)
        updateLiveData()
    }

    fun clearData() {
        birdCounter.clearData()
        updateLiveData()
    }

    fun loadData(count: Int, color: String) {
        birdCounter.counter = count
        birdCounter.color = color
        updateLiveData()
    }

    private fun updateLiveData() {
        _birdCount.postValue(birdCounter)
    }
}