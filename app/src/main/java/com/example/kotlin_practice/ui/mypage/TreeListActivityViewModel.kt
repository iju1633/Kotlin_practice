package com.example.kotlin_practice.ui.mypage


import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.example.kotlin_practice.data.model.mypage.tree.TreeModelItemList
import com.example.kotlin_practice.data.repository.mypage.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TreeListActivityViewModel @Inject constructor(val repository: ImageRepository): ViewModel() {

    var liveTreeListItemList: MutableLiveData<TreeModelItemList> = MutableLiveData()


    fun getLiveDataObserver(): MutableLiveData<TreeModelItemList> {
        return liveTreeListItemList
    }

    fun loadListOfData() {
        repository.makeAPICall(liveTreeListItemList)
    }
}