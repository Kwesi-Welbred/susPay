package com.example.kotlin.repository

import com.example.kotlin.network.AuthHttpRequest
import com.example.kotlin.network.UserApi

class UserRepository(private val api: UserApi) : BaseRepository(api) {
    suspend fun getLogin() = safeApiCall { api.loginUser() }
    suspend fun registerUser() = safeApiCall { api.registerUser() }

}