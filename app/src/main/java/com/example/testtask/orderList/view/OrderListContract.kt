package com.example.testtask.orderList.view

import com.example.testtask.orderDetail.view.Product

interface OrderListContract {

    interface View {
        fun setData(products: List<Product>)

    }

    interface Presenter{
        fun getProducts()
    }

    interface Model{
        fun getProductList(): List<Product>
    }
}