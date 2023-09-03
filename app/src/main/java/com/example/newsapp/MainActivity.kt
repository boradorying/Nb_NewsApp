package com.example.newsapp


import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.newsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var titleFragment: TitleFragment
    private lateinit var articleFragment: ArticleFragment


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        titleFragment = TitleFragment()
        articleFragment = ArticleFragment()

        if (savedInstanceState == null) {
            ////화면변경 구성으로 인해 액티비티가 다시 시작될때 프래그먼트 다시 추가하려고...사용한이유는 이전 상태를 복원할필요없어서savedInstanceState == null은 액티비티 처음시작될때말하느것
            val isLandscape = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
                //리소스콘피규레이션오리엔테션 현재 디바이스 화면 방향. == 디바이스가 가로방향인지를 여부 확인
            if (isLandscape) {
                // 가로 방향
                supportFragmentManager.beginTransaction()
                    .replace(R.id.titleFragmentContainer, titleFragment)//아이디에 있는 현재프래그먼트를 지정된(여기선 titlefragment임) 화면에 표시할 먼트를 설정 즉 교체
                    .replace(R.id.articleFragmentContainer, articleFragment)
                    .commit()//실제 화면 변경이 화면에 반영!!
            } else {
                // 세로 방향
                supportFragmentManager.beginTransaction()
                    .replace(R.id.titleFragmentContainer, titleFragment)
                    .commit()
            }
        }
    }



}




