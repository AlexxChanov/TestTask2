package com.example.testtask.network

import com.example.testtask.orderDetail.view.Product
import com.google.gson.annotations.SerializedName

interface ApiGood {
    data class Good(
        @SerializedName("data")
        var product: Product
    )
}