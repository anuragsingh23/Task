package com.example.task.model.response
import android.support.annotation.Keep
import com.example.task.utils.Constants

import kotlinx.serialization.Serializable

import kotlinx.serialization.SerialName



    @Keep
    @Serializable
    data class Response(
        @SerialName("data")
        val `data`: Data,
        @SerialName("message")
        val message: String
    )

    @Keep
    @Serializable
    data class Data(
        @SerialName("record")
        val record: Record
    )

    @Keep
    @Serializable
    data class Record(
        @SerialName("_id")
        val id: String,
        @SerialName("name")
        val name: String,
        @SerialName("roles")
        val roles: List<Role>
    )

    @Keep
    @Serializable
    data class Role(
        @SerialName("_id")
        val id: String,
        @SerialName("max_redeem_l")
        val maxRedeemL: Int,
        @SerialName("min_redeem_l")
        val minRedeemL: Int,
        @SerialName("name")
        val name: String,
        @SerialName("url")
        val url: String
    ){
        fun getImageUrl(): String{
            return  Constants.BASE_URL +"/" + url
        }
    }
