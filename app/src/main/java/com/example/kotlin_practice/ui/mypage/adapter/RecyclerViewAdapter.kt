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
        binding = RecyclerRowMypageBinding.inflate(inflater) // xml 에 씌여져 있는 view 의 정의를 실제 view 객체로 만듦
        return MyViewHolder( // ViewBinding 을 이용하기 위해 view 가 들어가지 않고 view 객체를 넣음
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
            ("LEV : " + tree.level.toString()).also { binding.level.text = it } // assignment 방식으로 concat 하는 것을 권장
            ("EXP : " + tree.exp.toString()).also { binding.exp.text = it }
            /**
            (추가할 내용)
            심을 날짜 : CreatedDate
            심은 지 경과된 일수 : CreatedDate 와 now 로 비교
            xml 에 하드 코딩해서 들어갈 자리를 표시해놓은 상태
            후에 개발 상황에 따라 뺄 수도 있음
             */

            // coil 이미지 로더 사용
            binding.imagePath.load(tree.item.imagePath) {
                crossfade(true)
                crossfade(1000)
            }
        }
    }
}