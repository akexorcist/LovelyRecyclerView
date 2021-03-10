package com.akexorcist.lovelyrecyclerview.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.akexorcist.lovelyrecyclerview.adapter.model.OrderDetailItem
import com.akexorcist.lovelyrecyclerview.databinding.ViewOrderBinding

class OrderViewHolder(private val binding: ViewOrderBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: OrderDetailItem.Order) {
        binding.tvOrderName.text = item.name
        binding.tvOrderDetail.text = item.detail
        binding.tvOrderPrice.text = item.price
    }
}
