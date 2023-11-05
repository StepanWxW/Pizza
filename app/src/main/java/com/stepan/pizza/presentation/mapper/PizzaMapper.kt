package com.stepan.pizza.presentation.mapper

import com.stepan.pizza.domain.model.PizzaEntity
import com.stepan.pizza.presentation.model.PizzaUI

class PizzaMapper {
    fun mapEntityListToUIList(entityList: List<PizzaEntity>): List<PizzaUI> {
        return entityList.map { pizzaEntity ->
            PizzaUI(pizzaEntity.id, pizzaEntity.name, pizzaEntity.description, pizzaEntity.img, pizzaEntity.price)
        }
    }
}