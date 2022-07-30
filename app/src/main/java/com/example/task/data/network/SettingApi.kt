package com.example.task.data.network

import com.example.task.model.Roles
import retrofit2.http.GET

interface SettingApi {

    @GET("web/config/setting")
    suspend fun getRoles(): Roles
}