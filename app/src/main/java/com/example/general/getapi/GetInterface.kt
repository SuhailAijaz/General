package com.example.general.getapi
import com.example.general.getapi.comments.GetCommentsDataClass
import com.example.general.posts.GetPostsData
import retrofit2.Response
import retrofit2.http.GET

interface GetInterface {
@GET("comments")
//suspend fun getApiData():Response<GetModalClass>
 suspend fun getCommentsApiData():Response<GetCommentsDataClass>

@GET("posts")
suspend fun getPostsApiData():Response<GetPostsData>


}