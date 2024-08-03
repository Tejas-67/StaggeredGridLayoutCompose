package com.tejas.staggeredgridlayoutcompose

sealed class Resource<T>(data: T? = null, message: String? = null) {
    class Success<T>(
        val data: T?
    ): Resource<T>(data, null)

    class Error<T>(
        val message: String? = null
    ): Resource<T>(null, message)

    class Loading<T>(
        val message: String? = null,
        val data: T? = null
    ): Resource<T>(data, message)
}