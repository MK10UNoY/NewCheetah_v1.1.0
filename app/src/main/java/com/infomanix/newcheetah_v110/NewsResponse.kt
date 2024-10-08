package com.infomanix.newcheetah_v110

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)
