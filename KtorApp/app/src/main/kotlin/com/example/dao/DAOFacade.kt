package com.example.dao

import com.example.models.Product

interface DAOFacade
{
    suspend fun allProducts(): List<Product>
    suspend fun product(id: Int): Product?
    suspend fun addNewProduct(name: String, country: String, price: Double): Product?
}