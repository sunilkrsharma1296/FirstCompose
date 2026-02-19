package com.sunil.firstcompose.api

import com.sunil.firstcompose.data.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers


interface TweetsyAPI {

    @GET("v3/b/6995c72ad0ea881f40c40e90?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String): Response<List<TweetListItem>>


    @GET("v3/b/6995c72ad0ea881f40c40e90?meta=false")
    @Headers("X-JSON-Path:Tweets..category")
    suspend fun getCategories(): Response<List<String>>

}