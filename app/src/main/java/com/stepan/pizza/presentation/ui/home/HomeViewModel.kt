package com.stepan.pizza.presentation.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.stepan.pizza.data.PizzaRepositoryImpl
import com.stepan.pizza.data.db.PizzaDatabase
import com.stepan.pizza.domain.GetPizzaUseCase
import com.stepan.pizza.domain.model.PizzaEntity
import com.stepan.pizza.presentation.mapper.PizzaMapper
import com.stepan.pizza.presentation.model.PizzaUI
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException

class HomeViewModel (application: Application) : AndroidViewModel(application) {
    private val pizzaDao = PizzaDatabase.getDatabase(application).pizzaDao()
    val pizzaUseCase = GetPizzaUseCase(PizzaRepositoryImpl(), pizzaDao)
    private val _pizzas = MutableLiveData<List<PizzaUI>>()
    val pizzas: LiveData<List<PizzaUI>> get() = _pizzas
    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> get() = _errorLiveData
    init {
        getPizzas()
    }
    private fun getPizzas() {
        viewModelScope.launch {
            try {
                val pizzas = pizzaUseCase.getPizzas()
                _pizzas.value = PizzaMapper().mapEntityListToUIList(pizzas)
            } catch (e: Exception) {
                handlerException(e)
            }
        }
    }

    private fun handlerException(e: Exception) {
        when (e) {
            is SocketTimeoutException -> {
                _errorLiveData.value = "Сервер не отвечает"
            }
            else -> {
                _errorLiveData.value = "Не известная ошибка"
            }
        }
    }
}