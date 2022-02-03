package com.example.kotlin_practice.ui.mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlin_practice.databinding.ActivityMypageBinding
import com.example.kotlin_practice.di.MyPageNetworkModule
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.*

@AndroidEntryPoint
class MyPageActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMypageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMypageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.gotoTreeList.setOnClickListener {
            val intent = Intent(this, TreeListActivity::class.java)
            startActivity(intent)
        }

        getCurrentData()
    }

    private fun getCurrentData() {

        val api = MyPageNetworkModule.getRetroInstance()

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = api.getUserData().awaitResponse()
                if (response.isSuccessful) {
                    val data = response.body()!!

                    withContext(Dispatchers.Main) {
                        binding.name.text = data.username
                        // register_date.text = data.createdDate
                        (data.point.toString() + " P").also { binding.point.text = it } // 1000 P
                        ("X " + data.buckets.toString()).also { binding.pail.text = it } // X 3
                        ("X " + data.dailyWalks.toString()).also { binding.numberOfSteps.text = it } // X 0
                        // km.text = data.totalDistance
                    }
                }
            } catch (e : Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(applicationContext, "Seems like something went wrong...", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
