package com.example.zadaniebazydanych.fragment.products

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zadaniebazydanych.Database
import com.example.zadaniebazydanych.R
import com.example.zadaniebazydanych.fragment.basket.BasketAdapter

class ProductsFragment : Fragment() {

    lateinit var recyclerView: RecyclerView;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_products, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        recyclerView = itemView.findViewById<RecyclerView>(R.id.recyclerViewProducts)
        val products = Database.getProducts();

        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ProductListAdapter(products)
        }
    }

    fun Notify() {
        if(this::recyclerView.isInitialized) {
            val products = Database.getProducts();
            recyclerView.apply {
                adapter = ProductListAdapter(products)
            }
        }
    }
}