package com.example.newsapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.newsapp.databinding.TitleItemBinding


class NewsAdapter(
    private var newsItems: MutableList<NewsData>,
    private var onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(position: Int, title: String, article: String,newsImg:Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TitleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return newsItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(newsItems[position])
    }

    inner class ViewHolder(private val binding: TitleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.titleArea.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val item = newsItems[position]
                    onItemClickListener.onItemClick(position,item.title, item.article,item.newsImg)
                }
            }
        }

        fun bindItems(item: NewsData) {
            binding.titleArea.text = item.title
            binding.imaArea.setImageResource(item.newsImg)
        }
    }
}





