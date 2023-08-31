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

                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    val articleFragmentContainer = requireActivity().findViewById<FrameLayout>(R.id.articleFragmentContainer)
                    if (articleFragmentContainer != null) {
                        parentFragmentManager.beginTransaction()
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
