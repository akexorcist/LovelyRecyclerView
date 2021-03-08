package com.akexorcist.lovelyrecyclerview.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.akexorcist.lovelyrecyclerview.adapter.model.OrderDetailItem
import com.akexorcist.lovelyrecyclerview.databinding.ViewSectionBinding

class SectionViewHolder(private val binding: ViewSectionBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: OrderDetailItem.Section) {
        binding.tvSection.text = item.section
        binding.layoutSectionContainer.setBackgroundColor(item.backgroundColor)
    }
}
