package com.example.testtask.orderList.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testtask.R
import com.example.testtask.orderDetail.view.Product
import com.example.testtask.orderList.OrdersCallback
import com.example.testtask.orderList.adapter.OrderListAdapter
import com.example.testtask.orderList.presenter.OrderListPresenter
import kotlinx.android.synthetic.main.fragment_order_list.*

class OrderListFragment: Fragment(R.layout.fragment_order_list), OrderListContract.View{
    private val presenter = OrderListPresenter(this)
   lateinit var adapter: OrderListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
    }

    fun init(){
        adapter = OrderListAdapter(callback)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        presenter.getProducts()
    }

    override fun setData(products: List<Product>) {
        adapter.addList(products)
    }

    val callback= object : OrdersCallback{
        override fun setList(list: List<Product>) {

        }

    }
}