package com.stepan.pizza.data.api

import com.stepan.pizza.domain.model.PizzaEntity
import retrofit2.http.GET

interface ApiService {
    @GET("pizzas/")
    suspend fun getPizzaItems(): List<PizzaEntity>
}