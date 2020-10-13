package com.example.testtask.orderList.model

import android.util.Log
import com.example.currency.data.ProductRepository
import com.example.testtask.orderDetail.view.Product
import com.example.testtask.orderDetail.view.Products
import com.example.testtask.orderList.view.OrderListContract
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class OrderListModel:OrderListContract.Model {
    private val repository = ProductRepository()
    private var products: List<Product> = listOf()



    override fun getProductList() {
        GlobalScope.launch(Dispatchers.IO){
            products = repository.getOrder().await()!!
        }
    }


}