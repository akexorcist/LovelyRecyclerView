package com.akexorcist.lovelyrecyclerview.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.akexorcist.lovelyrecyclerview.adapter.model.OrderDetailItem
import com.akexorcist.lovelyrecyclerview.databinding.ViewUserDetailBinding

class UserDetailViewHolder(private val binding: ViewUserDetailBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: OrderDetailItem.UserDetail) {
        binding.tvUserName.text = item.name
    }
}
