package com.sintatsky.astest.domain.entity.top_news

data class TopNewsResult(
    val title: String? = null,
    val `abstract`: String? = null,
    val multimedia: List<Multimedia> = listOf()
//    val byline: String? = null,
//    val created_date: String? = null,
//    val des_facet: List<String> = listOf(),
//    val geo_facet: List<String> = listOf(),
//    val item_type: String? = null,
//    val kicker: String? = null,
//    val material_type_facet: String? = null,

//    val org_facet: List<String> = listOf(),
//    val per_facet: List<String> = listOf(),
//    val published_date: String? = null,
//    val section: String? = null,
//    val short_url: String? = null,
//    val subsection: String? = null,
//    val updated_date: String? = null,
//    val uri: String? = null,

)