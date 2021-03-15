package com.example.imageo.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.imageo.api.UnsplashApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnsplashRepository @Inject constructor(private val unsplashApi: UnsplashApi){
    fun getPhotos() =
        Pager(
            config = PagingConfig(
                pageSize = 4,
                maxSize = 20,
                enablePlaceholders = false
            ),pagingSourceFactory = {UnsplashPagingSource(unsplashApi)}
        ).liveData
}
