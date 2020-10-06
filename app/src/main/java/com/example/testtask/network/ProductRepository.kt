package com.example.currency.data

import com.example.testtask.orderDetail.view.ProductApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.CoroutineContext

class ProductRepository : CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.IO

    private val currencyApi = Retrofit.Builder()
        .baseUrl("https://rstestapi.redsoftdigital.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ProductApi::class.java)



    fun getOrder() = async {
        currencyApi.getProducts()
            .execute()
            .body()
            ?.products
    }


}