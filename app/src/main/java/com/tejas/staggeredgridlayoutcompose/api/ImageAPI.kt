package com.tejas.staggeredgridlayoutcompose.api

import com.tejas.staggeredgridlayoutcompose.datamodel.ImageResponse

interface ImageAPI {

    fun getImages(): List<ImageResponse>
}