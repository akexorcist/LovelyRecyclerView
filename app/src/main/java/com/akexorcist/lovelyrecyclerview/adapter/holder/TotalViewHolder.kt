package com.akexorcist.lovelyrecyclerview.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.akexorcist.lovelyrecyclerview.adapter.model.OrderDetailItem
import com.akexorcist.lovelyrecyclerview.databinding.ViewTotalBinding

class TotalViewHolder(private val binding: ViewTotalBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: OrderDetailItem.Total) {
        binding.tvTotalPrice.text = item.totalPrice
    }
}
