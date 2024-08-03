package com.tejas.staggeredgridlayoutcompose.api

import com.tejas.staggeredgridlayoutcompose.datamodel.ImageResponse
import retrofit2.Response
import retrofit2.http.GET

interface ImageAPI {

    @GET("/v2/list")
    suspend fun getImages(): Response<ImageResponse>
}