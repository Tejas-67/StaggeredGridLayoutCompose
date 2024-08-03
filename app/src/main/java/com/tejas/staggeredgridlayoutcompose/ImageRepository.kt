package com.tejas.staggeredgridlayoutcompose

import com.tejas.staggeredgridlayoutcompose.datamodel.ImageItem
import kotlinx.coroutines.flow.Flow

interface ImageRepository {
    suspend fun getImages(): Flow<Resource<List<ImageItem>>>
}