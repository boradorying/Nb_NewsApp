package com.example.newsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsapp.databinding.FragmentArticleBinding


class ArticleFragment : Fragment() {
    private lateinit var binding: FragmentArticleBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArticleBinding.inflate(inflater,container,false)

        val title   = arguments?.getString("TITLE")
        val article  = arguments?.getString("ARTICLE")
        var img =  arguments?.getInt("IMG")

        binding.titleArea.text =title
        binding.aricleArea.text= article
        binding.imgArea.setImageResource(img!!)

        return binding.root
    }


}