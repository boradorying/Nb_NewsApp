package com.example.newsapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
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
        val img =  arguments?.getInt("IMG")

        binding.titleArea.text =title
        binding.aricleArea.text= article
        binding.imgArea.setImageResource(img!!)
//argument?.let{it.getString}으로 묶어서 받을 수도 있다
        return binding.root

//        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {//현재 디바이스화면방향 확인하고==그게 가로방향일떄 true~!
//            val articleFragmentContainer = requireActivity().findViewById<FrameLayout>(R.id.articleFragmentContainer)//binding.root로 아이디 찾기가능
//            //require를 쓰는이유는 main에 있는 레이아웃에 속한 뷰이기때문에 바인딩개체로 직접 접근 할 수 없어서!!!
//            if (articleFragmentContainer != null) {
//                parentFragmentManager.beginTransaction()//머릿속에 확 기억에 남습니다
//                    .replace(R.id.titleFragmentContainer,TitleFragment())
//                    .replace(R.id.articleFragmentContainer, ArticleFragment())
//                    .commit()
//            }
//        } else {
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.articleFragmentContainer, ArticleFragment())
//                .addToBackStack(null)
//                .commit()
//        }

    }


}