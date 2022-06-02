package com.sintatsky.astest.presentation.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sintatsky.astest.R
import com.sintatsky.astest.databinding.ItemNewsBinding
import com.sintatsky.astest.databinding.ItemReviewBinding
import com.sintatsky.astest.domain.entity.review.ReviewResult
import com.sintatsky.astest.domain.entity.top_news.TopNewsResult

class TopNewsListAdapter :
    ListAdapter<TopNewsResult, TopNewsListAdapter.TopNewsViewHolder>(TopNewsListDiffCallback()) {

    class TopNewsViewHolder(val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root)

    class TopNewsListDiffCallback : DiffUtil.ItemCallback<TopNewsResult>() {
        override fun areItemsTheSame(oldItem: TopNewsResult, newItem: TopNewsResult) =
            oldItem.title == newItem.title &&
        oldItem.abstract == newItem.abstract

        override fun areContentsTheSame(oldItem: TopNewsResult, newItem: TopNewsResult) =
            oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopNewsViewHolder {
        val binding = ItemNewsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TopNewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopNewsViewHolder, position: Int) {
        val topNews = getItem(position)
        with(holder.binding){
            tvTitle.text = topNews?.title
            if (topNews.abstract?.isNotEmpty() == true){
                tvShortDescription.text = topNews?.abstract
            }else{
                tvShortDescription.text = topNews?.title
            }

        }
    }
}