package com.stepan.pizza.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.stepan.pizza.databinding.ItemPromotionBinding
import com.stepan.pizza.presentation.model.PromotionUI

class PromotionAdapter(private val promotionList: List<PromotionUI>) : RecyclerView.Adapter<PromotionAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemPromotionBinding) : RecyclerView.ViewHolder(binding.root) {
        val imageView: ImageView = binding.imagePromotion
        val cardViewForImageView: CardView = binding.cardViewForImageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPromotionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val promotionModel = promotionList[position]
        Picasso.get().load(promotionModel.imageUrl).into(holder.imageView)
        val marginLeftInDp: Float = if (position == 0) 16f else 0f
        val context = holder.cardViewForImageView.context
        val marginLeftInPx = (marginLeftInDp * context.resources.displayMetrics.density).toInt()

        val layoutParams = holder.cardViewForImageView.layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.leftMargin = marginLeftInPx
        holder.cardViewForImageView.layoutParams = layoutParams
    }

    override fun getItemCount(): Int {
        return promotionList.size
    }
}





