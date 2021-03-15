package com.example.imageo.api

import com.example.imageo.BuildConfig
import com.example.imageo.data.UnsplashPhoto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnsplashApi{

    companion object{
        const val BASE_URL = "https://api.unsplash.com/"
        const val CLIENT_ID = BuildConfig.UNSPLASH_ACCESS_KEY
    }
    @Headers("Accept-Version: v1","Authorization: Client-ID $CLIENT_ID")
    @GET("photos")
    suspend fun getPhotos(
        @Query("page") page : Int,
        @Query("per_page") per_page : Int
    ) : List<UnsplashPhoto>
}