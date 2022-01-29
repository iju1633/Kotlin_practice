package com.example.kotlin_practice.ui.mypage.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.kotlin_practice.R
import com.example.kotlin_practice.data.model.mypage.DataModel
import kotlinx.android.synthetic.main.recycler_row_mypage.view.*

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private var dataList: List<DataModel>? = null


    fun setDataList(DataList: List<DataModel>?) {
        this.dataList = DataList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row_mypage, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {
        holder.bind(dataList?.get(position)!!)
    }

    override fun getItemCount(): Int {
        if(dataList == null) return 0
        else return dataList?.size!!
    }

    class MyViewHolder(view : View): RecyclerView.ViewHolder(view){
        val thumbnailUrl = view.thumbnailUrl
        val title = view.title
        val url = view.url

        // 일반적으로 onBindViewHolder가 아닌 Recycler Holder 클래스 내부에 별도의 bind 함수를 구현하여 바인딩을 진행합니다! 한번 알아보시면 도움이 될 것 같아요! --> resolved!
        fun bind(data: DataModel) {
            title.text = data.title
            url.text = data.url

            thumbnailUrl.load(data.thumbnailUrl) {
                crossfade(true)
                crossfade(1000)
            }
        }
    }
}