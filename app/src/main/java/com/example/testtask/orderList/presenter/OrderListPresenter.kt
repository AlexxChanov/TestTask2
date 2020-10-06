package com.example.testtask.orderList.presenter

import com.example.testtask.orderList.model.OrderListModel
import com.example.testtask.orderList.view.OrderListContract
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class OrderListPresenter(val view: OrderListContract.View): OrderListContract.Presenter, CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Main
    private val model = OrderListModel()

    override fun getProducts(){
        launch {

        }
        view.setData(model.getProductList())
    }

}