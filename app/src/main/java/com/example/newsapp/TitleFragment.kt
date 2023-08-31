package com.example.newsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

                parentFragmentManager.beginTransaction()
                    .replace(R.id.titleFragmentContainer, articleFragment)
                    .addToBackStack(null)
                    .commit()
            }

        })

        newsItems.addAll(NewsList.newsItems)
        binding.RVArea.layoutManager = LinearLayoutManager(requireContext())
        binding.RVArea.adapter = newsAdapter

        return binding.root
    }
}
