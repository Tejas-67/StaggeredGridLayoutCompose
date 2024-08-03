package com.tejas.staggeredgridlayoutcompose.di

import com.tejas.staggeredgridlayoutcompose.ImageRepository
import com.tejas.staggeredgridlayoutcompose.ImageRepositoryImpl
import com.tejas.staggeredgridlayoutcompose.api.ImageAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideImageRepository(api: ImageAPI): ImageRepository {
        return ImageRepositoryImpl(api)
    }
}