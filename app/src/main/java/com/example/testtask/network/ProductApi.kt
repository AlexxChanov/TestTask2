package com.example.testtask.orderDetail.view


import retrofit2.Call
import retrofit2.http.GET

interface ProductApi {

    @GET("api/v1/products")
    fun getProducts(): Call<Products>
}