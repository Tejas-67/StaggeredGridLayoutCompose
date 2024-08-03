package com.tejas.staggeredgridlayoutcompose.presentation

import androidx.lifecycle.ViewModel
import com.tejas.staggeredgridlayoutcompose.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    private val repository: ImageRepository
): ViewModel() {

}