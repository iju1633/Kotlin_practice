package com.example.kotlin_practice.ui.mypage


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_practice.data.model.mypage.RecyclerData
import com.example.kotlin_practice.data.repository.mypage.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TreeListActivityViewModel @Inject constructor(private val repository: ImageRepository): ViewModel() {
    lateinit var liveDataList: MutableLiveData<List<RecyclerData>>
    init {
        liveDataList = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<List<RecyclerData>>{
        return liveDataList
    }

    fun loadListOfData() {
        repository.makeApiCall("ny", liveDataList)
    }
}