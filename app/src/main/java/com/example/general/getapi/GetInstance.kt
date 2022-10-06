package com.example.general.getapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GetInstance {


        private var BaseUrlcomments="https://jsonplaceholder.typicode.com/"
        private val getInterface:GetInterface?=null
        fun getInstance():GetInterface{
            return Retrofit.Builder().baseUrl(BaseUrlcomments)
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(GetInterface::class.java)
            return getInterface!!
        }

    private var BaseurlPosts="https://jsonplaceholder.typicode.com/"
    private val getInterfacee:GetInterface?=null
    fun getInstancee():GetInterface{
        return Retrofit.Builder().baseUrl(BaseurlPosts)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(GetInterface::class.java)
        return getInterfacee!!
    }
    }
