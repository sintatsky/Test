package com.sintatsky.astest.domain.entity.top_news

data class TopNews(
    val copyright: String,
    val last_updated: String,
    val num_results: Int,
    val results: List<TopNewsResult>,
    val section: String,
    val status: String
)