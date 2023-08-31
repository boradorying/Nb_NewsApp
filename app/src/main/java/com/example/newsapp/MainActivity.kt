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
            val isLandscape = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

            if (isLandscape) {
                // 가로 방향
                supportFragmentManager.beginTransaction()
                    .replace(R.id.titleFragmentContainer, titleFragment)
                    .replace(R.id.articleFragmentContainer, articleFragment)
                    .commit()
            } else {
                // 세로 방향
                supportFragmentManager.beginTransaction()
                    .replace(R.id.titleFragmentContainer, titleFragment)
                    .commit()
            }
        }
    }


}




