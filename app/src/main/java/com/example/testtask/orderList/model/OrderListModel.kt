package com.example.testtask.orderList.model

import android.util.Log
import com.example.currency.data.ProductRepository
import com.example.testtask.orderDetail.view.Product
import com.example.testtask.orderDetail.view.Products
import com.example.testtask.orderList.view.OrderListContract
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class OrderListModel:OrderListContract.Model,CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Main
    private val repository = ProductRepository()
    private var products: List<Product> = listOf()



    override fun getProductList(): List<Product> {
        launch {
            products = repository.getOrder().await()!!
            Log.d("LOG TAG",products.size.toString())

        }

    }

}