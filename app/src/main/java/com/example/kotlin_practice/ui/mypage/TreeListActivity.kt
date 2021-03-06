package com.example.kotlin_practice.ui.mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_practice.databinding.ActivityMypageTreelistBinding
import com.example.kotlin_practice.ui.mypage.adapter.RecyclerViewAdapter
import dagger.hilt.android.AndroidEntryPoint


///////////////// 상세페이지 /////////////////
@AndroidEntryPoint
class TreeListActivity : AppCompatActivity() {
    lateinit var recyclerAdapter: RecyclerViewAdapter
    private lateinit var binding : ActivityMypageTreelistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMypageTreelistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        initViewModel()

        // 유저가 보유한 나무 목록을 보여주는 페이지의 좌측 상단 뒤로가기 아이콘을 누르면 마이페이지 창으로 전환됨
        binding.gotoMyPage.setOnClickListener {
            val intent = Intent(this, MyPageActivity::class.java)
            startActivity(intent)
        }
    }

    // adapter 부착
    private fun initRecyclerView() {
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerAdapter = RecyclerViewAdapter()
        binding.recyclerview.adapter =recyclerAdapter

    }

    private fun initViewModel() {
        val viewModel:TreeListActivityViewModel = ViewModelProvider(this).get(TreeListActivityViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this, Observer {
            if(it != null) {
                recyclerAdapter.setDataList(it)
                recyclerAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "Error in getting list", Toast.LENGTH_SHORT).show()
            }
        })

        // data fetch 를 위해 필수적인 코드!!
        viewModel.loadListOfData()
    }
}