package com.example.pagination_jetpack_compose.network

import com.example.pagination_jetpack_compose.model.UserResponce
import com.example.pagination_jetpack_compose.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    @GET(Constants.USERS)
    suspend fun getUsers(@Query(Constants.QUERY_PAGE)page : Int) : UserResponce
}