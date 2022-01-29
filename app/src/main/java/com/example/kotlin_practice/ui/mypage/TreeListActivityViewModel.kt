package com.example.kotlin_practice.ui.mypage


import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.example.kotlin_practice.data.model.mypage.DataModel
import com.example.kotlin_practice.data.repository.mypage.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TreeListActivityViewModel @Inject constructor(val repository: ImageRepository): ViewModel() {

    lateinit var liveDataList: MutableLiveData<List<DataModel>>

    init {
        liveDataList = MutableLiveData()
    }


    fun getLiveDataObserver(): MutableLiveData<List<DataModel>> {
        return liveDataList
    }

    fun loadListOfData() {
        repository.makeAPICall(liveDataList)
    }
}