package com.stepan.pizza.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.stepan.pizza.databinding.ItemPromotionBinding
import com.stepan.pizza.presentation.model.PromotionModel

class PromotionAdapter(private val promotionList: List<PromotionModel>) : RecyclerView.Adapter<PromotionAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemPromotionBinding) : RecyclerView.ViewHolder(binding.root) {
        val imageView: ImageView = binding.imagePromotion
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPromotionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val promotionModel = promotionList[position]
        Picasso.get().load(promotionModel.imageUrl).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return promotionList.size
    }
}





