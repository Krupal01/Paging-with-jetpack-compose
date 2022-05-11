package com.example.pagination_jetpack_compose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.pagination_jetpack_compose.model.UserItem
import com.example.pagination_jetpack_compose.pagingsource.UserSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userSource: UserSource) : ViewModel() {
    val userListFlow : Flow<PagingData<UserItem>> = Pager(PagingConfig(pageSize = 6)) {
        userSource
    }.flow.cachedIn(viewModelScope)
}