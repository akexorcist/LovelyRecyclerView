package com.akexorcist.lovelyrecyclerview.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.akexorcist.lovelyrecyclerview.adapter.model.OrderDetailItem
import com.akexorcist.lovelyrecyclerview.databinding.ViewTitleBinding

class TitleViewHolder(private val binding: ViewTitleBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: OrderDetailItem.Title) {
        binding.tvTitle.text = item.title
    }
}
