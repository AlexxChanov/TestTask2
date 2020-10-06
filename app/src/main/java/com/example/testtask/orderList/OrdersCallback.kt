package com.example.testtask.orderList

import com.example.testtask.orderDetail.view.Product

interface OrdersCallback {
    fun setList(list: List<Product>)
}