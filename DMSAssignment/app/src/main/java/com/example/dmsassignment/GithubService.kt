package com.example.dmsassignment

import com.example.dmsassignment.data.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("users/{username}")
    fun getUserInfo(@Path("username") username : String) : Call<UserInfo>

    @GET("users/{username}/repos")
    fun getUserRepoInfo(@Path("username") username : String) : Call<List<RepositoryInfo>>

    @GET("users/{username}/starred")
    fun getUserStarsInfo(@Path("username") username : String) : Call<List<StarsInfo>>

    @GET("users/{username}/followers")
    fun getUserFollowersInfo(@Path("username") username : String) : Call<List<FollowersInfo>>

    @GET("users/{username}/following")
    fun getUserFollowingInfo(@Path("username") username : String) : Call<List<FollowingInfo>>
}