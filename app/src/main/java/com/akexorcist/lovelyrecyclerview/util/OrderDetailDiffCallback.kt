package com.akexorcist.lovelyrecyclerview.util

import androidx.recyclerview.widget.DiffUtil
import com.akexorcist.lovelyrecyclerview.adapter.model.OrderDetailItem

class OrderDetailDiffCallback(
    private val oldItems: List<OrderDetailItem>?,
    private val newItems: List<OrderDetailItem>?
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldItems?.size ?: 0

    override fun getNewListSize(): Int = newItems?.size ?: 0

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems?.getOrNull(oldItemPosition) === newItems?.getOrNull(newItemPosition)
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems?.getOrNull(oldItemPosition) == newItems?.getOrNull(newItemPosition)
    }
}
