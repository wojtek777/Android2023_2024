package com.example.dao

import com.example.models.Product
import com.example.models.Products
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.*

class DAOFacadeImpl : DAOFacade {
    private fun resultRowToProduct(row: ResultRow) = Product(
        id = row[Products.id],
        name = row[Products.name],
        country = row[Products.country],
        price = row[Products.price]
    )

    override suspend fun allProducts(): List<Product> = dbQuery
    {
        Products.selectAll().map(::resultRowToProduct)
    }

    override suspend fun product(id: Int): Product? = dbQuery
    {
        Products
            .select { Products.id eq id }
            .map(::resultRowToProduct)
            .singleOrNull()
    }

    override suspend fun addNewProduct(name: String, country: String, price: Double): Product? = dbQuery
    {
        val insertStatement = Products.insert
        {
            it[Products.name] = name
            it[Products.country] = country
            it[Products.price] = price
        }
        insertStatement.resultedValues?.singleOrNull()?.let(::resultRowToProduct)
    }
}

val dao: DAOFacade = DAOFacadeImpl().apply {
    runBlocking {
        if(allProducts().isEmpty())
        {
            addNewProduct("jabłko", "Polska", 1.50)
        }
    }
}