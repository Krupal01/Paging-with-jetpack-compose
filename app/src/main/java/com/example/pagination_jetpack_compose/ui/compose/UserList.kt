package com.example.pagination_jetpack_compose.ui.compose

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.pagination_jetpack_compose.model.UserItem
import com.example.pagination_jetpack_compose.viewmodel.UserViewModel
import kotlinx.coroutines.flow.Flow

@Composable
fun UserList(
    modifier: Modifier = Modifier,
    viewModel : UserViewModel,
    context : Context
){
    UserInfoList(modifier = modifier, userList = viewModel.userListFlow, context = context )
}

@Composable
fun UserInfoList(
    modifier: Modifier,
    userList : Flow<PagingData<UserItem>>,
    context: Context
){
    val userListItems: LazyPagingItems<UserItem> = userList.collectAsLazyPagingItems()

    LazyColumn{
        items(userListItems){item: UserItem? ->
            if (item != null) {
                UserRowItem(userItem = item , onClick = {
                    Toast.makeText(context,item.id.toString(),Toast.LENGTH_SHORT).show()
                })
            }
        }
    }
}