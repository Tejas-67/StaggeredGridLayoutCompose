package com.tejas.staggeredgridlayoutcompose

import com.tejas.staggeredgridlayoutcompose.api.ImageAPI
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    val api: ImageAPI
): ImageRepository {
    override fun getImages() {

    }
}