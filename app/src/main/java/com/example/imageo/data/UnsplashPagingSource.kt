package com.example.imageo.data

import androidx.paging.PagingSource
import com.example.imageo.api.UnsplashApi
import retrofit2.HttpException
import java.io.IOError
import java.io.IOException

private const val UNSPLASH_STARTING_PAGE_INDEX = 1

class UnsplashPagingSource(
    private val unsplashApi : UnsplashApi
) : PagingSource<Int , UnsplashPhoto>(){
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashPhoto> {
        val position = params.key ?: UNSPLASH_STARTING_PAGE_INDEX

        return try{
            val response = unsplashApi.getPhotos(position , 20)

            LoadResult.Page(
                data = response,
                prevKey = if(position == UNSPLASH_STARTING_PAGE_INDEX)null else position - 1,
                nextKey = if(response.isEmpty()) null else position + 1
            )

        }catch(exception : IOException){
            LoadResult.Error(exception)
        }catch(exception : HttpException){
            LoadResult.Error(exception)
        }
    }
}