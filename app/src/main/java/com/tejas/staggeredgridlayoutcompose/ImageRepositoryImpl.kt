package com.tejas.staggeredgridlayoutcompose

import android.util.Log
import com.tejas.staggeredgridlayoutcompose.api.ImageAPI
import com.tejas.staggeredgridlayoutcompose.datamodel.ImageItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    val api: ImageAPI
): ImageRepository {

    override suspend fun getImages(): Flow<Resource<List<ImageItem>>> {
        return flow {
            emit(Resource.Loading())

            val data = try {
                val response = api.getImages()
                response.body() as List<ImageItem>
            } catch(e: Exception) {
                Log.w("TAGGG", "data error: $e")
                emit(Resource.Error(message = e.message))
                null
            }

            data?.let { d ->
                emit(Resource.Success(d))
            }
        }
    }
}