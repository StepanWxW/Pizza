package com.stepan.pizza.domain

import com.stepan.pizza.domain.model.PizzaEntity

interface PizzaRepository {
    suspend fun getPizzasApi(): List<PizzaEntity>
}