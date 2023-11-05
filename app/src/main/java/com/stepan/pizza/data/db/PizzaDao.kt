package com.stepan.pizza.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.stepan.pizza.domain.model.PizzaEntity

@Dao
interface PizzaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPizzas(pizzas: List<PizzaEntity>)

    @Query("SELECT * FROM pizza_table")
    suspend fun getAllPizzas(): List<PizzaEntity>
    @Query("DELETE FROM pizza_table")
    suspend fun clearAllPizzas()
}