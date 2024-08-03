package com.tejas.staggeredgridlayoutcompose.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tejas.staggeredgridlayoutcompose.HomeScreenState
import com.tejas.staggeredgridlayoutcompose.ImageRepository
import com.tejas.staggeredgridlayoutcompose.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    private val repository: ImageRepository
): ViewModel() {

    var state by mutableStateOf(HomeScreenState())

    init {
        getImages()
    }

    private fun getImages(){
        viewModelScope.launch {
            repository.getImages().collect{ result ->
                when(result){
                    is Resource.Loading -> {
                        state = HomeScreenState(
                            images = null,
                            isLoading = true,
                            error = null
                        )
                    }
                    is Resource.Error -> {
                        state = HomeScreenState(
                            images = null,
                            isLoading = false,
                            error = result.message
                        )
                    }
                    is Resource.Success -> {
                        state = HomeScreenState(
                            images = result.data,
                            isLoading = false,
                            error = null
                        )
                    }
                }
            }
        }
    }

}