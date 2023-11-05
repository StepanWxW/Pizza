package com.stepan.pizza.data

import com.stepan.pizza.data.api.ApiClient
import com.stepan.pizza.domain.PizzaRepository
import com.stepan.pizza.domain.model.PizzaEntity

class PizzaRepositoryImpl: PizzaRepository {
    override suspend fun getPizzasApi(): List<PizzaEntity> {
        return ApiClient.apiService.getPizzaItems()
    }
}