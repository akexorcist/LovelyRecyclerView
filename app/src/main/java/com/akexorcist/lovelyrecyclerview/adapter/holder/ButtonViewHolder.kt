package com.akexorcist.lovelyrecyclerview.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.akexorcist.lovelyrecyclerview.databinding.ViewButtonBinding

class ButtonViewHolder(private val binding: ViewButtonBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(
        onPositiveClicked: () -> Unit,
        onNegativeClicked: () -> Unit
    ) {
        binding.btnPositive.setOnClickListener { onPositiveClicked.invoke() }
        binding.btnNegative.setOnClickListener { onNegativeClicked.invoke() }
    }
}
