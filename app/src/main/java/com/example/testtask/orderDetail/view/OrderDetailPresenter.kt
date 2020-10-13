package com.example.testtask.orderDetail.view


import android.util.Log
import com.example.currency.data.ProductRepository

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class OrderDetailPresenter(val view: OrderDetailContract.View): OrderDetailContract.Presenter, CoroutineScope  {
    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private val repository = ProductRepository()
    lateinit var product: Product

    override fun getProducts(id:Int){

        GlobalScope.launch(Dispatchers.IO){
            product = repository.getOrderById(id).await()!!

            withContext(Dispatchers.Main){
                view.setData(product)
            }
        }
    }

}