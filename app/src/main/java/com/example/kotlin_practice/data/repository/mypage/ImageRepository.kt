package com.example.kotlin_practice.data.repository.mypage

import androidx.lifecycle.MutableLiveData
import com.example.kotlin_practice.data.api.MyPageApiService
import com.example.kotlin_practice.data.model.mypage.tree.TreeModelItemList
import com.example.kotlin_practice.di.MyPageNetworkModule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ImageRepository @Inject constructor(val retroInstance: MyPageApiService) {


    // code for recyclerview
    fun makeAPICall(liveTreeList: MutableLiveData<TreeModelItemList>) {
        val retroInstance = MyPageNetworkModule.getRetroInstance()
        val call  = retroInstance.getTreeData()

        call.enqueue(object : Callback<TreeModelItemList> {
            override fun onFailure(call: Call<TreeModelItemList>, t: Throwable) {
                liveTreeList.postValue(null)
            }

            override fun onResponse(
                call: Call<TreeModelItemList>,
                response: Response<TreeModelItemList>
            ) {
                liveTreeList.postValue(response.body())
            }
        })

    }

}

// 아직 잘 모르겠는 부분..ㅜ
// 깜빡했는데 Repository 는 Interface 로 선언하고 ~RepositoryImpl 이라는 구현체 클래스를 따로 만들어주세요.
// Module 내용도 바뀌어야겠죠? :)