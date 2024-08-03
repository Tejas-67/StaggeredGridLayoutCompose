package com.tejas.staggeredgridlayoutcompose

import com.tejas.staggeredgridlayoutcompose.datamodel.ImageItem

data class HomeScreenState(
    var images: List<ImageItem>? = emptyList(),
    var isLoading: Boolean = false,
    var error: String? = null
)
