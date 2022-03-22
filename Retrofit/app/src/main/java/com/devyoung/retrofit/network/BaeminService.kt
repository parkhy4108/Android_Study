package com.devyoung.retrofit.network

import com.devyoung.retrofit.Baemin
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BaeminService {
    @GET("contents?typeCode=notice&size=10")
    fun loadNotice(@Query("page") page : String) : Call<Baemin>
}