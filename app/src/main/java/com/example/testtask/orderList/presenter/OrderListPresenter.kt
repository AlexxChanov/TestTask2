package com.example.testtask.orderList.presenter

import android.icu.text.CaseMap
import android.util.Log
import android.widget.Toast
import com.example.currency.data.ProductRepository
import com.example.testtask.orderDetail.view.Product
import com.example.testtask.orderList.model.OrderListModel
import com.example.testtask.orderList.view.OrderListContract
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class OrderListPresenter(val view: OrderListContract.View): OrderListContract.Presenter, CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Main
    private val repository = ProductRepository()
    private var products: List<Product>? = listOf()


    override fun getProducts(){
        GlobalScope.launch(Dispatchers.IO){
            products = repository.getOrder().await()!!
            withContext(Dispatchers.Main){
                view.setData(products!!)
            }
        }
    }

    override fun getProductsByFilter(title: String){
        GlobalScope.launch(Dispatchers.IO){


           val productsByTitle = repository.getOrderByTitle(title).await()

                withContext(Dispatchers.Main){
                    productsByTitle?.let { view.replaceData(it.products) }
                }
        }
    }
}