package com.pankti.webservicewithretrofit.data.network

import com.pankti.webservicewithretrofit.domain.entities.CommentDataModel
import com.pankti.webservicewithretrofit.domain.entities.PostDataModel
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitAPI {

    // without any query params
    @GET("/posts")
    suspend fun getPosts(): List<PostDataModel>

    // with path param , it will be added like : /posts/1
    @GET("/posts/{id}")
    suspend fun getPost(@Path("id") id: String): PostDataModel


    @GET("/posts/{id}/comments")
    fun getCommentsForPost(@Path("id") id: String): Call<List<CommentDataModel>>

    // with query param , it will be added like : /comments?postId=1
    @GET("/comments")
    fun getCommentsForPostId(@Query("postId") postId: String): Call<List<CommentDataModel>>

    @POST("/posts")
    fun getPostWithPost(): Call<List<PostDataModel>>

    @DELETE("/posts/{id}")
    fun deletePost(@Path("id") id: String): Call<PostDataModel>

}