package com.example.testtask.orderDetail.view

import com.example.testtask.orderDetail.view.Product

interface OrderDetailContract {

    interface View {
        fun setData(product: Product)

    }

    interface Presenter{
        fun getProducts(id: Int)

    }

    interface Model{
        fun getProductList()
    }
}