package com.example.testtask.orderList.view

import com.example.testtask.orderDetail.view.Product

interface OrderListContract {

    interface View {
        fun setData(products: List<Product>)
        fun replaceData(products: List<Product>)

    }

    interface Presenter{
        fun getProducts()
        fun getProductsByFilter(title: String)
    }

    interface Model{
        fun getProductList()
    }
}