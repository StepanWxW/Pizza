package com.stepan.pizza.domain

import com.stepan.pizza.data.db.PizzaDao
import com.stepan.pizza.domain.model.PizzaEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

class GetPizzaUseCase (private val pizzaRepository: PizzaRepository, private val pizzaDao: PizzaDao) {
    suspend fun getPizzas(): List<PizzaEntity> {
        val isInternetAvailable = checkInternetAvailability()
        return if (isInternetAvailable) {
            val pizzas = pizzaRepository.getPizzasApi()
            pizzaDao.clearAllPizzas()
            pizzaDao.insertAllPizzas(pizzas)
            pizzas
        } else {
            pizzaDao.getAllPizzas()
        }
    }

    private suspend fun checkInternetAvailability(): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val process = Runtime.getRuntime().exec("ping -c 1 google.com")
                val exitValue = process.waitFor()
                return@withContext (exitValue == 0)
            } catch (e: IOException) {
                return@withContext false
            }
        }
    }
}