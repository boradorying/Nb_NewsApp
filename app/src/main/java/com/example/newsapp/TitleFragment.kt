package com.example.newsapp

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {
    private lateinit var binding: FragmentTitleBinding
    private val newsItems: MutableList<NewsData> = mutableListOf()
    private lateinit var newsAdapter: NewsAdapter
    private var isDualPane: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTitleBinding.inflate(inflater, container, false)

        newsAdapter = NewsAdapter(newsItems, object : NewsAdapter.OnItemClickListener {
            override fun onItemClick(position: Int, title: String, article: String,newsImg:Int) {
                val articleFragment = ArticleFragment()

                val bundle = Bundle()
                bundle.putString("TITLE",title)
                bundle.putString("ARTICLE",article)
                bundle.putInt("IMG",newsImg)
                articleFragment.arguments = bundle


                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {//현재 디바이스화면방향 확인하고==그게 가로방향일떄 true~!
                    val articleFragmentContainer = requireActivity().findViewById<FrameLayout>(R.id.articleFragmentContainer)//binding.root로 아이디 찾기가능
                    //require를 쓰는이유는 main에 있는 레이아웃에 속한 뷰이기때문에 바인딩개체로 직접 접근 할 수 없어서!!!
                    if (articleFragmentContainer != null) {
                        parentFragmentManager.beginTransaction()//머릿속에 확 기억에 남습니다
                            .replace(R.id.articleFragmentContainer, articleFragment)
                            .commit()
                    }
                } else {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.titleFragmentContainer, articleFragment)
                        .addToBackStack(null)
                        .commit()
                }
            }
        })
        newsItems.clear()//리싸이클러뷰 초기화 ㅠㅠ...
        newsItems.addAll(NewsList.newsItems)
        binding.RVArea.layoutManager = LinearLayoutManager(requireContext())
        binding.RVArea.adapter = newsAdapter

        return binding.root
    }


}
