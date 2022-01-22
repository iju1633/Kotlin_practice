package com.example.kotlin_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    val a = 1 // 값 변경 불가
//    var b = 2 // 값 변경 가능

    override fun onCreate(savedInstanceState: Bundle?) { // Null 값도 들어갈 수 있게 "?"가 필요한 것임
        super.onCreate(savedInstanceState) // view 를 미리 저장
        setContentView(R.layout.activity_main) // activity_main.xml 파일을 띄울 것

    }

    fun DDuck(v : View) {
        tv.text = "뚝"
    }
}

// 구글링해서 복사한 자바 코드를 복붙하면 kotlin 으로 변경하겠냐는 문구가 뜸^^

/*// println("안녕하세요") -> log 를 대신함
        println(sum(1,3))
        println(sum1(1,3))*/

/*    fun sum(a: Int, b: Int): Int { // Int 가 반환형이라는 소리
        return a+b
    }

    fun sum1(a: Int, b: Int) = a+b // 이것도 위의 함수과 같은 결과

    val str = "코로나 조심하세요"
    val str2 = str.replace("조심하세요", "이겨내요") + "!!"*/