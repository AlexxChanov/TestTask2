package com.example.testtask.orderDetail.view


import com.example.testtask.network.ApiGood
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductApi {

    @GET("api/v1/products")
    fun getProducts(): Call<Products>

    @GET("api/v1/products")
    fun getProductByTitle(@Query("title") title: String): Call<Products>

    @GET("api/v1/products/{productId}")
    fun getProduct(
        @Path("productId") productId: Int
    ): Call<ApiGood.Good>




}