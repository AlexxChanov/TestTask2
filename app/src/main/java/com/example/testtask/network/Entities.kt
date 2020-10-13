package com.example.testtask.orderDetail.view

import com.google.gson.annotations.SerializedName

data class Products(
    @SerializedName("data") val products: List<Product>
)

data class Product(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("short_description") val description: String,
    @SerializedName("image_url") val image_url: String,
    @SerializedName("amount") val amount: Int,
    @SerializedName("price") val price: Double,
    @SerializedName("producer") val producer: String,
    @SerializedName("categories") val categories: List<Category>
)

data class Category(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("parent_id") val parent_id: Int,

)

/*
* {
  "data": [
    [
      {
        "id": 0,
        "title": "string",
        "short_description": "string",
        "image_url": "string",
        "amount": 0,
        "price": 0,
        "producer": "string",
        "categories": [
          [
            {
              "id": 0,
              "title": "string",
              "parent_id": 0
            }
          ]
        ]
      }
    ]
  ]
}
* */