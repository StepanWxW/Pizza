package com.stepan.pizza.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.stepan.pizza.R
import com.stepan.pizza.databinding.ItemTitleBinding
import com.stepan.pizza.presentation.model.TitleUI

class TitleUIAdapter (private val titleList: List<TitleUI>) : RecyclerView.Adapter<TitleUIAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemTitleBinding) : RecyclerView.ViewHolder(binding.root) {
        val titleText = binding.textTitle
        val layoutTitle = binding.layoutTitle
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val title = titleList[position]
        holder.titleText.text = title.name
        if(title.isActive){
            holder.titleText.setTextColor(ContextCompat.getColor(holder.titleText.context, R.color.pink))
            holder.layoutTitle.setBackgroundResource(R.drawable.rounded_rectangle_title_active)
        } else {
            holder.titleText.setTextColor(ContextCompat.getColor(holder.titleText.context, R.color.light_grey))
            holder.layoutTitle.setBackgroundResource(R.drawable.rounded_rectangle_title_inactive)
        }

        val marginLeftInDp: Float = if (position == 0) 16f else 0f
        val context = holder.layoutTitle.context
        val marginLeftInPx = (marginLeftInDp * context.resources.displayMetrics.density).toInt()

        val layoutParams = holder.layoutTitle.layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.leftMargin = marginLeftInPx
        holder.layoutTitle.layoutParams = layoutParams
    }

    override fun getItemCount(): Int {
        return titleList.size
    }
}