package com.tejas.staggeredgridlayoutcompose

sealed class Resource<T>(data: T? = null, message: String? = null) {

    class Success<T>(
        private val data: T?
    ): Resource<T>(data, null)

    class Error<T>(
        private val message: String? = null
    ): Resource<T>(null, message)

    class Loading<T>(
        private val message: String? = null,
        private val data: T? = null
    ): Resource<T>(data, message)

}