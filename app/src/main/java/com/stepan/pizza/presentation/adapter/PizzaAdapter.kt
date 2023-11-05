package com.stepan.pizza.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.stepan.pizza.databinding.ItemPizzaBinding
import com.stepan.pizza.presentation.model.PizzaUI

class PizzaAdapter (private val pizzaList: List<PizzaUI>) : RecyclerView.Adapter<PizzaAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemPizzaBinding) : RecyclerView.ViewHolder(binding.root) {
        val textName = binding.textName
        val image = binding.imageProduct
        val textDescription = binding.textDescription
        val textPrice = binding.textPrice
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPizzaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pizza = pizzaList[position]
        holder.textName.text = pizza.name
        holder.textDescription.text = pizza.description
        holder.textPrice.text = "от ${pizza.price} Р"
        Picasso.get().load(pizza.img).into(holder.image)
    }

    override fun getItemCount(): Int {
        return pizzaList.size
    }
}