package com.example.testtask.orderDetail.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.testtask.R
import kotlinx.android.synthetic.main.fragment_order_detail.*
import kotlinx.android.synthetic.main.fragment_order_list.*
import java.lang.StringBuilder

class OrderDetailFragment : Fragment(R.layout.fragment_order_detail), OrderDetailContract.View {
    private val presenter = OrderDetailPresenter(this)
    private var count = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        count = arguments?.getInt("number")!!
        init()
        presenter.getProducts(arguments?.getInt("key")!!)

    }

    private fun init() {
        number_detail.text = count.toString()
        arrow_back_detail.setOnClickListener { requireActivity().onBackPressed() }
        if (count>0){
            control_detail.visibility = View.VISIBLE
            store_btn_detail.visibility = View.GONE
        }
        store_btn_detail.setOnClickListener {
            store_btn_detail.visibility = View.INVISIBLE
            control_detail.visibility = View.VISIBLE
            count += 1
            number_detail.text = count.toString()
        }
        add_btn_detail.setOnClickListener {
            count++
            number_detail.text = count.toString()
        }
        remove_btn_detail.setOnClickListener {
            count--
            number_detail.text = count.toString()
            if (count == 0) {
                control_detail.visibility = View.GONE
                store_btn_detail.visibility = View.VISIBLE
            }
        }
    }

    override fun setData(product: Product) {
        val builder = StringBuilder()
        product.categories.forEach {
            builder.append("${it.title} ,")
        }
        order_detail_category.text = builder
        order_detail_description.text = product.description
        order_detail_price.text = product.price.toString()
        order_detail_maker.text = product.producer
        order_detail_product.text = product.title
        number_detail.text = count.toString()

        Glide.with(requireContext()).load(product.image_url).centerCrop().into(order_detail_iv)


    }
}