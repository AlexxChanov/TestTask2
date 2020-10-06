package com.example.testtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testtask.orderList.view.OrderListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, OrderListFragment())
            .addToBackStack(null)
            .commit()
    }
}