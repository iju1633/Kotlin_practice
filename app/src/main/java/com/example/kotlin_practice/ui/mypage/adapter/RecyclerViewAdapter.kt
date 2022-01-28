package com.example.kotlin_practice.ui.mypage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.kotlin_practice.R
import com.example.kotlin_practice.data.model.mypage.RecyclerData
import kotlinx.android.synthetic.main.recycler_row_mypage.view.*


class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {



    private var listData: List<RecyclerData>? = null

    fun setlistData(listData: List<RecyclerData>?) {
        this.listData = listData
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.MyViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row_mypage, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {
        holder.bind(listData?.get(position)!!)
    }

    override fun getItemCount(): Int {
        if(listData ==null) return 0
        return listData?.size!!
    }
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val thumbImage = view.thumbImage
        val tvName = view.tvName
        val tvDesc = view.tvDesc

        // 일반적으로 onBindViewHolder가 아닌 Recycler Holder 클래스 내부에 별도의 bind 함수를 구현하여 바인딩을 진행합니다! 한번 알아보시면 도움이 될 것 같아요! --> resolved!
        fun bind(data: RecyclerData) {
            tvName.text = data.name
            tvDesc.text = data.description

            thumbImage.load(data.owner?.avatar_url) {
                crossfade(true)
                crossfade(1000)
            }
        }
    }
}