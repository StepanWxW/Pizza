package com.stepan.pizza.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.stepan.pizza.domain.model.PizzaEntity

@Database(entities = [PizzaEntity::class], version = 1)
abstract class PizzaDatabase : RoomDatabase() {
    abstract fun pizzaDao(): PizzaDao

    companion object {
        @Volatile
        private var INSTANCE: PizzaDatabase? = null

        fun getDatabase(context: Context): PizzaDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PizzaDatabase::class.java,
                    "pizza_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}