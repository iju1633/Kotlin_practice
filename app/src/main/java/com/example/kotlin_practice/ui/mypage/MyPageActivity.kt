package com.example.kotlin_practice.ui.mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_practice.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_mypage.*

@AndroidEntryPoint
class MyPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)

        // 마이페이지의 more info > 를 누르면 나무 리스트 창으로 전환됨
        goto_treeList.setOnClickListener {
            val intent = Intent(this, TreeListActivity::class.java)
            startActivity(intent)

        }
    }

}