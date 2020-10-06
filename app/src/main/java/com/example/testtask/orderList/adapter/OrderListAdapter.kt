package com.example.testtask.orderList.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testtask.R
import com.example.testtask.orderDetail.view.Product
import com.example.testtask.orderList.OrdersCallback

class OrderListAdapter(private val callBack: OrdersCallback): RecyclerView.Adapter<OrderListAdapter.VHOrder>() {
    private var orders: List<Product> = mutableListOf()
    var builder: StringBuilder = java.lang.StringBuilder()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHOrder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.order_item,parent,false)
        val holder = VHOrder(view)

        return holder
    }

    override fun onBindViewHolder(holder: VHOrder, position: Int) {
        Glide.with(holder.itemView).load(orders[position].image_url).into(holder.image)
        holder.product.text = orders[position].title
        holder.producer.text = orders[position].producer
        orders[position].categories.forEach {
            builder.append("${it.title},")
        }
        holder.category.text = builder
        holder.product.text = orders[position].title
        holder.price.text = orders[position].price.toString()
    }

    override fun getItemCount(): Int {
        return orders.size
    }

    fun addList(products: List<Product>){
        orders = products
        notifyDataSetChanged()

    }

    class VHOrder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.findViewById(R.id.order_item_iv)
        val producer: TextView = itemView.findViewById(R.id.order_detail_maker)
        val product: TextView = itemView.findViewById(R.id.order_item_product)
        val price: TextView = itemView.findViewById(R.id.order_item_price)
        val category: TextView = itemView.findViewById(R.id.order_item_category)
    }
}