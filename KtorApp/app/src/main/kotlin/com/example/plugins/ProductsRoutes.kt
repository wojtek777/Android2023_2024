package com.example.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import com.example.dao.*

fun Route.products()
{
    get("/products")
    {
        val products = dao.allProducts()
        call.respond(products)
    }
    get("/product-{id?}")
    {
        val idString = call.parameters["id"] ?: return@get call.respondText { "Invalid ID" }
        val id = idString.toInt()
        val product = dao.product(id) ?: return@get call.respondText { "No product of this type available" }
        call.respond(product)
    }
}

fun Application.productsRoutes()
{
    routing
    {
        products()
    }
}
