package com.example.kotlin_practice.ui.mypage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.kotlin_practice.data.model.mypage.tree.TreeModelItem
import com.example.kotlin_practice.data.model.mypage.tree.TreeModelItemList
import com.example.kotlin_practice.databinding.RecyclerRowMypageBinding


class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private lateinit var binding : RecyclerRowMypageBinding

    private var treeListItemList: TreeModelItemList? = null

    fun setDataList(treeListItemList: TreeModelItemList?) {
        this.treeListItemList = treeListItemList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.MyViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        binding = RecyclerRowMypageBinding.inflate(inflater)
        return MyViewHolder(
            binding
        )
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {
        holder.bind(treeListItemList?.get(position)!!)
    }

    override fun getItemCount(): Int {
        return if(treeListItemList == null) 0
        else treeListItemList?.size!!
    }

    inner class MyViewHolder(itemView : RecyclerRowMypageBinding): RecyclerView.ViewHolder(itemView.root){

        // 일반적으로 onBindViewHolder가 아닌 Recycler Holder 클래스 내부에 별도의 bind 함수를 구현하여 바인딩을 진행합니다! 한번 알아보시면 도움이 될 것 같아요! --> resolved!
        fun bind(tree: TreeModelItem) {
            binding.itemName.text = tree.item.itemName
            binding.level.text = tree.level.toString()
            binding.exp.text = tree.exp.toString()

            binding.imagePath.load(tree.item.imagePath) {
                crossfade(true)
                crossfade(1000)
            }
        }
    }
}