package com.stepan.pizza.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pizza_table")
data class PizzaEntity (
    @PrimaryKey
    val id: Int,
    val name: String?,
    val description: String?,
    val img: String?,
    val price: Int?
)