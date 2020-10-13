package com.example.testtask.orderList.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testtask.R
import com.example.testtask.orderDetail.view.OrderDetailFragment
import com.example.testtask.orderDetail.view.Product
import com.example.testtask.orderList.OrdersCallback
import com.example.testtask.orderList.adapter.OrderListAdapter
import com.example.testtask.orderList.presenter.OrderListPresenter
import kotlinx.android.synthetic.main.fragment_order_list.*

class OrderListFragment : Fragment(R.layout.fragment_order_list), OrderListContract.View {
    private val presenter = OrderListPresenter(this)
    lateinit var adapter: OrderListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
    }

    fun init() {
        adapter = OrderListAdapter(callback)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        presenter.getProducts()
        et_filter.doAfterTextChanged {
            if (it.isNullOrEmpty().not()) {
                presenter.getProductsByFilter(it.toString())
                adapter.notifyDataSetChanged()
            }
        }
        arrow_back.setOnClickListener {
            et_filter.text.clear()
        }
    }

    override fun setData(products: List<Product>) {
        adapter.addList(products)
    }

    override fun replaceData(products: List<Product>) {
         Log.i("list",products.size.toString())
        adapter.replaceList(products)
    }

    val callback = object : OrdersCallback {
        override fun setList(list: List<Product>) {
        }

        override fun openFragment(order_id: Int, number: Int) {
            val fragment = OrderDetailFragment()
            val bundle = Bundle()
            bundle.putInt("key", order_id)
            bundle.putInt("number", number)
            fragment.arguments = bundle

            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container,fragment)
                ?.addToBackStack(null)
                ?.commit()
        }
    }


}