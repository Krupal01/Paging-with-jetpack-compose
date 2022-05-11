package com.example.pagination_jetpack_compose.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pagination_jetpack_compose.model.UserItem
import com.example.pagination_jetpack_compose.network.UserService
import java.lang.Exception
import javax.inject.Inject

class UserSource @Inject constructor(private val userService: UserService) : PagingSource<Int, UserItem>() {
    override fun getRefreshKey(state: PagingState<Int, UserItem>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserItem> {
        return try {

            val nextPage = params.key ?: 1
            val userList = userService.getUsers(page = nextPage)

            LoadResult.Page(
                data = userList.data,
                prevKey = if (nextPage == 1) null else nextPage-1,
                nextKey = if (userList.data.isEmpty()) null else nextPage+1
            )

        } catch (e : Exception){
            LoadResult.Error(e)
        }
    }
}