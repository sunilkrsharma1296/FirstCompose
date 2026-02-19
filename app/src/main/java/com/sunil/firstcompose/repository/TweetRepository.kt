package com.sunil.firstcompose.repository

import com.sunil.firstcompose.api.TweetsyAPI
import com.sunil.firstcompose.data.TweetListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(private val tweetsyAPI: TweetsyAPI) {

    private var _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>>
        get()=_categories

    private var _tweets = MutableStateFlow<List<TweetListItem>>(emptyList())
    val tweets: StateFlow<List<TweetListItem>>
        get()=_tweets


    suspend fun getCategories(){
        val response=tweetsyAPI.getCategories()

        if (response.isSuccessful && response.body() != null){
            _categories.emit(response.body()!!)
        }
    }

    suspend fun getTweets(category: String){
        val response=tweetsyAPI.getTweets("\$..Tweets[?(@.category==\"$category\")]")

        if (response.isSuccessful && response.body() != null){
            _tweets.emit(response.body()!!)
        }
    }
}