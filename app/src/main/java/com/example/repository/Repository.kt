package com.example.repository

import com.example.task.data.network.RetrofitInstance
import com.example.task.model.response.Role

class Repository {

    suspend fun getRoles() : List<Role> {
       return RetrofitInstance.api.getRoles().data.record.roles
    }
}